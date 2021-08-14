import java.io.*;

public class D3_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
        	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()), s=(N-1)/2, tot=0;
			for(int i=0;i<N;i++) {
				String inp=br.readLine();
				for(int j=0+s;j<N-s;j++) 
					tot+=Integer.parseInt(inp.charAt(j)+"");
				if(i<(N-1)/2) s--;
				else s++;
			}
			bw.write("#"+tc+" "+tot+"\n");
		}
		bw.close();
	}
}
