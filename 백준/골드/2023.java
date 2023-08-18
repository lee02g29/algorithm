import java.util.*;
import java.io.*;

class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(bf.readLine());
    // 자리수

		recur(0, 0); // 0부터, 0번째 자리부터

		bw.flush();
		bw.close();

	}

	public static void recur(int num, int len) {
		if(len == n) {
			System.out.println(num);
			return;
		} // 목표로하는 자리수에 도달 = 출력
		
		for(int i = 1; i <= 9; i++) {
			if(isPrime(num * 10 + i)) { 
        // 이전 숫자 * 10 + i가 소수라면
				recur(num * 10 + i, len + 1);
        // 만들어진 숫자와 길이를 + 1하여 다시 호출
			}
		}
	}

	public static boolean isPrime(int n) {
		if (n == 0 || n == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) { 
      // 소수 판별은 제곱수까지만 해도 ok
			if (n % i == 0) { // 나누어떨어지는 수가 있다면
				return false; // 소수 아님
			}
		}

		return true; // 위에서 안걸려지면 소수임
	} // 해당 숫자 소수 판별 함수

}
