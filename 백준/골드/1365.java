import java.io.*;
import java.util.*;

public class Solved {
	static int[] lis;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		int[] nums = new int[n];
		int len = 0;
		int idx = 0;
		lis = new int[n + 1]; // 최장 증가 수열? 

		String[] str = bf.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(str[i]); // 전깃줄 연결상태 입력받기
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] > lis[len]) { 
        // 수열에 마지막으로 저장된 숫자보다 이번 숫자가 크다면
				len += 1; // 길이를 증가하고
				lis[len] = nums[i]; // 그 위치에 이번 값을 저장하기
			} else { // 작거나 같다면
				idx = binarySearch(0, len, nums[i]); 
        // 이번 숫자를 저장할 위치를 이진탐색으로 찾기
        // api를 쓴다면 입력할 위치를 따로 지정해주자
        
				lis[idx] = nums[i];
        // 저장할 위치에 이번 숫자 저장하기
			}

		}

		bw.write(n - len + "\n");
    // 전기줄 수 - 최장 수열 길이

		bw.flush();
		bw.close();

	}

	static int binarySearch(int left, int right, int find) { // 이진 탐색
		int mid = 0;

		while (left < right) {
			mid = (left + right) / 2;
			if (lis[mid] < find) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}

}
