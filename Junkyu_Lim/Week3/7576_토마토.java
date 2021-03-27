import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int m,n;
	static int[][] tomatoes;
	static int[][] day;

	static public void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		tomatoes = new int[m][n];
		day = new int[m][n];

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				tomatoes[i][j] = Integer.parseInt(st.nextToken());
				if (tomatoes[i][j] == -1) day[i][j] = 1;
			}
		}
		bfs();
		System.out.println(findMax(day) != -1 ? findMax(day)-1 : findMax(day));
	}

	static private void bfs() {
		Queue<Tomato> q = new LinkedList<>();
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (tomatoes[i][j] == 1) {
					q.add(new Tomato(i, j));
					day[i][j] = 1;
				}
			}
		}
		int[] x = {1, 0, -1, 0};
		int[] y = {0, 1, 0, -1};

		while(!q.isEmpty()) {
			Tomato tomato = q.poll();
			int row = tomato.row;
			int col = tomato.col;

			for (int i=0; i<x.length; i++) {
				int _x = row + x[i];
				int _y = col + y[i];

				if (valid(_x, _y)) {
					q.add(new Tomato(_x, _y));
					day[_x][_y] = day[row][col] + 1;
				}
			}
		}		
	}

	private static  boolean valid(int row, int col) {
		if (row < 0 || row > m-1 || col < 0 || col > n-1) return false;
		if (tomatoes[row][col] == -1 || day[row][col] > 0) return false;
		return true;
	}

	private static int findMax(int[][] array) {
		int result = 0;
		for (int i = 0; i<array.length; i++) {
			for (int j = 0; j<array[i].length; j++) {
				if (result < array[i][j]) result = array[i][j];
				if (array[i][j] == 0) return -1;
			}
		}
		return result;
	}
}

class Tomato {
	int row;
	int col;
	Tomato(int row, int col) {
		this.row = row;
		this.col = col;
	}
}