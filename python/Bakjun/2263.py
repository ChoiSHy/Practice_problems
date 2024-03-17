# 트리의 순회
# n개의 정점을 갖는 이진 트리의 정점에
# 1부터 n까지의 번호가 중복 없이 매개져 있다.
# 인오더와 포스트오더가 주어졌을때, 프리오더 구하기

import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)

# input part
n=int(input())
inorder=[int(i) for i in input().split()]
postorder=[int(i) for i in input().split()]

# inorder에서 해당 값의 인덱스룰 저장
nodes = [0]*(n+1)
for i in range(n):
    nodes[inorder[i]] = i

# 본격적인 preorder 구하는 함수, 재귀 + 분할 방식
def preorder(il, ir, pl, pr):   # inorder-left, inorder-right, postorder-left, postorder-right
    if il > ir or pl > pr:      # 크기가 0이하인 범위면 리턴
        return      

    root = postorder[pr]        # 현재 루트노드 

    left = nodes[root] - il     # 왼쪽 서브노드 크기
    right = ir - nodes[root]    # 오른쪽 서브노드 크기

    print(root, end=' ')
    preorder(il, il+left-1, pl, pl+left-1)
    preorder(ir-right+1, ir, pr-right, pr-1)

preorder(0,n-1,0,n-1)
# [1,3,2,5,4][7,10,9,8]
# [1,3,2][5] [7] [10,9]
# [1] [3]        [][10]

# preorder = [6,4,2,1,3,5,8,7,9,10]
