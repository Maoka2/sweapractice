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
            int L = Integer.parseInt(s[2]);

            int[] num = new int[N];
            String[] sssss = br.readLine().split(" ");

            for(int i = 0; i < N; i++){
                num[i] = Integer.parseInt(sssss[i]);
            }

            LinkedList<Integer> ll = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                ll.add(num[i]);
            }

            for (int i = 0; i < M; i++) {
                String[] ss = br.readLine().split(" ");

                ll.add(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
            }
            bw.write("#" + tc + " " + ll.get(L) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}