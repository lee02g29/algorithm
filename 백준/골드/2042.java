import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

        /*
            문제 조건에 따라 2^63-1은 int의 범위를 벗어나므로,
            숫자 값에 해당하면 모두 long으로 해줄 것
			런타임 에러의 주된 원인
        
        */

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
        // n개의 숫자, m개의 변경 연산, k개의 조회연산

		FenwickTree tree = new FenwickTree(n);
        // 펜윅트리

		for (int i = 1; i <= n; i++) {
			long num = Long.parseLong(bf.readLine());
			
			tree.add(num, i); // 정해진 위치에 숫자 넣기
		}

		for (int i = 0; i < m + k; i++) {
			str = bf.readLine().split(" ");

			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
            // a : 타입, b : 위치

			if (a == 1) {
				long c = Long.parseLong(str[2]);
                // 이곳을 주의할 것. 
                // 숫자를 입력할 때 c는 숫자의 값임
                // 즉 int값 벗어날 가능성 매우 높음
				tree.add(c, b);
			} else if (a == 2) {
				int c = Integer.parseInt(str[2]);
				bw.write(String.valueOf(tree.sum(b, c)) + "\n");
                // b ~ c까지 합 출력
			}
		}

		bw.flush();
		bw.close();

	}

	public static class FenwickTree {
		long[] tree; // 펜윅 트리 값
		long[] arr; // 원본 값

		public FenwickTree(int size) {
			tree = new long[size + 1];
			arr = new long[size + 1];
		}

		long sum(int pos) {
			long ans = 0L;

			while (pos > 0) {
				ans += tree[pos];
				pos &= (pos - 1);
                // 해당 위치의 값을 저장한 위치에서
                // 값을 찾아 모두 저장
			}

			return ans;
		}

		void add(long num, int pos) {
			long next = num - arr[pos];
			arr[pos] = num;
            // 수정이 아니라, 누적이 되지 않도록
            // 이후 원본 저장
            // 이 부분 없으면 수정이 아니라
            // 누적되버림
			
			while (pos < tree.length) {
				tree[pos] += next;
				pos += (pos & -pos);
			} // 해당 위치를 포함하는 
            // 모든 곳에 이번 값 저장하여 
            // 누적합 저장하기
		}
		
		long sum(int left, int right) {
			return sum(right) - sum(left - 1);
            // left~right 누적합 구하기
            // left를 포함해야하므로, 그 이전으로
		}

	}

}
