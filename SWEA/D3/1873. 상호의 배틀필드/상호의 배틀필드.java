import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int x, y, H, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            String[][] arr = new String[H][W];
            x = 0;
            y = 0;

            for (int i = 0; i < H; i++) {
                String[] temp = br.readLine().split("");
                for (int j = 0; j < W; j++) {
                    arr[i][j] = temp[j];

                    if (temp[j].equals("<") || temp[j].equals(">") || temp[j].equals("v") || temp[j].equals("^")) {
                        x = i;
                        y = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String[] command = br.readLine().split("");

            for (int i = 0; i < command.length; i++) {
                arr = move(arr, command[i]);
            }
            System.out.print("#"+test+ " ");

            print(arr);
        }

    }

    private static void print(String[][] arr) {
        for(int i=0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    // U : 위 | D : 아래 | L : 왼쪽 | R : 오른쪽 | S : shoot
    private static String[][] move(String[][] arr, String command) {
        switch (command) {
            case "U":

                int u_nx = x - 1;
                if (u_nx >= 0 && arr[u_nx][y].equals(".")) {
                    arr[x][y] = ".";
                    arr[u_nx][y] = "^";
                    x = u_nx;
                } else {
                    arr[x][y] = "^";

                }

                break;
            case "D":

                int d_nx = x + 1;
                if (d_nx < H && arr[d_nx][y].equals(".")) {
                    arr[x][y] = ".";
                    arr[d_nx][y] = "v";
                    x = d_nx;
                } else {
                    arr[x][y] = "v";

                }


                break;

            case "R":

                int r_ny = y + 1;
                if (r_ny < W && arr[x][r_ny].equals(".")) {
                    arr[x][y] = ".";
                    arr[x][r_ny] = ">";
                    y = r_ny;
                } else {
                    arr[x][y] = ">";
                    break;
                }


                break;

            case "L":

                int l_ny = y - 1;
                if (l_ny >= 0 && arr[x][l_ny].equals(".")) {
                    arr[x][y] = ".";
                    arr[x][l_ny] = "<";
                    y = l_ny;
                } else {
                    arr[x][y] = "<";
                    break;
                }
                break;

            case "S":
                String stance = arr[x][y];
                if (stance.equals("^")) {
                    int temp_x = x;
                    while (true) {
                        int nx = temp_x - 1;
                        if (nx >= 0) {
                            if (arr[nx][y].equals("#")) {
                                break;
                            } else if (arr[nx][y].equals("*")) {
                                arr[nx][y] = ".";
                                break;
                            }
                            temp_x = nx;
                        } else {
                            break;
                        }
                    }
                    break;
                } else if (stance.equals(">")) {
                    int temp_y = y;
                    while (true) {
                        int ny = temp_y + 1;
                        if (ny < W) {
                            if (arr[x][ny].equals("#")) {
                                break;
                            } else if (arr[x][ny].equals("*")) {
                                arr[x][ny] = ".";
                                break;
                            }
                            temp_y = ny;
                        } else {
                            break;
                        }
                    }
                    break;
                } else if (stance.equals("<")) {
                    int temp_y = y;
                    while (true) {
                        int ny = temp_y - 1;
                        if (ny >= 0) {
                            if (arr[x][ny].equals("#")) {
                                break;
                            } else if (arr[x][ny].equals("*")) {
                                arr[x][ny] = ".";
                                break;
                            }
                            temp_y = ny;
                        } else {
                            break;
                        }
                    }
                    break;
                } else if (stance.equals("v")) {
                    int temp_x = x;
                    while (true) {
                        int nx = temp_x + 1;
                        if (nx < H) {
                            if (arr[nx][y].equals("#")) {
                                break;
                            } else if (arr[nx][y].equals("*")) {
                                arr[nx][y] = ".";
                                break;
                            }
                            temp_x = nx;
                        } else {
                            break;
                        }
                    }
                    break;
                }
        }

        return arr;
    }
}