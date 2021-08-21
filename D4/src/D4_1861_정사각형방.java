import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Room {
	int r;
	int c;
	int cnt;
	int val;
	int[][] map;
	int size;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public Room(int r, int c, int cnt, int val, int[][] map) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.val = val;
		this.map = map;
		this.size = map.length;
	}

	public void move() {
		int rr = -1, cc = -1;

		for (int i = 0; i < 4; i++) {
			rr = this.r + dr[i];
			cc = this.c + dc[i];

			if (rr >= 0 && rr < size && cc >= 0 && cc < size) {
				if (map[rr][cc] == map[r][c] + 1) {
					r = rr;
					c = cc;
					this.cnt++;
					this.move();
				}
			}
		}
	}

}

public class D4_1861_정사각형방 {

	static int[][] map;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			Queue<Room> q = new LinkedList<Room>();
			List<Room> list = new ArrayList<Room>();
			map = new int[n][n];
			Room room;
			for (int r = 0; r < n; r++) {
				String[] inp = br.readLine().split(" ");
				for (int c = 0; c < n; c++) {
					map[r][c] = Integer.parseInt(inp[c]);
					list.add(new Room(r, c, 1, map[r][c], map));
				}
			}
			for (Room r : list) {
				r.move();
			}

			list.sort(new Comparator<Room>() {
				@Override
				public int compare(Room o1, Room o2) {
					if (o1.cnt == o2.cnt)
						return o1.val - o2.val;
					else
						return o2.cnt - o1.cnt;
				}
			});
			bw.write("#" + t + " " + list.get(0).val + " " + list.get(0).cnt);
			bw.write("\n");
		}
		bw.close();
	}
}