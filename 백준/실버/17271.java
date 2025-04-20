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

        int n = Integer.parseInt(str[0]); // 싸움 시간
        int m = Integer.parseInt(str[1]); // B 시전시간

        int[] comb = new int[n + 1];

        comb[0] = 1; // 초기값,  여기서부터 A나 B를 붙일 수 있다는 1개의 출발점

        for (int i = 1; i <= n; i++) {
            comb[i] = comb[i - 1]; // i < m일 경우에는 A스킬만 사용 가능, 일종의 초기값
            if (i >= m)
                comb[i] = (comb[i] + comb[i - m]) % 1_000_000_007;
                // 마지막 스킬은 A 또는 B이므로, 1초 전과 m초 전을 고려하여 계산
        }

        bw.write(comb[n] % 1_000_000_007 + "\n"); // n초일 때 결과 출력

        bw.flush();
        bw.close();
    }

}
