import java.io.*;

public class Main {

	static int n, ans;
	static char[] str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt( bf.readLine() );
		
		str = bf.readLine().toCharArray();
		
		ans = Integer.MIN_VALUE;
    // 최대값을 찾을 땐 비교대상을 가장 작은 값으로
		
		find(2, str[0] - '0');
    // 괄호를 치지 않는다면 왼쪽과 비교하도록 하였음
    // 그래서 두 번째 숫자부터 시작
		
		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();
	}
	
	public static void find(int idx, int result) {
		
		if(idx >= n) {
			ans = Math.max(ans, result);
			return;
		} // 마지막 숫자의 인덱스를 넘어가면 최대값 찾고 백트래킹
    
		// 괄호 안치기	
		find(idx + 2, calc(result, str[idx - 1], str[idx] - '0'));
    // 다음 숫자로 넘어가고, 지금까지의 계산 결과 구하기
		
		// 괄호 치기 - 자신과 다음 숫자를 괄호로 묶기
		if(idx + 2 < n) {		
			int right = calc(str[idx] - '0', str[idx + 1], str[idx + 2] - '0');
      // 먼저 오른쪽 계산해오기
			int left = calc(result, str[idx - 1], right);
      // 지금까지의 값과 오른쪽 값을 계산하기

			find(idx + 4, left);
      // 오른쪽 숫자(바로 다음숫자)까지 계산했으므로 하나 건너뛰기
		}

	}

  // 계산하기
	public static int calc(int num1, char calc, int num2) {
		int ans = 0;
		
		if(calc == '*') {
			ans = num1 * num2;
		} else if(calc == '+') {
			ans = num1 + num2;
		} else if(calc == '-') {
			ans = num1 - num2;
		}
		
		return ans;
	}

}
