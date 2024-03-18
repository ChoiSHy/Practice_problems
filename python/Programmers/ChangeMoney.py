# <거스름돈> 
# dp 문제
# 사용 가능한 동전별로 dp에 값을 조정하는 방식
# 추가로 각 경우의 수에 중복을 제외해야함

def solution(n, money):
    dp = [0 for _ in range(n+1)]
    dp[0] = 1

    for m in money:
        for i in range(m, n+1):
            dp[i] += dp[i - m]
            print(f'dp[{i}] += dp[{i} - {m}], dp[{i}] = {dp[i]}')
    print(dp[n])
    return dp[n]

 



solution(5, [1,2,5])