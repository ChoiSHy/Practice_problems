#pragma warning(disable:4996)

// 1 ~ n 까지의 자연수 중 중복없이 m개를 고른 수열
// 고른 수열은 오름차순
// 1 <= m <= n <= 8

// input : 4 2
/* output :
1 2 
1 3
1 4
2 3
2 4
3 4
*/
#include <stdio.h>
int m, n;
int ans[9];
int visited[9] = { 0, };

void func(int x, int y) {
	if (y == m + 1) {
		for (int i = 1; i <= m; i++)
			printf("%d ", ans[i]);
		puts("");
	}
	else {
		for (int i = x; i <= n; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				ans[y] = i;
				func(i+1,y + 1);
				visited[i] = 0;
			}
		}
	}
}
int main() {
	scanf("%d %d", &n, &m);
	func(1, 1);
}