""" <사칙연산>
사칙연산에서 더하기(+)는 결합법칙이 성립하지만, 빼기(-)는 결합법칙이 성립하지 않습니다.
예를 들어 식 1 - 5 - 3은 연산 순서에 따라 다음과 같이 다른 결과를 가집니다.

((1 - 5) - 3) = -7
(1 - (5 - 3)) = -1
위 예시와 같이 뺄셈은 연산 순서에 따라 그 결과가 바뀔 수 있습니다.
또 다른 예로 식 1 - 3 + 5 - 8은 연산 순서에 따라 다음과 같이 5가지 결과가 나옵니다.

(((1 - 3) + 5) - 8) = -5
((1 - (3 + 5)) - 8) = -15
(1 - ((3 + 5) - 8)) = 1
(1 - (3 + (5 - 8))) = 1
((1 - 3) + (5 - 8)) = -5
위와 같이 서로 다른 연산 순서의 계산 결과는 [-15, -5, -5, 1, 1]이 되며, 이중 최댓값은 1입니다.
문자열 형태의 숫자와, 더하기 기호("+"), 뺄셈 기호("-")가 들어있는 배열 arr가 매개변수로 주어질 때, 
서로 다른 연산순서의 계산 결과 중 최댓값을 return 하도록 solution 함수를 완성해 주세요.
"""

INF = 1000000

def solution(arr):
    nums = [int(arr[i]) for i in range(0,len(arr), 2)]
    ops = [arr[i] for i in range(1, len(arr), 2)]

    n = len(nums)

    min_dp = [[INF for _ in range(n)] for __ in range(n)]
    max_dp = [[-INF for _ in range(n)] for __ in range(n)]

    for step in range(0, len(max_dp)):

        for i in range(len(max_dp) - step):

            j = step + i

            if step == 0:
                max_dp[i][i] = nums[i]
                min_dp[i][i] = nums[i]
            else:
                for k in range(i, j):  # i ~ j 까지의 최댓값과 최솟값 구하기
                    if ops[k] == "+":
                        # (i~k 까지의 max) + (k+1 ~ j 까지의 max)
                        max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] + max_dp[k + 1][j]) # max + max
                        min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] + min_dp[k + 1][j]) # min + min
                    if ops[k] == "-":
                        max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] - min_dp[k + 1][j]) # max - min
                        min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] - max_dp[k + 1][j]) # min - max

    for i in max_dp:
        for j in i:
            print(j,end='\t')
        print()
    print("answer: ", max_dp[0][n-1])
    return max_dp[0][n-1]
solution(["1", "-", "3", "+", "5", "-", "8"])
solution(["5", "-", "3", "+", "1", "+", "2", "-", "4"])

solution(["10", "-", '5', '+', '7', '+', '9', '-', '20', '-', '30', '+', '10'])
