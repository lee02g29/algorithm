import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine().trim()); 
    // 좌표의 개수, 이 문제는 좌표 개수 옆에 공백이 있어 오류가 난다.

		ArrayList<Integer> arr1 = new ArrayList<>(); // x 좌표 저장
		ArrayList<Integer> arr2 = new ArrayList<>(); // y 좌표 저장
		
		long total = 0L; // 합하다보면 int 범위 벗어날 수 있음

		for (int i = 0; i < n; i++) {
			String[] str = bf.readLine().trim().split(" "); // 혹시 모를 공백 방지용
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);

			arr1.add(x);
			arr2.add(y);
		} // 좌표를 입력받고 저장

		Collections.sort(arr1);
		Collections.sort(arr2);
    // 정렬

		int index = (int) Math.round((double) n / 2); // 중간 위치

		int half_1 = arr1.get(index - 1); 
		int half_2 = arr2.get(index - 1);
    // 각각 중간 값 구하기, 인덱스가 0부터 시작이므로 중간 위치 - 1 해주기

		for (int i = 0; i < n; i++) {
			total += Math.abs(half_1 - arr1.get(i)) + Math.abs(half_2 - arr2.get(i));
      // 중간값으로부터 모든 좌표의 거리 구하기
		}

		bw.write(total + "\n"); // 출력

		bw.flush();
		bw.close();
	}

}
