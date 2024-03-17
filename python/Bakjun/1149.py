import sys
n = int(sys.stdin.readline())
cost=[]
for i in range(n):
    cost.append([int(k) for k in sys.stdin.readline().split()])
pos = []
pos.append([])
for i in range(3):
    pos[0].append((cost[0][i],i))
for i in range(1,n):
    pos.append([])
    for j in pos[i-1]:
        for k in range(3):
            if j[1] != k:
                pos[i].append((j[0] + cost[i][k],k))
    tmp = sorted(pos[i])[:3]
    for k in tmp:
        if k is not tmp:
            pos[i].remove(k)
for i in pos:
    print(i)
print(min(pos[n-1])[0])