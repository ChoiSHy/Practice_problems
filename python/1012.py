import sys
input = sys.stdin.readline

output = []
T = int(input())
row, col, cnt = map(int, input().split())
def printf(field):
    for row in field:
        print(row)
def test(row, col, cnt):
    field=[[0 for _ in range(col)] for __ in range(row)]
    for i in range(cnt):
        r,c = map(int,input().split())
        field[r][c]=1
    printf(field)
test(row,col,cnt)



