"""
오늘부터 N+1일째 되는 날 퇴사를 하기 위해서
최대한 많은 수익을 얻기 위한 상담 일정을 잡기
"""

n = int(input())
slist = []
for i in range(n):
    slist.append(tuple(map(int, input().split(' '))))

def simul(idx, p):
    start = idx + slist[idx][0]
    if start >n :
        return p
    price = p + slist[idx][1]    
    max = price
    for i in range(start, n):
        ret = simul(i, price)
        if max<ret: max=ret
    return max

print(max([simul(i,0) for i in range(n)]))

