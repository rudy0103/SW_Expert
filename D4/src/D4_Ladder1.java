import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class D4_Ladder1 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = 100;
        for (int tc = 0; tc < 10; tc++) {
            int t_case = Integer.parseInt(br.readLine());
            int start=-1;
            int[][] arr = new int[size][size];
            for (int i = 0; i < size; i++) {
                String[] inp = br.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    arr[i][j] = Integer.parseInt(inp[j]);
                }
            }
 
            for (int c = 0; c < size; c++) {
                int r = 0;
                int cc = c;
                if (arr[r][c] == 1) {
                    r++;
                    while (r < size) {
                        if (cc - 1 >= 0 && arr[r][cc - 1] == 1) {
                            cc = cc - 1;
                            while (arr[r + 1][cc] == 0 && cc-1 >= 0) {
                                cc = cc - 1;
                            }
                            r++;
                        } else if (cc + 1 < size && arr[r][cc + 1] == 1) {
                            cc = cc + 1;
                            while (arr[r + 1][cc] == 0 && cc+1 < size) {
                                cc = cc + 1;
                            }
                            r++;
                        } else {
                            r++;
                        }
                    }
                }
                if(arr[99][cc]==2) {
                    start=c;
                    break;
                }
            }
            bw.write("#"+t_case+" "+start+"\n");
        }
        bw.flush();
        bw.close();
    }
}