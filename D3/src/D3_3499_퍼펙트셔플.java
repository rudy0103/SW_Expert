import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			Queue<String> q = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			int n=Integer.parseInt(br.readLine());
			int idx=0;
			if(n%2==0) {
				idx=n/2-1;
			}
			else idx=n/2;
			
			String [] inp=br.readLine().split(" ");
			for(int i=0;i<=idx;i++) {
				q.add(inp[i]);
			}
			for(int i=idx+1;i<inp.length;i++) {
				q2.add(inp[i]);
			}
			bw.write("#"+t+" ");
			while(!q.isEmpty()) {
				bw.write(q.poll()+" ");
				if(!q2.isEmpty())
					bw.write(q2.poll()+" ");
			}
			bw.write("\n");
		}
		bw.close();
	}
}