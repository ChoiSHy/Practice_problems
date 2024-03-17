import math

def solution(progresses, speeds):
    size = len(progresses)
    rest = [100 - p for p in progresses]    
    answer = []

    for i in range(size):
        rest[i] = math.ceil(rest[i] / speeds[i])

    cnt = 0
    max = rest[0]
    for i in rest:
        if max < i:
            answer.append(cnt)
            max = i
            cnt = 1
            continue
        cnt+=1
    answer.append(cnt)
    return answer

print('answer:', solution([93, 30, 55],[1, 30, 5]))
print('answer:', solution([95, 90, 99, 99, 80, 99],	[1, 1, 1, 1, 1, 1]))

