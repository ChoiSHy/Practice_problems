import sys
input = sys.stdin.readline

n = int(input().rstrip())
S=set()
allSet = set(range(1,21))
for _ in range(n):
    op = input().rstrip().split()
    if op[0] == 'add':
        x = int(op[1])
        S.add(int(x))
    elif op[0] == 'check':
        x = int(op[1])
        if int(x) in S:
            print(1)
        else:
            print(0)
    elif op[0] == 'remove':
        x = int(op[1])
        S.discard(x)
    elif op[0] == 'toggle':
        x = int(op[1])
        try:
            S.remove(int(x))
        except:
            S.add(int(x))
    elif op[0] == 'all':
        S = allSet.copy()
    elif op[0] == 'empty':
        S = set()