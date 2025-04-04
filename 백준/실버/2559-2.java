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

        int[] calc = new int[day];
        int curSum = 0; // 현재 k일 연속 합
        int max = Integer.MIN_VALUE;

        str = bf.readLine().split(" ");

        for (int i = 0; i < day; i++) {
            calc[i] = Integer.parseInt(str[i]);
        } 

        for(int i = 0 ; i < comb; i++) {
            curSum += calc[i];
        } // 초기 k일 연속 합

        max = curSum;

        for(int i = comb; i < day; i++) {
            curSum = curSum + calc[i] - calc[i - comb];
            // 인덱스를 옮기면서 이전 인덱스의 값 빼고, 현재 인덱스의 값 합
            max = Math.max(max, curSum);
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }

}
