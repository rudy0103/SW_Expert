
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
class Tank {
    private int r;
    private int c;
    private int H;
    private int W;
    private char d;
    private char[][] map;
 
    public Tank() {
        super();
    }
 
    public Tank(int r, int c, char d, char[][] map, int h, int w) {
        super();
        this.r = r;
        this.c = c;
        H = h;
        W = w;
        this.d = d;
        this.map = map;
    }
 
    public void task(char t) {
        if (t == 'U') {
            d='^';
            map[r][c]=this.d;
            goUp();
        } else if (t == 'D') {
            d='v';
            map[r][c]=this.d;
            goDown();
        } else if (t == 'L') {
            d='<';
            map[r][c]=this.d;
            goLeft();
        } else if (t == 'R') {
            d='>';
            map[r][c]=this.d;
            goRight();
        } else if (t == 'S') {
            shot();
        }
    }
 
    public void goUp() {
        if (r - 1 >= 0 && map[r - 1][c] == '.') {
            r -= 1;
            map[r][c] = d;
            map[r + 1][c] = '.';
        }
 
    }
 
    public void goDown() {
        if (r + 1 < H && map[r + 1][c] == '.') {
            r += 1;
            map[r][c] = d;
            map[r - 1][c] = '.';
        }
 
    }
 
    public void goLeft() {
        if (c - 1 >= 0 && map[r][c - 1] == '.') {
            c -= 1;
            map[r][c] = d;
            map[r][c + 1] = '.';
        }
    }
 
    public void goRight() {
        if (c + 1 < W && map[r][c + 1] == '.') {
            c += 1;
            map[r][c] = d;
            map[r][c - 1] = '.';
        }
    }
 
    public void shot() {
        if (d == '^') {
            int rr = r;
            while (rr >= 0) {
                if (map[rr][c] == '*') {
                    map[rr][c] = '.';
                    break;
                } else if (map[rr][c] == '#')
                    break;
                rr--;
            }
 
        } else if (d == 'v') {
            int rr = r;
            while (rr < H) {
                if (map[rr][c] == '*') {
                    map[rr][c] = '.';
                    break;
                } else if (map[rr][c] == '#')
                    break;
                rr++;
            }
 
        } else if (d == '<') {
            int cc = c;
            while (cc >= 0) {
                if (map[r][cc] == '*') {
                    map[r][cc] = '.';
                    break;
                } else if (map[r][cc] == '#')
                    break;
                cc--;
            }
 
        } else if (d == '>') {
            int cc = c;
            while (cc < W) {
                if (map[r][cc] == '*') {
                    map[r][cc] = '.';
                    break;
                } else if (map[r][cc] == '#')
                    break;
                cc++;
            }
        }
    }
}
 
public class D3_1873_상호의배틀필드 {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int H, W;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            String[] inp = br.readLine().split(" ");
            H = Integer.parseInt(inp[0]);
            W = Integer.parseInt(inp[1]);
            char[][] map = new char[H][W];
 
            int s_row = 0;
            int s_col = 0;
            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        s_row = i;
                        s_col = j;
                    }
                }
            }
            Tank tank = new Tank(s_row, s_col, map[s_row][s_col], map, H, W);
 
            int N = Integer.parseInt(br.readLine());
            String toDo = br.readLine();
 
            for (int i = 0; i < toDo.length(); i++) {
                tank.task(toDo.charAt(i));
            }
            bw.write("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    bw.write(map[i][j]);
                }
                bw.write("\n");
            }
        }
        bw.close();
    }
}