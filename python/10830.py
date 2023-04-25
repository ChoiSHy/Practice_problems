def mul(A:list, B:list):
    l = len(A)
    ret = []
    for i in range(l):
        ret.append([])
        for j in range(l):
            ret[i].append(0)
            for k in range(l):
                ret[i][j] += A[i][k] * B[k][j]
            ret[i][j] %= 1000

    return ret

def double_and_add(A:list, B:str):
    ret = A

    for b in B:
        if b=='1':
            ret = mul(ret, ret)
            ret = mul(ret, A)
        elif b=='0':
            ret = mul(ret, ret)

    for i in range(len(A)):
        for j in range(len(A)):
            ret[i][j] %= 1000
    return ret
    
def print_(A:list):
    l = len(A)
    for i in range(l):
        for j in range(l):
            print(A[i][j], end=' ')
        print()


n, b = [int(i) for i in input().split()]
A=[]
for i in range(n):
    A.append([int(j) for j in input().split()])

print_(double_and_add(A, bin(b)[3:]))
