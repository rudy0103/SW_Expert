import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int cnt = 0;
			String inp = br.readLine();
			char before = inp.charAt(0);
			if (before == '1')
				cnt = 1;
			for (int i = 1; i < inp.length(); i++) {
				if (inp.charAt(i) != before) {
					before = inp.charAt(i);
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", t + 1, cnt);

		}

	}
}