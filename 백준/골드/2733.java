import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

	 outer: for (int t = 1; t <= n; t++) {
			char[] point = new char[32768]; // 메모리사용을 줄이기 위해 char 쓰기
			int pointer = 0;

			Stack<Integer> stack = new Stack<>(); // 괄호 스택
			Map<Integer, Integer> map = new HashMap<>(); // 괄호 짝

			StringBuilder total = new StringBuilder(); // 문장을 1줄로 줄이는 용도
			StringBuilder ans = new StringBuilder(); // 답 
			int wrap = 0;

			ans.append("PROGRAM #" + t + ": \n"); // 답 출력 시작
			while (true) { // end가 나올 때까지 반복
				String temp = bf.readLine().replace(" ", ""); // 일단 공백 지우기

				if (temp.equals("end")) // 문자열이 end라면 종료하기
					break;

				if (temp.contains("%"))// %가 있다면 
					temp = temp.substring(0, temp.indexOf("%")); // %까지의 문자열 자르기
				total.append(temp); // 임시 문장에 추가하기

			}

			for (int i = 0; i < total.length(); i++) {
				if (total.charAt(i) == '[') { // [를 만났다면
					wrap++; // 괄호 체크용
					stack.add(i); // 스택에 넣기
				}
				if (total.charAt(i) == ']') { // [를 만났다면
					if (stack.size() == 0) { // 스택 사이즈가 0이면 짝이 안맞음
						ans.append("COMPILE ERROR"); // 에러문자 출력
						bw.write(ans + "\n"); 
						
						continue outer; // outer라고 이름 붙은 반복문 다음으로 넘기기
					}
					
					wrap--; // 그 외엔 괄호 개수 -1
					int temps = stack.pop(); // 스택에 있던거 빼기

					map.put(temps, i); 
					map.put(i, temps);
          // 괄호 짝 맵에 등록
				}
			}

			if (wrap != 0) { // 여는 괄호가 남았다는 뜻
				ans.append("COMPILE ERROR"); // 에러문자 출력
				bw.write(ans + "\n");
				continue;
			}

			for (int i = 0; i < total.length(); i++) { 
				if (total.charAt(i) == '+') { 

					if (point[pointer] == 255) {
						point[pointer] = 0;
					} else
						point[pointer]++;

				} else if (total.charAt(i) == '-') {

					if (point[pointer] == 0) {
						point[pointer] = 255;
					} else
						point[pointer]--;

				} else if (total.charAt(i) == '>') {

					if (pointer == 32767)
						pointer = 0;
					else
						pointer++;

				} else if (total.charAt(i) == '<') {

					if (pointer == 0)
						pointer = 32767;
					else
						pointer--;

				} else if (total.charAt(i) == '[') { // [를 만났다면
					if (point[pointer] == 0) { // 포인터가 가리키는 값이 0일때, 
						int idx = map.get(i); // 짝이 되는 괄호 위치로 이동하기
						i = idx;
					}
				} else if (total.charAt(i) == ']') { // ]를 만났다면

					if (point[pointer] != 0) { // 포인터가 가리키는 값이 0이 아닐때,
						int idx = map.get(i); // 짝이 되는 괄호 위치로 이동하기
						i = idx;
					}
				} else if (total.charAt(i) == '.') { // .이면 

					ans.append(point[pointer]); // 출력준비하기
				}
			}

			bw.write(ans + "\n"); // 출력

		}

		bw.flush();
		bw.close();

	}

}
