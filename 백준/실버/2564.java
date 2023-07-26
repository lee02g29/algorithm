import java.io.*;
import java.util.*;

public class Main {
	static int w;
	static int h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		w = Integer.parseInt(str[0]); // 가로
		h = Integer.parseInt(str[1]); // 세로
		
		int n = Integer.parseInt( bf.readLine() );
		int[] len = new int[n + 1]; // 그 점까지의 길이
		int total = 0; // 최단 길이
		
		for(int i = 0; i < n + 1; i++) {
			str = bf.readLine().split(" ");
			
			int n1 = Integer.parseInt(str[0]); // 위치
			int n2 = Integer.parseInt(str[1]); 
      // 떨어진 거리, 북쪽과 남쪽은 왼쪽 경계로부터 떨어진 거리
      // 동쪽과 서쪽은 위쪽 경계로부터 떨어진 거리
			
			len[i] = findLen(n1, n2); // (0, 0)까지부터 점까지의 거리 함수 호출
			
		}
		
		for(int i = 0; i < n; i++) {
			int next = Math.abs(len[i] - len[n]) > 2 * h + 2 * w - Math.abs(len[i] - len[n]) ? 
					(2 * h + 2 * w) - Math.abs(len[i] - len[n]) : Math.abs(len[i] - len[n]);
					// | 경비원까지의 거리 - 점까지의 거리 |를 구하되, 경우에 따라 이 길이가 최단이 아닐 수 있음 
          // 그 때는 둘레에서 이 값을 빼면 더 짧으므로 그 값을 구하기
			total += next; 	// 구한 값 더하기
		}
		
		bw.write(total + "\n"); // 출력
		
		bw.flush();
		bw.close();
	}
	
	public static int findLen(int dir, int len) {
		if(dir == 1) return len; // 북쪽이면 len이 길이
		else if(dir == 2) return w + h + (w - len); 
      // 남쪽이면 가로 + 세로 + ( 가로 - 떨어진 길이 ), 
      // 총 길이를 셀 때는 오른쪽으로부터 세고, len은 왼쪽으로부터 떨어진 거리이기 때문에 주의
		else if(dir == 3) return 2 * w + 2 * h - len; // 서쪽이면 둘레에서 떨어진 거리 빼기
		else if(dir == 4) return w + len; // 동쪽은 가로 + 길이
		
		return 0; 
	}

}
