import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);

		ArrayList<Fireball> arr = new ArrayList<>();
    // 파이어볼 리스트
		ArrayList<Fireball>[][] map = new ArrayList[n + 1][n + 1];
    // 각 좌표에 존재하는 파이어볼의 리스트
		int ans = 0;

		for (int i = 0; i < m; i++) {
			str = bf.readLine().split(" ");

			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			int ma = Integer.parseInt(str[2]);
			int sp = Integer.parseInt(str[3]);
			int d = Integer.parseInt(str[4]);
      // 좌표 두 개, 질량, 속도, 방향
			arr.add(new Fireball(s, e, ma, sp, d));
      // 파이어볼 리스트 추가
		}

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				map[i][j] = new ArrayList<Fireball>();
			}
		} // 맵 초기화

		for (int l = 0; l < k; l++) { // k번의 이동
			for (Fireball f : arr) { // 파이어볼 리스트 탐색

				f.s = (n + f.s + dx[f.d] * (f.sp % n)) % n;
				f.e = (n + f.e + dy[f.d] * (f.sp % n)) % n;
        // 파이어볼 위치 변경, 맵 바깥으로 넘어가지 않도록 % 연산 사용
				map[f.s][f.e].add(f);
        // 맵 좌표에 파이어볼 추가
			}
			
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) { // 각 좌표 탐색
					if (map[i][j].size() >= 2) { // 한 좌표에 파이어볼이 2개 이상
						int mass = 0; // 질량
						int speed = 0; // 속도
						boolean even = true; // 짝수 여부
						boolean odd = true; // 홀수 여부

						int cnt = map[i][j].size();

						while (!map[i][j].isEmpty()) {
							Fireball cur = map[i][j].remove(0);
							mass += cur.m;
							speed += cur.sp;
              // 해당 좌표에 존재하는 파이어볼 통합

							if (cur.d % 2 == 0) // 모두 짝수라면
								odd = false; // 홀수x
							else
								even = false; // 그 외엔 짝수 x

							arr.remove(cur); // 파이어볼 제거하기
						}

						int nm = mass / 5; // 질량 / 5
						if (nm == 0) // 질량이 0이 되면 제거
							continue;

						int ns = speed / cnt; // 속도는 총합 속도 / 파이어볼 개수

						if (odd | even) { // 홀수이거나 짝수라면
							for (int z = 0; z < 8; z += 2) { // 방향 0 2 4 6
								arr.add(new Fireball(i, j, nm, ns, z));
                // 파이어볼 새로 추가
							}

						} else { // 그 외엔
							for (int z = 1; z < 8; z += 2) { // 1 3 5 7
								arr.add(new Fireball(i, j, nm, ns, z));
                // 파이어볼 새로 추가
							}
						}
					} else { // 2개 이상이 아니면
						map[i][j].clear(); // 그냥 그 좌표 비우기
					}
				}
			}
		}

		for (Fireball f : arr) {
			ans += f.m; // 남아있는 맵의 질량 더하기
		}

		bw.write(ans + "\n"); // 출력

		bw.flush();
		bw.close();

	}

	public static class Fireball {
    // 파이어볼 클래스
		int s;
		int e;
		int m;
		int sp;
		int d;

		Fireball(int s, int e, int m, int sp, int d) {
			this.s = s;
			this.e = e;
			this.m = m;
			this.sp = sp;
			this.d = d;
		}

	}

}
