import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int n, m, nums[]; 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		n = Integer.parseInt( str[0] ); // n개의 숫자
		m = Integer.parseInt( str[1] ); // m개 고르기
		nums = new int[m];
		
		find(0, 1); // start는 1부터
	}
	
	public static void find(int cnt, int start) {
		if(cnt == m) { // m개를 골랐다면
			for(int i = 0; i < m; i++) { // 출력하기
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i = start; i <= n; i++) { 
      // 시작 숫자는 start부터. 오름차순으로 하면 중복이 없음.
			nums[cnt] = i;
			
			find(cnt + 1, i + 1); 
      // 골랐으므로 cnt + 1, 다음 start는 이번 i의 다음 숫자
			
		}
	}

}
