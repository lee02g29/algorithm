import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
     // 인출 시간이 짧은 사람이 먼저 인출해야, 인출 시간의 합이 가장 작다.
		int n = Integer.parseInt( bf.readLine() );
		
		String[] str = bf.readLine().split(" ");
		int[] time = new int[n + 1]; // 걸리는 시간 1~n까지 사용하기로 함
		int[] sum = new int[n + 1]; // n번째 사람이 인출하는데 걸리는 시간
		int ans = 0;
		
		for(int i = 1; i <= n; i++) { // 인덱스 1 ~ n까지 사용 
			time[i] = Integer.parseInt( str[i - 1] ); 
		}
		
		Arrays.sort(time); // 오름차순으로 정렬하기 = 작은 값부터 보기
		
		for(int i = 1; i <= n; i++) { // 1번째 사람이 인덱스 바깥을 참조하지 않도록, 인덱스 1~n까지 이용.
			sum[i] = sum[i-1] + time[i]; // i번째 사람이 인출하는데 걸리는 시간 = 이전 사람이 인출하는데 걸린 시간(대기 시간) + i번째 사람이 인출하는 시간
		}
		
		for(int i = 1; i <= n; i++) {
			ans += sum[i]; // 모든 사람들이 인출하는데 걸리는 시간을 합하기
		}

		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();

	}
}
