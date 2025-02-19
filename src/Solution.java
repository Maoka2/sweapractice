import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            LinkedList<Integer> ll = new LinkedList<>();
            int[][] nums = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] ss = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    nums[i][j] = Integer.parseInt(ss[j]);
                    if (i == 0) {
                        ll.add(Integer.parseInt(ss[j]));
                    }
                }
            }


            for (int i = 0; i < N - 1; i++) {
                int index = -1;
                for (int j = 0; j < M; j++) {
                    if (ll.get(j) > nums[i + 1][0]) {
                        index = j;
                        break;
                    }
                }
                if (index == -1) {
                    for (int k = 0; k < M; k++) {
                        ll.addLast(nums[i + 1][k]);
                    }
                } else {
                    for (int k = 0; k < M; k++) {
                        ll.add(index, nums[i + 1][k]);
                        index++;
                    }
                }
            }

            bw.write("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                bw.write(ll.pollLast() + " ");
            }
            bw.write("\n");


        }
        bw.flush();
        br.close();
        bw.close();
    }
}