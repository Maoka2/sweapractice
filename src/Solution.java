// 손 : 이종현 머리 : 김현영

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException{
        // 입력받은 저 숫자들을 내림차순으로 정렬을 하실게요?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = 10;


        // 제일 높은 곳에서 낮은 곳으로 dump
        // for문을 돌면서 계속 내림차순 정렬을 해줘야겠네요
        // 예외 처리 -> 덤프횟수 0이면 끝내기, 높이차이 1이하면 끝내기

        for(int tc = 1; tc<=N; tc++) {
            int dump = Integer.parseInt(br.readLine()); // 허용 덤프 횟수

            String[] s = br.readLine().split(" ");
            int[] boxHeight = new int[s.length];
            for(int i = 0; i < boxHeight.length; i++) {

                boxHeight[i] = Integer.parseInt(s[i]);
            } // 여까지 입력

            for(int i = 0; i<dump; ) {
                // 처음에 하고,
                Arrays.sort(boxHeight); // 오름차순으로 정렬 일단 했음
                int minDiff = boxHeight[1]- boxHeight[0] +1; //
                int maxDiff = boxHeight[boxHeight.length-1] - boxHeight[boxHeight.length-2] +1;
                // 저기서 작은 수만큼 dump 할것임 -> 정렬이 처음으로 깨질때까지의 덤프 횟수니까 +1 해줬음.
                int dumpNum = Math.min(minDiff, maxDiff); // 그래서 Math.min 해서 얼마나 덤프할지 받아옴

                if(i + dumpNum > dump) {
                    dumpNum = dump - i;
                } // 덤프횟수가 초과될 때 케이스 처리
                // 지금까지 한 횟수랑 이제 추가로 해야되는게 허용된 거 보다 많으면 안되니까 그럴땐 그냥 가능한만큼만 더 덤프 하겠음니다.

                if(boxHeight[boxHeight.length-1] - boxHeight[0] <= 1) {
                    break;
                    // 젤 높은거랑 젤 낮은거 높이차이 1이하면 어차피 해도 똑같으니까
                    // ex) 1,1,2,2 덤프해도 1,1,2,2 유지되니까 그냥 이럴땐 break
                }

                boxHeight[0] += dumpNum;
                boxHeight[boxHeight.length-1] -= dumpNum;
                i+=dumpNum;
                // 그래서 각각 높이에 덤프횟수만큼 올릴거 올리고 내릴거 내리고 횟수 올리고

            }
            // 마지막에 그러고 나서 정렬 안되있으니까 함 더 정렬해주고
            Arrays.sort(boxHeight);
            bw.write("#" + tc + " " +(boxHeight[boxHeight.length-1] - boxHeight[0]) + "\n");
            // 그다음에 맨뒤에꺼가 최대높이고 맨앞이 최소높이라서 이거 뺸거 write하고 밑에서 한번에 flush 하고
        }





        bw.flush();
        bw.close();
        br.close();
    }


}