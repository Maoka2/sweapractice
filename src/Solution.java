import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            Deque<Integer> pw = new ArrayDeque<>();
            for(int i = 0; i < s.length; i++){
                pw.add(Integer.parseInt(s[i]));
            }
            sb.append("#").append(tc).append(" ");

            int count = 0;
            int minus = 1;


            while(true){
                if(pw.peekFirst() - minus <= 0){
                    pw.pollFirst();
                    pw.addLast(0);
                    break;
                }
                pw.addLast(pw.pollFirst() - minus);
                minus++;
                if(minus == 6){
                    minus = 1;
                }

            }
            for(int n : pw){
                sb.append(pw.pollFirst()).append(" ");
            }
            String ans = sb.toString().trim();
            bw.write(ans + "\n");
            sb.setLength(0);
        }


        bw.flush();
        br.close();
        bw.close();
}
}