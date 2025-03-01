import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] foods = new int[N][N];
            boolean[] visited = new boolean[N];


            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    foods[i][j] = Integer.parseInt(s[j]);
                }
            }
            min = Integer.MAX_VALUE;
            backTracking(0, N, 0, visited, foods);
            bw.write("#" + tc + " " + min + "\n");


        }
        bw.flush();
        br.close();
        bw.close();
    }

    //백트래킹
    static int min;

    static void backTracking(int idx, int N, int depth, boolean[] visited, int[][] foods) {
        if (depth == N / 2) {
            int sumA = 0;
            int sumB = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        sumA += foods[i][j] + foods[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        sumB += foods[i][j] + foods[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(sumA - sumB));
            return;
        }

        for (int i = idx; i < N; i++) {
            visited[i] = true;
            backTracking(i + 1, N, depth + 1, visited, foods);
            visited[i] = false;
        }
    }
}