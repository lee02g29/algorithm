import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] nums; // 초밥 번호 저장
		int start; // 시작 포인터
		int end; // 종료 포인터

		String[] str = bf.readLine().split(" ");
		HashSet<Integer> set = new HashSet<>();
		// 중복 없는 초밥 종류의 개수

		int n = Integer.parseInt(str[0]); // 초밥 개수
		int d = Integer.parseInt(str[1]); // 초밥 종류의 개수
		int k = Integer.parseInt(str[2]); // 연속 초밥 개수
		int c = Integer.parseInt(str[3]); // 쿠폰

		nums = new int[n];
		start = 0;
		end = start + k - 1; // 1번부터라 -1 해주기
		int max = 0;

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(bf.readLine());
		}

		for (int i = 0; i < n; i++) {
			set = new HashSet<>();

			start = i; // 시작 포인터
			end = (start + k - 1) % n; // 종료 포인터
			// 마지막 인덱스를 넘어가면 앞으로 가게끔

			if (start > end) { // 종료 포인터가 앞으로 갔다면 따로 처리 필요
				for (int j = start; j < n; j++) {
					set.add(nums[j]);
				}

				for (int j = 0; j <= end; j++) {
					set.add(nums[j]);
				}
			} else { // 일반 포인터는 편하게
				for (int j = start; j <= end; j++) {
					set.add(nums[j]);
				}
			}
			// 초밥 등록

			set.add(c); // 쿠폰 초밥 등록

			if (set.size() > max) // 종류가 제일 많다면 갱신
				max = set.size();
		}

		bw.write(max + "\n"); // 출력

		bw.flush();
		bw.close();

	}
}
