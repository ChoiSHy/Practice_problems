# 그래프의 인접리스트가 주어졌을 떄, 몇 개의 그래프가 만들어지는가?
def solution(n, edges):
    s = set([i for i in range(n)])
    q = []
    answer = 0
    while len(s) != 0:
        answer+=1
        cur = s.pop()
        q.insert(0, cur)
        while len(q) != 0:
            cur = q.pop()
            if cur in s:
                s.remove(cur)

            for i in range(n):
                if i == cur: continue
                if edges[cur][i] == 1 and (i in s):
                    q.insert(0, i)


    print('answer: ',answer)
    return answer
    

solution(3,	[
    [1, 1, 0], 
    [1, 1, 0], 
    [0, 0, 1]])
solution(3,	[
    [1, 1, 0], 
    [1, 1, 1], 
    [0, 1, 1]])