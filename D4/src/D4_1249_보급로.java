import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class D4_1249_보급로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] cost = new int[N][N];

			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = (row.charAt(j) - '0');
					cost[i][j] = 123456789;
				}
			}

			ArrayDeque<int[]> q = new ArrayDeque<>();
			q.add(new int[] { 0, 0 });
			cost[0][0] = map[0][0];

			while (!q.isEmpty()) {
				int[] cur = q.poll();

				int r = cur[0];
				int c = cur[1];

				for (int i = 0; i < 4; i++) {
					int rr = r + dr[i];
					int cc = c + dc[i];
					if (rr >= 0 && rr < N && cc >= 0 && cc < N) {

						if (cost[r][c] + map[rr][cc] < cost[rr][cc]) {
							q.add(new int[] { rr, cc });
							cost[rr][cc] = cost[r][c] + map[rr][cc];
						}

					}
				}

			}

			sb.append("#").append(tc + " ").append(cost[N - 1][N - 1]).append("\n");

		}
		System.out.println(sb.toString());
	}
}
