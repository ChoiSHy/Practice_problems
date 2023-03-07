"""
총 N개의 시험장
각 시험장에는 1명의 총감독과 여러 명의 부감독 있음
i번 시험장 인원: Ai
총감독 감시 가능 인원: B
부감독 감시 가능 인원: C

필요한 감독관 수의 최소값 구하기
"""

N = int(input())
A = [int(a) for a in input().split(' ')]
B,C = [int(v) for v in input().split(' ')]

cnt = N
for i in range(len(A)):
    if A[i] >= B:
        A[i] = A[i]-B

        if A[i] % C == 0:
            cnt += (A[i]//C)
        else:
            cnt += (A[i]//C)+1
    
print(cnt)
