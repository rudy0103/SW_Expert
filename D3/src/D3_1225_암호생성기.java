
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D3_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = 10;

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] inp = br.readLine().split(" ");
			int[] pw = new int[inp.length];

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < inp.length; i++) {
				pw[i] = Integer.parseInt(inp[i]);
				if (pw[i] < min)
					min = pw[i];
			}
			int num = min / 15;
			for (int i = 0; i < inp.length; i++) {
				pw[i] -= 15 * (num - 1);
			}

			doCycle(pw);
			bw.write("#" + t + " ");
			for (int a : pw) {
				bw.write(a + " ");
			}
			bw.write("\n");
		}
		bw.close();

	}

	static void doCycle(int[] pw) {

		for (int i = 1; i <= 5; i++) {
			int tmp = pw[0] - i;
			if (tmp < 0) {
				tmp = 0;
			}
			for (int j = 0; j < pw.length - 1; j++) {
				pw[j] = pw[j + 1];
			}
			pw[pw.length - 1] = tmp;
			if (tmp == 0)
				return;
		}
		doCycle(pw);
	}
}