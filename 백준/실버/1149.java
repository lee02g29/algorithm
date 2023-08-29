import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		int n = Integer.parseInt( bf.readLine() );
		
		int[][] cost = new int[n][3]; // 비용
		int[][] colors = new int[n][3]; // 집을 각각의 색으로 칠할 때 최소값
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			String[] str = bf.readLine().split(" ");
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt( str[j] );
			}
		}
		
		for(int i = 0; i < 3; i++) {
			colors[0][i] = cost[0][i];
		} // 초기값은 첫번째 집이 각각의 색으로 칠했을 때
		
		for(int i = 1; i < n; i++) {
			colors[i][0] = Math.min(colors[i-1][1], colors[i-1][2]) + cost[i][0];
            // i번째 집을 0번째 색으로 칠하려면 = (이전의 집을 1번째 색으로 칠하거나, 2번째색으로 칠한 값 중 최소값) 
            // + 이번 집을 0번째 색으로 칠하는 값
            // 즉, 같은 색으로 칠하는 경우는 계산하지 않으면 ok
			colors[i][1] = Math.min(colors[i-1][0], colors[i-1][2]) + cost[i][1];
			colors[i][2] = Math.min(colors[i-1][0], colors[i-1][1]) + cost[i][2];
            // 이후도 마찬가지
		}
		
		for(int i = 0; i < 3; i++) {
			ans = Math.min(ans,colors[n-1][i]);
		} // 마지막 집까지 칠한 비용을 탐색, 최소값을 찾기
		
		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();
	}

}
