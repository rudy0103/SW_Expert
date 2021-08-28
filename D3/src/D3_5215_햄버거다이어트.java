import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class D3_5215_햄버거다이어트 {
    static int max=Integer.MIN_VALUE;
    static int maximum;
    static void makeBurger(int[][] arr,int cnt,int sum,int cal) {
        if(cnt==arr.length) {
            if(sum>max)
                max=sum;
        }else {
            if(cal+arr[cnt][1]<=maximum)
                makeBurger(arr, cnt+1, sum+arr[cnt][0],cal+arr[cnt][1]);
            makeBurger(arr, cnt+1, sum,cal);
        }
    };
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1;tc<=T;tc++) {
            String [] inp=br.readLine().split(" ");
            int n=Integer.parseInt(inp[0]);
            maximum=Integer.parseInt(inp[1]);
            int [][] arr=new int[n][2];
            max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++) {
                String [] in=br.readLine().split(" ");
                arr[i][0]=Integer.parseInt(in[0]);
                arr[i][1]=Integer.parseInt(in[1]);
            }
             
            makeBurger(arr,0,0,0);
             
            bw.write("#"+tc+" "+max+"\n");
        }
        bw.close();
    }
}