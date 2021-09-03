
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D3_6808_규영이와인영이의카드게임 {

	static int[] arr, gu, in, selected;
	static int win, loose, N = 18;

	// 다음 큰 순열이 있으면 true, 없으면 fasle
	private static boolean np(int[] numbers) {

		int N = numbers.length;

		// step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return false; // 다음 순열이 없다는 뜻;

		// step2. i-1위치값과 교환할 큰 값 찾기
		int j = N - 1;
		while (numbers[i - 1] > numbers[j])
			--j;

		// step3. i-1위치값과 교환할 j위치값 교환
		swap(numbers, i - 1, j);

		// step4. 꼭대기(i)부터 맨뒤 까지 내림차순형태의 순열을 오름차순으로 처리
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}

		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		arr = new int[18];
		gu = new int[9];
		in = new int[9];
		selected = new int[9];
		for (int tc = 1; tc <= T; tc++) {
			win = 0;
			loose = 0;
			String[] inp = br.readLine().split(" ");

			for (int i = 0; i < 18; i++) {
				arr[i] = i + 1;
			}

			for (int i = 0; i < inp.length; i++) {
				gu[i] = Integer.parseInt(inp[i]);
				arr[gu[i] - 1] = 0;
			}

			int idx = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0)
					in[idx++] = arr[i];
			}
			do {
				int sum = 0, gu_score = 0, in_score = 0;
				for (int i = 0; i < 9; i++) {
					sum = (gu[i] + in[i]);
					if (gu[i] > in[i]) {
						gu_score += sum;
					} else {
						in_score += sum;
					}
				}
				if(gu_score>in_score) win++;
				else loose++;
			} while (np(in));
			bw.write("#" + tc + " " + win + " " + loose + "\n");
		}
		bw.close();
	}
}