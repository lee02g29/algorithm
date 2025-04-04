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

        int day = Integer.parseInt(str[0]);
        int comb = Integer.parseInt(str[1]);
        // 일수와 연속 일수

        int[] calc = new int[day + 1]; // 온도
        int[] pre = new int[day + 1]; // 누적합
        // 누적합할 때 -1 쉽게 하려고 크기 + 1
        int max = Integer.MIN_VALUE; // 최대값

        str = bf.readLine().split(" ");

        for (int i = 1; i <= day; i++) {
            calc[i] = Integer.parseInt(str[i - 1]);
        } 

        for (int i = 1; i <= day; i++) {
            pre[i] = pre[i - 1] + calc[i];
        } // 누적합 계산

        for(int i = comb; i <= day; i++) {
            int sum = pre[i] - pre[i - comb];

            max = Math.max(max, sum);
        } // k일 연속 합 = 누적합에서 k일 전까지의 누적합 값 빼기

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }

}
