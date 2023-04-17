import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt( bf.readLine() ); // n!의 n을 입력받기
    
    // 팩토리얼의 0의 개수는 2와 5의 개수 중, 더 작은 값만큼의 개수를 갖는다.
    // 그렇지만 소인수 분해를 하면 항상 5의 개수가 더 적다. 그러니 5의 개수만 세기.
    
		int five = 0; // 소인수 분해 결과 5의 개수 세기
    // 소인수 분해시, 2의 개수는 항상 5의 개수보다 많기 때문에 5의 개수만 세기
		
		for(int i = 1; i <= n; i++) {  // 1~n까지의 숫자 탐색
			int temp = i;

			while(temp % 5 == 0) { // 5로 나누어지는 수라면
				five++; // 5의 개수 추가
				temp = temp / 5;
			}
		}
		
		bw.write(five + "\n"); // 5의 개수 출력
		
		bw.flush();
		bw.close();

	}
}
