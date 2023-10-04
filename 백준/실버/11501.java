import java.io.*;
import java.util.*;

public class Main {

	public static int[] pi;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(bf.readLine());
		// 테스트 케이스 
		for(int t = 0; t < test; t++) {
			int day = Integer.parseInt(bf.readLine());
      // 날짜
			
			String[] str = bf.readLine().split(" ");
			long[] pay = new long[day];
      // 매일 주가 -> 문제의 조건에 따라 64비트
			
			for(int i = 0; i < day; i++) {
				pay[i] = Integer.parseInt( str[i] );
			}
			
			long max = pay[day - 1]; 
      // 그 날짜에서의 최고 주가 -> 이 가격으로 팔 것
			long money = 0;
			// 이익 -> 마찬가지로 문제의 조건에 따라 64비트
      
			for(int i = day - 1; i >= 0; i--) { 
        // 뒤에 날짜부터 확인함
				if(pay[i] > max) { // 최대값이 더 큰 날이 있다면 
					max = pay[i]; // 최대값 갱신
				} else {
					money += max - pay[i];
          // 그 외에는 최대값 - 그날 주가
          // 주식을 팜
				}
			}
			
			bw.write(money + "\n");
      // 이익 출력
			
		}
		
		bw.flush();
		bw.close();

	}

}
