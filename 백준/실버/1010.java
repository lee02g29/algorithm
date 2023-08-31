import java.io.*;
import java.util.Arrays;


public class Main {
	static int[][] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		int n = Integer.parseInt( bf.readLine() );
		
		for(int t = 0; t < n; t++) {
			String[] str = bf.readLine().split(" ");
			int a = Integer.parseInt( str[0] );
            // 강 서쪽
			int b = Integer.parseInt( str[1] );
			// 강 동쪽
			nums = new int[b + 1][a + 1];

			bw.write(bino(b, a) + "\n");
      // 강 동쪽 C 강 서쪽
		}		
		
		
		bw.flush();
		bw.close();

	}
	
	public static int bino(int n, int k) {
		if(k == 0 || k == n) return 1; 
        // 0개를 고르거나, k개를 고르는 방법 = 1개
		else if(nums[n][k] != 0) return nums[n][k]; 
        // 메모이제이션, 이미 저장된 값 있으면 그거 반환
		else return nums[n][k] = bino(n - 1, k - 1) + bino(n - 1, k);
        // 저장된 값 없으면 이항계수 쓰기
	}

}
