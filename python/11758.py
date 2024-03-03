# 11758 CCW Count Clock Wise
# 2차원 좌표 평면 위에 있는 점 3개 P1, P2, P3가 주어진다. 
# P1, P2, P3를 순서대로 이은 선분이 어떤 방향을 이루고 있는지 구하기

# 반시계:-1
# 시계  : 1
# 일직선: 0

x,y = map(int, input().split())
p1 = (x,y)
x,y = map(int, input().split())
p2=(x,y)
x,y = map(int, input().split())
p3=(x,y)

print(p1)
print(p2)
print(p3)

in1 = (p1[1]-p2[1])/(p1[0]-p2[0])
in2 = (p2[1]-p3[1])/(p2[0]-p3[0])
in3 = (p3[1]-p1[1])/(p3[0]-p1[0])

print(in1)
print(in2)
print(in3)