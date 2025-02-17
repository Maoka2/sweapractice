import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <=T; tc++){

            int N = Integer.parseInt(br.readLine());
            int[] buttons = new int[N];
            int[] result = new int[N];
            String[] a = br.readLine().split(" ");
            String[] b = br.readLine().split(" ");

            for(int i = 0; i < N; i++){

                buttons[i] = Integer.parseInt(a[i]);
                result[i] = Integer.parseInt(b[i]);

            }
            int count = 0;

            for(int i = 0; i < N; i++){
                if(buttons[i] != result[i]){
                    count++;
                    for(int j = i; j < N; j++){
                        buttons[j] = 1-buttons[j];
                    }
                }
            }
            bw.write("#" + tc + " " + count + "\n");

        }



        bw.flush();
        br.close();
        bw.close();
    }
}