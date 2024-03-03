n=1000   
A = 0
B = 1
for j in range(0, n+1):
        if j == n:
            print('res:',A)
            break
        else:
            tmp=B
            B= (A+B)%1000000
            A=tmp