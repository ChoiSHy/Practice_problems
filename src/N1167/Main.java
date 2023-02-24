package N1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;

class node {
	int to;
	int dist;

	public node(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}
}
class Graph {
	private int szVertex;
	private ArrayList<node> list[];
	private Stack<Integer> stack;
	private boolean[] visited;
	public int r;
	
	public Graph(int v) {
		szVertex = v;
		list = new ArrayList[szVertex + 1];
		for (int i = 1; i <= szVertex; i++)
			list[i] = new ArrayList<>();
	}

	public void addEdge(int from, int to, int dist) {
		list[from].add(new node(to, dist));
	}
	public int findLongest(int v) {
		visited=new boolean[szVertex+1];
		stack=new Stack<>();
		int[] distance = new int[szVertex + 1];

		for(int i=0;i<list[v].size();i++)
			distance[list[v].get(i).to]=list[v].get(i).dist;
		int cur;
		stack.push(v);
		visited[v]=true;
		int idx=0;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			for (int i = 0; i < list[cur].size(); i++) {
				int n = list[cur].get(i).to;
				if (visited[n] ==false) {
					stack.push(n);
					visited[n]=true;
					distance[n]=distance[cur]+list[cur].get(i).dist;
					if(distance[idx]<distance[n])
						idx=n;
				}
			}
		}
		r=distance[idx];
		return idx;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int V=Integer.parseInt(br.readLine());
		
		Graph g=new Graph(V);
		
		for(int i=0;i<V;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to;
			while((to=Integer.parseInt(st.nextToken()))!=-1) 
				g.addEdge(from, to, Integer.parseInt(st.nextToken()));
		}
		g.findLongest(g.findLongest(1));
		System.out.println(g.r);
	}
}
