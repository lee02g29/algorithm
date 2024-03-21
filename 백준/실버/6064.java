import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(bf.readLine());

        while (test-- > 0) {
            String[] str = bf.readLine().split(" ");

            int m = Integer.parseInt(str[0]);
            int n = Integer.parseInt(str[1]);
            // x < m, y < n

            int x = Integer.parseInt(str[2]);
            int y = Integer.parseInt(str[3]);
            // (x, y)가 몇 번째 해인지 구하기

            int days = 0;
            int ans = -1;
            // 사이클, 답
            // 답을 구하지 못한다면 -1로 출력되도록

            int max = lcm(m, n);
            // 최소 공배수
            // 마지막 해는 최소 m과 n의 최소 공배수

            // x를 기준으로 판단하기
            while(days * m < max) {
                if((days * m + x - y) % n == 0) {
                  // 날짜를 m으로 나눈 나머지가 x
                  // 그와 동시에 n으로 나눈 나머지가 y
                  // 그 날짜가 답
                    ans = days * m + x;
                }
                days++;
            }

            bw.write(ans + "\n");
            // 답 출력
        }

        bw.flush();
        bw.close();
    }

    public static int gcd(int a, int b) {
      // 최대 공약수 gcd
      // gcd(a, b) = gcd(b, a % b)
      
        int r = 0;
        
        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    public static int lcm(int a, int b) {
      // 최소 공배수
      // a * b / 최대 공약수
        return (a * b) / gcd(a, b);
    }
}
