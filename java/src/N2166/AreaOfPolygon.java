package N2166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Polygon {
	int n;
	Point[] p;
	double area;
	boolean flag;

	public Polygon(int n) {
		this.n = n;
		this.area = 0;
		this.p = new Point[n];
	}

	protected void addArea(int p1, int p2) {
		int width = p[p2].x - p[p1].x;
		int height = Math.abs(p[p1].y + p[p2].y);
		
		area+=(double)(width*height)/2;
	}
	
	public void getArea() {
		for(int i=0;i<n-1;i++) 
			addArea(i, i+1);
		addArea(n-1,0);
		
		area=Math.abs(area);
	}
}

public class AreaOfPolygon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Polygon poly = new Polygon(N);

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			poly.p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		poly.getArea();
		System.out.println(poly.area);
	}

}
