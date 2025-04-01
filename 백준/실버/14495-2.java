import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static long[] fibo;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    	
        
        String str = bf.readLine();

        int n = Integer.parseInt(str);

        fibo = new long[n + 1];

        if(n <= 3) {
            bw.write(1 + "\n");

        } else {
            fibo[1] = 1;
            fibo[2] = 1;
            fibo[3] = 1;

            for(int i = 4; i <= n; i++) {
                fibo[i] = fibonacci(i - 1) + fibonacci(i - 3);
            } // 연산 횟수 개선된 부분. 메모이제이션 활용

            bw.write(fibo[n] + "\n");
        }

        bw.flush();
        bw.close();
    }   

    public static long fibonacci(int n) {
        if(fibo[n] != 0) { // 1 2 3은 함수로 안들어와서 따로 처리 안해도 ok
            return fibo[n]; // 이미 값이 있으면 값 반환
        } else {
            return fibo[n] = fibonacci(n - 1) + fibonacci(n - 3);
            // 값 없으면 계산하여 반환
        }
    }
}
