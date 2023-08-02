import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int switches = Integer.parseInt(bf.readLine());
		int[] conditions = new int[switches + 2];

		String[] str = bf.readLine().split(" ");

		for (int i = 0; i < switches; i++) {
			conditions[i + 1] = Integer.parseInt(str[i]);
		}

		int people = Integer.parseInt(bf.readLine());

		for (int i = 0; i < people; i++) {
			str = bf.readLine().split(" ");

			int type = Integer.parseInt(str[0]);
			int cnt = Integer.parseInt(str[1]);

			if (type == 1) { // 남학생

				for (int j = cnt; j <= switches; j = j + cnt) { 
          // cnt의 배수는 전부 스위치 상태 변경하기
					if (conditions[j] == 1)
						conditions[j] = 0;
					else
						conditions[j] = 1;
				}

			} else { // 여학생
				int idx = 0;

				while (cnt - idx > 0 && cnt + idx <= switches) {
          // 둘 중 한쪽이 끝에 닿을 때 까지
					if (conditions[cnt - idx] == conditions[cnt + idx]) { // 양 쪽이 같으면
						if (conditions[cnt - idx] == 0) { // 상태 변경
							conditions[cnt - idx] = 1;
							conditions[cnt + idx] = 1;
						} else {
							conditions[cnt - idx] = 0;
							conditions[cnt + idx] = 0;
						}
						idx++;

					} else // 한 번이라도 양쪽이 다르면 멈추기
						break;
				}
			}

		}

		for (int i = 1; i <= switches; i++) {
			bw.write(conditions[i] + " ");
			if (i % 20 == 0) { // 20줄마다 개행
				bw.write("\n");
			}
		}

		bw.write("\n");

		bw.flush();
		bw.close();
	}

}
