import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt( bf.readLine() );		
		int m = Integer.parseInt( bf.readLine() );
		int[][] dist = new int[n][n];		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if( i == j ) dist[i][j] = 0;
				else dist[i][j] = 1_000_000_001;
			}
		} // 초기값 세팅, i == j인 경우엔 안가니까 0
		
		for(int i = 0; i < m; i++) {
			String[] str = bf.readLine().split(" ");
			
			int s = Integer.parseInt( str[0] );
			int e = Integer.parseInt( str[1] );
			int l = Integer.parseInt( str[2] );
			
			if(dist[s-1][e-1] > l) dist[s-1][e-1] = l; 
		} // 데이터 입력, 같은 곳에 들어갈 수 있으므로 확인하기
		
		for(int i = 0; i < n; i++) { // 경유점
			for(int j = 0; j < n; j++) { 
				for(int k = 0; k < n; k++) { // 좌표 j, k
					
					if( dist[j][i] + dist[i][k] < dist[j][k] ) { // 경유점을 지난게 더 짧으면
						dist[j][k] = dist[j][i] + dist[i][k]; // 갱신
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(dist[i][j] == 1_000_000_001) bw.write("0 "); 
          // 최대값이 갱신이 안됨 = 안감 = 0으로 바꾸기
				else bw.write(dist[i][j] + " ");
			}
			bw.write("\n");
		} // 출력
		
		bw.flush();
		bw.close();

	}

}
