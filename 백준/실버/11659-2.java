import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		int[] prefix = new int[n + 2];

		str = bf.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			prefix[i] = Integer.parseInt(str[i - 1]) + prefix[i - 1]; 
            // 앞까지의 누적합 + 새로운 숫자 = 이번 누적합
		}
		
		for(int i = 0; i < m; i++) {
			str = bf.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int x2 = Integer.parseInt(str[1]);
			
			bw.write((prefix[x2] - prefix[x1 - 1]) + "\n");
            // x1번째 숫자도 포함하기 때문에 그 앞의 인덱스 값으로 빼줘야함
		}

		bw.flush();
		bw.close();

	}

}
