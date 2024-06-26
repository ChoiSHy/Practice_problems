"""
n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 
최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 
solution을 완성하세요.

다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 
예를 들어 A 섬과 B 섬 사이에 다리가 있고, 
B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.

    A - B - C   <=  가능
"""

def solution(n, costs:list):
    answer = 0
    costs.sort(key=lambda x : x[2])
    root = [i for i in range(n)]

    for i,j,k in costs:
        if(find(root, i) != find(root,j)):
            union(root, i, j) 
            answer+=k
    print(answer)
    return answer

def find(root, x):
    if root[x] == x:
        return x
    return find(root,root[x])
def union(root, x, y):
    x = find(root,x)
    y = find(root,y)

    root[y] = x

solution(4, [[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 1], [2, 3, 8]])
