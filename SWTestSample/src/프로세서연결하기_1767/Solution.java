package 프로세서연결하기_1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static int minLen = Integer.MAX_VALUE, N;
	public static int maxContact = Integer.MIN_VALUE;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];

			minLen = Integer.MAX_VALUE;
			maxContact = Integer.MIN_VALUE;
			ArrayList<int[]> list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i != 0 && j != 0 && i != N - 1 && j != N - 1)
							list.add(new int[] { i, j });
					}
				}
			}

			getMinLength(0, 0, 0, 0, map, list);

			sb.append("#" + tc + " " + minLen + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void getMinLength(int start, int depth, int contact, int len, int[][] map, ArrayList<int[]> list) {

		if (contact + (list.size() - depth) < maxContact)
			return;

		if (depth == list.size()) {// 전선 연결이 끝났을 때 연결되어 있는 회로수와 전선 길이 파악

			if (contact > maxContact) {
				minLen = len;
				maxContact = contact;
			} else if (contact == maxContact) {
				if (len < minLen)
					minLen = len;
			}

			return;
		}

		int[] tmp = list.get(start);

		for (int i = 0; i < 4; i++) {// 4가지 방향으로 블라 블라
			int circuit = -1 * (start + 1);
			int isContacted = contactCircuit(tmp[0], tmp[1], i, map, circuit);

			if (isContacted > 0) {
				getMinLength(start + 1, depth + 1, contact + 1, len + isContacted, map, list);
				deContactCircuit(tmp[0], tmp[1], map, circuit);
			} else
				getMinLength(start + 1, depth + 1, contact, len, map, list);

		}
	}

	private static int contactCircuit(int r, int c, int d, int[][] map, int circuit) {
		int rr = r + dr[d];
		int cc = c + dc[d];
		int cnt = 0;
		while (rr >= 0 && rr < N && cc >= 0 && cc <= N) {
			if (map[rr][cc] != 0)
				break;

			if (rr == 0 || cc == 0 || rr == N - 1 || cc == N - 1) {

				if (rr == 0) {
					for (int tmp = 0; tmp < r; tmp++) {
						map[tmp][c] = circuit;
						cnt++;
					}
				} else if (cc == 0) {
					for (int tmp = 0; tmp < c; tmp++) {
						map[r][tmp] = circuit;
						cnt++;
					}
				} else if (rr == N - 1) {
					for (int tmp = r + 1; tmp < N; tmp++) {
						map[tmp][c] = circuit;
						cnt++;
					}
				} else {
					for (int tmp = c + 1; tmp < N; tmp++) {
						map[r][tmp] = circuit;
						cnt++;
					}
				}

				return cnt;
			}
			rr += dr[d];
			cc += dc[d];
		}
		return cnt;
	}

	private static void deContactCircuit(int r, int c, int[][] map, int circuit) {

		for (int i = 0; i < N; i++)
			if (map[r][i] == circuit)
				map[r][i] = 0;
		for (int i = 0; i < N; i++)
			if (map[i][c] == circuit)
				map[i][c] = 0;

	}
}