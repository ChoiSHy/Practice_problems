import sys
input = sys.stdin.readline

n = int(input())
budgets = [int(i) for i in input().split()]
total = int(input())


def func(min, max):
    sum = 0
    limit = (min+max)//2
    if ( limit == max or limit == min):
        for i in range(n):
            if budgets[i] > limit+1:
                sum += limit+1
            else:
                sum += budgets[i]
        if sum <= total:
            return limit+1
        else:
            return limit
    
    for i in range(n):
        if budgets[i] > limit:
            sum += limit
        else:
            sum += budgets[i]

    if sum > total :
        return func(min, limit)
    elif sum < total :
        return func(limit, max)
    else:
        return limit

print(func(0 ,max(budgets)))