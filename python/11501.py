def test():
    N = int(input())
    prices=[int(p) for p in input().split()]

    for i in range(len(prices)-1, -1, -1):
        print(i)

    


T = int(input())
out=[]
for t in range(T):
    out.append(test())
for o in out:
    print(o)