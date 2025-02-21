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
            String[] pw = br.readLine().split(" ");
            LinkedList<Integer> ll = new LinkedList<>();

            for(int i = 0; i < pw.length; i++){
                ll.add(Integer.parseInt(pw[i]));
            }
            int commandNum = Integer.parseInt(br.readLine());
            String[] command = br.readLine().split(" ");

            for(int i = 0; i < command.length; i++){
                if(command[i].equals("I")){
                    for(int j = 0; j < Integer.parseInt(command[i+2]); j++){
                        ll.add(Integer.parseInt(command[i+1])+j, Integer.parseInt(command[i+3+j]));
                    }
                } else if(command[i].equals("D")){
                    for(int j = 0; j < Integer.parseInt(command[i+2]); j++){
                        ll.remove(Integer.parseInt(command[i+1]));
                    }
                } else if(command[i].equals("A")){
                    for(int j = 0; j < Integer.parseInt(command[i+1]); j++){
                        ll.addLast(Integer.parseInt(command[i+2+j]));
                    }
                }
            }
            sb.append("#").append(tc).append(" ");
            for(int i = 0; i < 10; i++){
                sb.append(ll.pollFirst()).append(" ");
            }
            bw.write(sb.toString() + "\n");
            sb.setLength(0);
        }
        bw.flush();
        br.close();
        bw.close();
}
}