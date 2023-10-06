import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int target = Integer.parseInt(bf.readLine()); // 이동하고자 하는 채널
		int broken = Integer.parseInt(bf.readLine()); // 고장난 버튼수
		boolean[] nums = new boolean[10]; // 고장난 버튼 표기

		int ans = Math.abs(target - 100); 
    // 최초 채널은 100이고, 100까지 + - 버튼으로만 이동하는 값

		if (broken != 0) { // 고장난 버튼이 없다면 입력받지 않도록 하기
			String[] str = bf.readLine().split(" ");

			for (int i = 0; i < broken; i++) {
				int next = Integer.parseInt(str[i]);
				nums[next] = true;
			} // 고장난 버튼 번호에 표기해주기
		}

    // 0번부터 최대값 * 2 까지 완탐
		for (int i = 0; i <= 1000000; i++) {
			if (!check(i, nums)) { 
        // 해당 숫자가 고장난 번호를 포함하지 않음
				int temp = (int) (Math.log10(i) + 1);
        // 숫자의 길이
				if (i == 0) // 0이면 숫자의 길이가 1임
					temp = 1;

				temp += Math.abs(target - i);
        // 해당 숫자와 목표 채널 사이간의 간격

				if (temp < ans) // 횟수가 더 적다면 갱신
					ans = temp;
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
	}

	public static boolean check(int n, boolean[] nums) {
		if (n == 0) // 0이면 밑에 함수에 해당 x 따라서
			return nums[0]; // nums[0] 표기 상태 반환

		while (n > 0) { // 자리수 분해
			int check = n % 10;
			n = n / 10;

			if (nums[check]) // 해당 자리수가 고장난 숫자임
				return true; // 고장났음을 반환
		}

		return false; // 위에서 함수 호출이 안끝났음
    // = 고장난 숫자 없음
    // = 고장나지 않았음을 반환
	}

}
