a,b,n = map(int, input().split())

for i in range(n):
    dv = a//b
    md = a % b
    a = md * 10
print(a//b)