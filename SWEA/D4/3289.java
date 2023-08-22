import java.io.*;
import java.util.*;

public class Solved {

	static int[] par;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(bf.readLine());

		for (int t = 1; t <= test; t++) {
			String[] str = bf.readLine().split(" ");

			int n = Integer.parseInt(str[0]); // 집합 원소 개수
			int m = Integer.parseInt(str[1]); // m개의 연산

			par = new int[n + 1]; // 대표 노드 번호

			for (int i = 1; i <= n; i++) {
				par[i] = i; // 일단 대표는 자기자신
			}

			bw.write("#" + t + " "); // 출력 형식

			for (int i = 0; i < m; i++) {
				str = bf.readLine().split(" ");

				int type = Integer.parseInt(str[0]); // 연산 타입
				int a = Integer.parseInt(str[1]); // 원소 a
				int b = Integer.parseInt(str[2]); // 원소 b

				if (type == 0) { // 타입이 0이면 합치기
					union(a, b);
				} else if (type == 1) { // 타입이 1이면 같은 집합인지 확인하기
					if (find(a) == find(b)) {// 같은 집합이면
						bw.write(1 + ""); // 1 출력
					} else
						bw.write(0 + ""); // 아니면 0출력
				}
			}
			bw.write("\n"); // 연산 모두 진행 후 줄 넘김
		}

		bw.flush();
		bw.close();

	}

	public static int find(int x) { // 파인드
		if (x == par[x]) // 대표라면
			return x; // 대표 값을 반환
		else
			return par[x] = find(par[x]); 
    // 아니면 대표값을 저장하고 반환
	}

	public static void union(int x, int y) { // 유니온
		if (find(x) == find(y)) // 이미 같은 집합이면 패스
			return;
		else // 다르면
			par[find(y)] = find(x); 
    // y의 대표의 대표를 x의 대표로 설정하기
	}

}
