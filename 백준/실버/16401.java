import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bf.readLine().split(" ");

        int bro = Integer.parseInt(str[0]); // 조카 수
        int cnt = Integer.parseInt(str[1]); // 과자 수
        int longest = -1; // 과자 중 최대 길이
        int[] cookies = new int[cnt]; // 과자 값
        int max = 0; // 조카에게 나눠줄 과자 중 최대 길이
        int cut = 0; // 길이 x로 잘린 조각 수

        str = bf.readLine().split(" ");

        for(int i = 0; i < cnt; i++) {
            cookies[i] = Integer.parseInt(str[i]);
            longest = Math.max(cookies[i], longest);
        } // 입력값고 동시에 최대 길이도 갱신

        int left = 1;
        int right = longest;
        // 이분 탐색

        while(left <= right) {
            int mid = (left + right) / 2;
            cut = 0; // 잘린 수 초기화

            for(int i = 0; i < cnt; i++) {
                cut += cookies[i] / mid;
            } // mid 길이로 잘랐을 때, mid길이인 조각 수

            if(cut >= bro) { 
              // 조각 수가 조카수보다 크면 = 나눌 수 있음
                left = mid + 1;
                max = Math.max(max, mid);
              // 더 긴 길이로도 자를 수 있을지도 모르므로, 다음 탐색
              // 범위를 오른쪽으로 옮김
              // 후보값 갱신
            } else {
                right = mid - 1;
              // 조각 수가 더 적으면 = 못나눔
              // = 길이가 길어서라고 판단
              // 길이를 줄임 -> 범위롤 왼쪽으로 옮김
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }

}
