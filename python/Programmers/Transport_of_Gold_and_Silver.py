# 금과 은 운반하기

"""
어느 왕국에 하나 이상의 도시들이 있습니다. 왕국의 왕은 새 도시를 짓기로 결정하였습니다. 
해당 도시를 짓기 위해서는 도시를 짓는 장소에 금 a kg과 은 b kg이 전달되어야 합니다.

각 도시에는 번호가 매겨져 있는데, i번 도시에는 금 g[i] kg, 은 s[i] kg, 그리고 트럭 한 대가 있습니다. 
i번 도시의 트럭은 오직 새 도시를 짓는 건설 장소와 i번 도시만을 왕복할 수 있으며, 
편도로 이동하는 데 t[i] 시간이 걸리고, 최대 w[i] kg 광물을 운반할 수 있습니다.(광물은 금과 은입니다. 즉, 금과 은을 동시에 운반할 수 있습니다.) 
모든 트럭은 같은 도로를 여러 번 왕복할 수 있으며 연료는 무한대라고 가정합니다.

정수 a, b와 정수 배열 g, s, w, t가 매개변수로 주어집니다. 주어진 정보를 바탕으로 각 도시의 트럭을 최적으로 운행했을 때, 
새로운 도시를 건설하기 위해 금 a kg과 은 b kg을 전달할 수 있는 가장 빠른 시간을 구해 return 하도록 solution 함수를 완성해주세요.
"""
"""
    a : 목표 금
    b : 목표 은

    g : 도시의 금 소유량
    s : 도시의 은 소유량
    w : 한 번에 운반 가능 광물량
    t : 편도 시간
"""


import sys
def check(time, a, b, g, s, w, t):
    n = len(g)
    total = 0
    gold = 0
    silver = 0
    # 각 도시별로
    for i in range(n):
        # time 동안 옮길 수 있는 횟수
        count = time // (2 * t[i])
        if time % (2 * t[i]) >= t[i]:
            count += 1

        # 시간 안에 옮길 수 있는 무게, (횟수 * 무게) 혹은 전체 금과 은
        tmp = min(count * w[i], g[i] + s[i])
        # 각 도시의 총합 누적  
        total += tmp
        # 금 무게 누적, tmp보다 적은 금/은을 가지면 그 무게를 추가
        gold += min(tmp, g[i])
        # 은 무게 누적
        silver += min(tmp, s[i])

    if total >= a + b and gold >= a and silver >= b: # 전체 수치와 금/은 조건을 만족하는지
        return True
    return False


def solution(a, b, g, s, w, t):
    left = 1
    right = sys.maxsize

    while left + 1 < right:
        mid = (left + right) // 2
        print(f'{left}\t{mid}\t{right}')

        if check(mid, a, b, g, s, w, t):
            right = mid
        else:
            left = mid

    
    return right


print(solution(10, 10, [100], [100], [7], [10]))
print(solution(90, 500, [70, 70, 0], [0, 0, 500], [100, 100, 2], [4, 8, 1]))
