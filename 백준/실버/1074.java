import java.util.*;
import java.io.*;

class Main {
	static int n, r, c, num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		n = Integer.parseInt(str[0]); // 2**n 
		r = Integer.parseInt(str[1]); // r행
		c = Integer.parseInt(str[2]); // c열

		num = 0; // 순서 번호

		square(0, 0, pow(n)); // 분할정복 시작

		bw.flush();
		bw.close();
	}

	public static void square(int sr, int sc, int size) { 
		if(sr == r && sc == c) { // 찾고자하는 곳이라면
			System.out.println(num); // 순서 출력
			return;
		}
		
		if (size >= 2) { // 사이즈가 2이상이면 분할
			if(sr + size >= r && sc + size >= c && sr <= r && sc <= c) {
        // 찾고자 하는 범위가 있는 곳만 탐색하기
				int half = size / 2; // 분할
				square(sr, sc, half); // 1번째
				square(sr, sc + half, half); // 2번째
				square(sr + half, sc, half); // 3번째
				square(sr + half, sc + half, half); // 4번쨰
        // z 탐색 순서
			}
			else {
				num += size * size; // 찾고자 하는 범위가 아니면 크기 만큼 순서 추가
				return;
			}
		} else { // 2이상이 아님 = 1임
			num++; // 숫자 하나만 추가
		}

	}
	
	public static int pow(int n) { // 2 제곱용 함수
		return (int) Math.pow(2, n);
	}

}
