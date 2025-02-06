import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> l = new ArrayList<>();
        String[] s = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            l.add(Integer.parseInt(s[i]));
        }
        Collections.sort(l);
        System.out.println(l.get(N/2));
        //bw.close();
        br.close();
    }
}
