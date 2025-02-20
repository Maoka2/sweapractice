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
            Map<Integer, Integer> cardgame = new HashMap<>();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    cardgame.put(i + j, cardgame.getOrDefault(i + j, 0) + 1);
                }
            }

            int max = -1;
            for (int n : cardgame.keySet()) {
                max = Math.max(max, cardgame.get(n));
            }

            bw.write("#" + tc + " ");
            for(int n : cardgame.keySet()){
                if(cardgame.get(n) == max){
                    bw.write(n + " ");
                }
            }
            bw.write("\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}