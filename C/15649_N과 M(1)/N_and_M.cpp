#pragma warning(disable:4996)

// 1 ~ N 사이의 수 중, M개의 수를 골라 만든 수열들을 출력

#include <stdio.h>

int ans[9] = { 0, };
int visited[9] = { 0, };
int m, n;

void func(int x) {	//x는 x번째 자릿수
	// m개의 수를 뽑은 뒤에는 출력
	if (x == m + 1) {
		for (int i = 1; i <= m; i++)
			printf("%d ", ans[i]);
		puts("");
	}
	// m개의 수를 뽑기 전
	else {
		for (int i = 1; i <= n; i++) {
			// 1 ~ n 사이의 수를 m번째 자리에 넣기
			// 방문한 적 없는 경우에는 넣고, 아니면 넘어가기
			if (visited[i] == 0) {
				visited[i] = 1;		
				ans[x] = i;
				func(x + 1);	//다음 자리수 함수 실행
				visited[i] = 0;
			}
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);
	func(1);

	return 0;
}