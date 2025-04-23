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

        int dogs = Integer.parseInt(str[0]); // dp배열
        int m = Integer.parseInt(str[1]); // 닫힌 구간
        int a = Integer.parseInt(str[2]); // a마법으로 소환하는 강아지 
        int b = Integer.parseInt(str[3]); // a마법으로 소환하는 강아지 

        int[] min = new int[dogs + 1]; // 0안쓰려고 +1

        for (int i = 0; i < m; i++) {
            str = bf.readLine().split(" ");

            int s = Integer.parseInt(str[0]); // 구간 시작점
            int e = Integer.parseInt(str[1]); // 구간 끝점

            for(int j = s; j <= e; j++) {
                min[j] = -1;
            } // 닫힌 구간의 모든 숫자들을 방문 불가처리
        }

        if(min[a] != -1) min[a] = 1;
        if(min[b] != -1) min[b] = 1;
        // 방문 불가 지점이 아니라면,
        // a마법과 b마법을 처음 썼을 때를 1로

        for (int i = 1; i <= dogs; i++) {
            if (min[i] == -1) continue; // 방문 불가 지점

            // 주 : a와 b가 다 있을 때를 조건문으로 쓰기 싫었음
        
            if (i - a >= 0 && min[i - a] > 0) { 
              // 인덱스 바깥이 아니고, a마법을 썼을 때 쓴 적이(방문한 적이) 있음
                if (min[i] == 0) min[i] = min[i - a] + 1;
                // 이번 인덱스가 처음 방문임 = 이전 횟수 + 1
                else min[i] = Math.min(min[i], min[i - a] + 1);
                // 처음 방문이 아님 = 기존 값과 이전 횟수 비교
            }

            // 위와 동일
            if (i - b >= 0 && min[i - b] > 0) {
                if (min[i] == 0) min[i] = min[i - b] + 1;
                else min[i] = Math.min(min[i], min[i - b] + 1);
                // a에 의해 값이 0이 아닐 경우가 있음
                // min[i - a]와 min[i - b]가 값이 다 있을 때를 여기서 처리함
            }

            // bw.write(Arrays.toString(min) + "\n"); // 테스트용 dp배열 출력함
        }
        
        if (min[dogs] != 0) { // 소환가능함
            bw.write(min[dogs] + "\n");
        } else // 0이라면 방문한 적 없음 = 소환 못함
            bw.write(-1 + "\n");

        bw.flush();
        bw.close();
    }

}
