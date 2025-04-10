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

        String s = bf.readLine();
        int cnt = Integer.parseInt(s); // 개수

        String[] str = bf.readLine().split(" ");
        int[] weight = new int[cnt]; // 숫자들
        int max = 1; // 목표로 하는 수

        for (int i = 0; i < cnt; i++) {
            weight[i] = Integer.parseInt(str[i]);
        } // 숫자 입력받기

        Arrays.sort(weight); // 그리디 쓰려면 정렬해야함

        for (int i = 0; i < cnt; i++) {
            if (max < weight[i]) 
              // 목표수를 넘으면 해당 목표수를 만들 수 없음
                break;
            max += weight[i];
            // 그 외에는 현재 숫자를 더하면서 만들 수 있는 숫자 범위 확장
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }

}
