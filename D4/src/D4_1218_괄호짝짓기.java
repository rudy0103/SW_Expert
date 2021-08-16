import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class D4_1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = 10;
		Stack<Character> st = new Stack<>();
		for (int t = 1; t <= T; t++) {
			br.readLine();
			char[] inp = br.readLine().toCharArray();
			boolean possible=true;
			for (char c : inp) {
				if (st.empty()) {
					st.add(c);
				}else if(c=='('||c=='{'||c=='<'||c=='[') {
					st.add(c);
				}else if(c==')' && st.peek()=='(') {
					st.pop();
				}else if(c==']' && st.peek()=='[') {
					st.pop();
				}else if(c=='>' && st.peek()=='<') {
					st.pop();
				}else if(c=='}' && st.peek()=='{') {
					st.pop();
				}else {
					possible=false;
					break;
				}
			}
			
			if(st.empty()&&possible) bw.write("#"+t+" "+1+"\n");
			else bw.write("#"+t+" "+0+"\n");
			st.clear();
		}
		bw.close();
	}
}
