import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		int n = Integer.parseInt( str[0] );
		int m = Integer.parseInt( str[1] );
		
		int[][] prefix = new int[n + 2][n + 2];
		
		for(int i = 1; i <= n; i++) {
			str = bf.readLine().split(" ");
			
			for(int j = 1; j <= n; j++) {
				prefix[i][j] = Integer.parseInt(str[j - 1]) + prefix[i][j - 1]; // 같은 줄에서 구간 합 구하기
			}
			
			for(int j = 1; j <= n; j++) {
				prefix[i][j] += prefix[i - 1][j]; // 같은 세로줄? 에서 구간 합 구하기
			}
		}
		
		for(int i = 0; i < m; i++) {
			str = bf.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
      // 구간 합 구하고 싶은 좌표
			
			int sum = prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
            // 0,0 ~ x2,y2를 가진 사각형에서 0,0 ~ x-1, y2와 0,0 ~ x2, y-1 사각형의 넓이 빼기
            // 두번 빠진 부분 다시 더해주기
			
			bw.write(sum + "\n"); // 출력
		}	

		bw.flush();
		bw.close();
		
	}

}
