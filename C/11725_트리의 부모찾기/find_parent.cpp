#pragma warning(disable:4996)

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
	int data;
	struct Node* next;
}node;

typedef struct adjList {
	node* head;
}list;

void insert(list** adj, int a, int b) {
	node* newNode = (node*)malloc(sizeof(node));
	newNode->data = b;
	newNode->next = NULL;

	if (adj[a]->head != NULL) 
		newNode->next = adj[a]->head;
		
	adj[a]->head = newNode;
}

void input_tree(list** adj, int n) {
	int a, b;
	for (int i = 1; i < n; i++) {
		scanf("%d %d", &a, &b);
		insert(adj, a, b);
		insert(adj, b, a);
	}
}
void find_parent(list** adj, int* parent, int n) {
	for (node* tmp = adj[n]->head; tmp != NULL; tmp = tmp->next) {
		if (parent[tmp->data] == 0) {
			parent[tmp->data] = n;
			find_parent(adj, parent, tmp->data);
		}
	}
}

int main() {
	int n;
	int* parent;
	list** adj;

	scanf("%d", &n);
	adj = (list**)calloc(n+1, sizeof(list*));
	parent = (int*)calloc(n + 1, sizeof(int));
	for (int i = 1; i < n + 1; i++) {
		adj[i] = (list*)malloc(sizeof(list));
		adj[i]->head = NULL;
		parent[i] = 0;
	}
	parent[1] = 1;

	input_tree(adj, n);
	find_parent(adj, parent, 1);
	for (int i = 2; i < n + 1; i++)
		printf("%d\n", parent[i]);
}