
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
  
public class D3_9229_한빈이와SpotMart {
  
    static int n, m;
    static int max;
    static int [] arr;
      
    static void getSnack( int selected,int w,int start) {
  
        if (selected == 2 ) {
            if (max < w)
                max = w;
        } else {
            for(int i=start;i<arr.length;i++) {
                if(w+arr[i]<=m)
                    getSnack(selected+1, w+arr[i], i+1);
            }
        }
    }
  
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inp;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            inp = br.readLine().split(" ");
            max = -1;
            n = Integer.parseInt(inp[0]);
            m = Integer.parseInt(inp[1]);
            arr= new int[n];
            inp = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i]=Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            getSnack(0, 0, 0);
            bw.write("#" + tc + " " + max + "\n");
        }
        bw.close();
    }
}