#include<iostream>
#include<string>

using namespace std;

int main() {
	int n;
	int* r;
	string* a;

	cin >> n;
	a = new string[n];
	r = new int[n];

	for (int i = 0; i < n; i++)
		cin >> r[i] >> a[i];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < a[i].length(); j++)
			for (int k = 0; k < r[i]; k++)
				cout << a[i][j];


		cout << endl;
	}
}