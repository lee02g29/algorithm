import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt( bf.readLine() );
		int[] nums = new int[n + 1];
		Stack<Integer> stack = new Stack<>();
		
		String[] str = bf.readLine().split(" ");
		
		for(int i = 1; i <= n; i++) { // 숫자 입력
			nums[i] = Integer.parseInt( str[i - 1] );
		}
		
		nums[0] = 2_000_000_000; // 0번에 제일 높은 탑을 저장
		stack.push(0); // 스택에 0번째 탑 저장
		
		for(int i = 1; i <= n; i++) {
			while(!stack.empty() && nums[stack.peek()] < nums[i]) stack.pop(); 
      // 스택이 비지 않았고, i번째 탑보다 작은 높이의 탑들을 스택에서 제거
			bw.write(stack.peek() + " "); // i번째 탑보다 높은 탑 중, 가장 나중에 들어온 탑을 출력
			stack.push(i); // i번째 탑 스택에 저장
		}		
		
		bw.flush();
		bw.close();

	}

}
