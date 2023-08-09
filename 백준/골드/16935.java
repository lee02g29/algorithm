import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[][] ans;
	static int n, m;
	static int len;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");
		
		n = Integer.parseInt( str[0] );
		m = Integer.parseInt( str[1] );
		int r = Integer.parseInt( str[2] );
		
		arr = new int[n][m];
		
		len = Math.max(n,m);
		
		for(int i = 0; i < n; i++) {
			str = bf.readLine().split(" ");
			
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt( str[j] );
			}
		} // 배열 입력받기 
		
		str = bf.readLine().split(" ");
		
		for(int i = 0; i < r; i++) {
			int order = Integer.parseInt(str[i]);
      // 이번에 해야할 일
			
			if(order == 1) reverse_1();
			if(order == 2) reverse_2();
			if(order == 3) round_right();
			if(order == 4) round_left();
			if(order == 5) suffle_1();
			if(order == 6) suffle_2();
      // 경우에 따라 함수 호출하기
		}
		
		for(int i = 0; i < n; i++) {			
			for(int j = 0; j < m; j++) {
				bw.write(arr[i][j] + " "); 
			}
			bw.write("\n");
		} // 출력
		
		bw.flush();
		bw.close();
	}
	
	public static void reverse_1() { // 상하반전
		ans = new int[n][m]; // 답 배열
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				ans[n - i - 1][j] = arr[i][j];
			}
		} 
		
		arr = ans; // 갱신
	}
	
	public static void reverse_2() { // 좌우반전
		ans = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				ans[i][m - j - 1] = arr[i][j];
			}
		}
		arr = ans; // 갱신
	}
	
	public static void round_right() { // 오른쪽으로 회전
		ans = new int[m][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m ; j++) {
				ans[j][n - i - 1] = arr[i][j];
			}
		}
		
		int temp = n;
		n = m;
		m = temp;
    // 회전 중 배열의 크기가 변하므로 바꿔주기
    
		arr = ans; // 갱신

	}
	
	public static void round_left() {
		
		ans = new int[m][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m ; j++) {
				ans[m - j - 1][i] = arr[i][j];
			}
		}
		
		int temp = n;
		n = m;
		m = temp;
		// 회전 중 배열의 크기가 변하므로 바꿔주기
    
		arr = ans; // 갱신
	}
	
	public static void suffle_1() {
		ans = new int[n][m];
		
		int nn = n/2;
		int nm = m/2;
    // 4등분
		
		for(int i = 0; i < nn; i++) {
			for(int j = 0; j < nm; j++) {
				ans[i][j + nm] = arr[i][j];
			}
		} // 1 -> 2
		
		for(int i = 0; i < nn; i++) {
			for(int j = nm; j < m; j++) {
				ans[i + nn][j] = arr[i][j];
			}
		} // 2 -> 3

		
		for(int i = nn; i < n; i++) {
			for(int j = nm; j < m; j++) {
				ans[i][j-nm] = arr[i][j];
			}
		} // 3 - > 4
		
		
		for(int i = nn; i < n; i++) {
			for(int j = 0; j < nm; j++) {
				ans[i-nn][j] = arr[i][j];
			}
		} // 4 -> 1
		
		arr = ans; // 갱신
		
	}
	
	public static void suffle_2() {
		ans = new int[n][m];
		int nn = n/2;
		int nm = m/2;
    // 4등분
		
		for(int i = 0; i < nn; i++) {
			for(int j = 0; j < nm; j++) {
				ans[i + nn][j] = arr[i][j];
			}
		} // 1 -> 4
		
		for(int i = 0; i < nn; i++) {
			for(int j = nm; j < m; j++) {
				ans[i][j-nm] = arr[i][j];
			}
		} // 2 -> 1

		
		for(int i = nn; i < n; i++) {
			for(int j = nm; j < m; j++) {
				ans[i-nn][j] = arr[i][j];
			}
		} // 3 -> 2
		
		
		for(int i = nn; i < n; i++) {
			for(int j = 0; j < nm; j++) {
				ans[i][j+nm] = arr[i][j];
			}
		} // 4 -> 3
		
		arr = ans; // 갱신
		
	}

}
