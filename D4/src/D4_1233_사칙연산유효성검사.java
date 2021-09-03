
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class D4_1233_사칙연산유효성검사 {

//	public static Node[] nodes;
	public static Object[][] nodes;
	public static boolean isTrue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q = new LinkedList<Integer>();
		

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			nodes = new Object[N + 1][3];
			Object[] node= {"0",-1,-1};
			nodes[0]=node;
//			
			for (int i = 1; i <= N; i++) {
				String[] inp = br.readLine().split(" ");
				if (inp.length == 2) {
					Object [] tmp= {inp[1],-1,-1};
					nodes[i] = tmp;
				} else if (inp.length == 3) {
					Object [] tmp= {inp[1],i*2,-1};
					nodes[i] = tmp;
				} else {
					Object [] tmp= {inp[1],i*2,i*2+1};
					nodes[i] = tmp;
				}
			}
			isTrue = true;
			q.add(1);

			while (!q.isEmpty()) {
				Object [] n=nodes[q.poll()];
				if (n[0].equals("-") || n[0].equals("+") || n[0].equals("*") || n[0].equals("/")) {
					if ((int)n[1] == -1 || (int)n[2] == -1) {
						isTrue = false;
						break;
					}
					else {
						q.add((Integer) n[1]);
						q.add((Integer) n[2]);
					}
				} else {
					if ((int)n[1]!=-1 || (int)n[2] !=-1) {
						isTrue = false;
						break;
					}
				}
			}

			if (isTrue) {
				bw.write("#" + tc + " 1\n");
			} else {
				bw.write("#" + tc + " 0\n");
			}
		}
		bw.close();
	}
}