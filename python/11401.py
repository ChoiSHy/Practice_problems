import sys

def power(n,k):
    if k == 0 : 
        return 1
    elif k == 1 : 
        return n

    tmp = power(n, k // 2)

    if (k % 2):
        return (tmp*tmp*n) % p
    else:
        return (tmp*tmp) % p
    
def factorial (n):
    ret = 1
    for i in range(2, n+1):
        ret = (ret * i) % p
    return ret
 
n,k = [int(i) for i in sys.stdin.readline().split()]
p = 1000000007

A = factorial(n)
B = factorial(k) * factorial(n-k)


print( ( A * power(B, p-2) ) % p )
