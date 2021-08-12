import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
class D3_1208_Flatten {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T=10;
         
        for(int tc=0; tc<T;tc++) {
            int dump=Integer.parseInt(br.readLine());
             
            // size가 100인 배열 생성
            String [] inp=br.readLine().split(" ");
            int [] arr = new int[inp.length];
            for(int i=0;i<inp.length;i++)
                arr[i]=Integer.parseInt(inp[i]);
             
            for(int i=0;i<dump;i++) {
                Arrays.sort(arr); // 내림차순 정렬
                arr[0]++; arr[arr.length-1]--;
            }
            Arrays.sort(arr); // 내림차순 정렬
            bw.write("#"+(tc+1)+" "+(arr[arr.length-1]-arr[0]+"\n"));           
             
        }
        bw.flush();
        bw.close();
    }
}