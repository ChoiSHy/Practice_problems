# n입력
n = int(input())
board = [[0 for _ in range(n)] for _ in range(n)]
# board[1:n][1:n] = 0

# k, 사과 입력
k = int(input())
for _ in range(k):
    x, y = input().split()
    board[int(x)][int(y)] = 2

# l, 루트 입력
l = int(input())
dir = {}
for _ in range(k):
    x, c = input().split()
    dir[int(x)] = c


class body:
    def __init__(self, x, y):
        self.x, self.y = x, y
        self.next = None

    def move(self, x, y):
        
        if (x < 0 or x >= n or y < 0 or n <= y):
            return True
        
        board[self.x][self.y] = 0
        if self.next is not None:
            if board[x][y] == 2:
                self.next.add_tail(self.x, self.y)
            else:
                self.next.move(self.x, self.y)

        self.x, self.y = x, y
        board[self.x][self.y] = 1
        return False

    def add_tail(self, x, y):
        board[self.x][self.y] = 0
        if self.next is None:
            self.next = body(self.x, self.y)
            board[self.x][self.y] = 1
        else:
            self.next.add_tail(self.x, self.y)
        self.x, self.y = x, y
        board[self.x][self.y] = 1


class Snake:
    def __init__(self):
        self.head = body(1, 1)
        self.dirc = 1

    def move(self):
        ret = False
        if self.dirc == 0:
            ret = self.head.move(self.head.x-1, self.head.y)
        elif self.dirc == 1:
            ret = self.head.move(self.head.x, self.head.y+1)
        elif self.dirc == 2:
            ret = self.head.move(self.head.x+1, self.head.y)
        elif self.dirc == 3:
            ret = self.head.move(self.head.x, self.head.y-1)
        return ret

    def turn(self, w):
        if w:   # clock wise
            self.dirc = (self.dirc+1) % 4
        else:   # counter-clock wise
            self.dirc = (self.dirc-1) % 4


def print_board():
    for i in range(n):
        for j in range(n):
            print(board[i][j], end=' ')
        print()


snake = Snake()
print()
time = 0
while True:    
    if time in dir:
        if dir[time] == 'D':
            snake.turn(True)
        elif dir[time] == 'L':
            snake.turn(False)
    time += 1
    if snake.move():
        break
    
    print_board()
    print()

    


print_board()
print(time)
