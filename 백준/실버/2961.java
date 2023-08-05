import java.util.*;
import java.io.*;

class Main {
	static ArrayList<Pair> arr;
	static int min;
	static boolean[] visit; // 안썼음
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		arr = new ArrayList<>();
		
		int cnt = Integer.parseInt(bf.readLine());
		visit = new boolean[cnt];
		
		int sour = 0; // 신맛
		int bitter = 0; // 쓴맛
		min = Integer.MAX_VALUE; // 최소값 찾기

		for (int i = 0; i < cnt; i++) { 
			String[] str = bf.readLine().split(" ");
			
			sour = Integer.parseInt( str[0] );
			bitter = Integer.parseInt( str[1] );
			
			arr.add(new Pair(sour, bitter));

		} // 입력받기

		find(0, 0, 1, 0); 
    // 부분 집합 구하기. 신맛은 곱하기를 해야해서 1부터.
		bw.write(min + "\n");
		
		bw.flush();
		bw.close();

	}

	public static void find(int cur, int cnt, int sour, int bitter) { 
		// 부분 집합. 현재 인덱스, 고른 숫자, 현재까지의 신맛, 현재까지의 쓴 맛
		
		if(cur == arr.size()) { // 마지막 재료까지 왔다면
			
			if(cnt!= 0 && min > Math.abs(sour - bitter)) { 
        // 재료를 하나 이상 골랐고, 신맛과 쓴맛의 차가 저장한 값보다 작다면
				min = Math.abs(sour - bitter); // 갱신
			} // 경우에 따라 절대값 처리를 안하면 음수가 나옴.
			
			return;
		}		
			
		find(cur + 1, cnt + 1, sour * arr.get(cur).s, bitter + arr.get(cur).b );
    // 이번 재료를 골랐을 때. 신맛은 곱하기, 쓴맛은 더하기.
			
		find(cur + 1, cnt, sour, bitter);
    // 이번 재료를 고르지 않았을 때. 변동 없음

	}
	
	public static class Pair { // 재료 정보 저장용 클래스
		int s;
		int b;
		
		Pair(int s, int b) {
			this.s = s;
			this.b = b;
		}
	}

}
