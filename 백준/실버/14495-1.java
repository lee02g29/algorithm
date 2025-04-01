import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    	
        
        String str = bf.readLine();

        int n = Integer.parseInt(str); // n번째 항

        long[] fibo = new long[n + 1]; // 피보나치 비스무리한 수 배열

        if(n <= 3) {
            bw.write(1 + "\n"); // 1 2 3일떈 1이므로 출력하고 끝

        } else {
            fibo[1] = 1;
            fibo[2] = 1;
            fibo[3] = 1;
            // 위와 따로 구분한 이유는 n = 1인데 배열 인덱스 2 3에 값을 입력하면 오류나서

            for(int i = 4; i <= n; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 3];
            } // 문제 그대로 점화식 쓰기

            bw.write(fibo[n] + "\n");
        }

        bw.flush();
        bw.close();
    }   
}
