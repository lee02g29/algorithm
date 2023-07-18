import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		int cnt = Integer.parseInt( bf.readLine() ); // 1m^3당 참외의 개수
		
		int[] order = new int[7]; // 변의 길이를 저장하기
		int sum = 0; // 넓이
		int small_sum = 0; // 작은 사각형의 넓이
		
		int max1 = 0; // 가로 세로 중 긴 길이 저장
		int max1_index = 0; // 몇 번째로 입력을 받았는지
		
		int max2 = 0;
		int max2_index = 0;
    // 위가 가로였다면 여기서는 세로의 정보를 저장
    // 세로였다면 반대로
		
		int small1 = 0;
		int small2 = 0;
    // 작은 사각형의 변의 길이
		
	
		for(int i = 1; i < 7 ; i++) {
			String[] input = bf.readLine().split(" ");
			int dir = Integer.parseInt( input[0] ); // 방향
			int len = Integer.parseInt( input[1] ); // 변의 길이
			order[i] = len; // 정보 저장

      // 가로 세로 번갈아 나오므로, 분리해서 생각하기
			if(i % 2 == 0) { // 같은 가로 또는 세로 길이만 비교하기
				if(max1 < len) {
					max1 = len;
					max1_index = i;
				} // 제일 긴 길이 갱신, 인덱스 저장
			} else { // 같은 가로 또는 세로 길이만 비교하기, 위가 가로라면 이곳은 세로
				if(max2 < len) {
					max2 = len;
					max2_index = i;
				} // 제일 긴 길이 갱신, 인덱스 저장
			}
			
		}

    // 작은 사각형의 길이를 구하는 과정
    // 가장 긴 길이를 가진 두 변의 앞 뒤로 입력받은 값을 이용하기
    // 앞 뒤로 입력받은 값의 차 = 작은 사각형 한 변의 길이
    // 순서를 저장한 이유
    
		if(max1_index == 6) { // 마지막으로 입력받은 숫자라면
			small1= Math.abs(order[1]- order[5]); // 첫번째 숫자와 그 앞 숫자
		} else if (max1_index == 1){ // 첫 번째로 입력받은 숫자라면
			small1 = Math.abs(order[6]- order[2]); // 마지막 숫자와 그 뒷 숫자
		} else {
			small1 = Math.abs( order[max1_index - 1] - order[max1_index + 1] );
      // 그 외에는 앞 뒤로 입력받은 값들 이용하기
		}
		
		if(max2_index == 6) {
			small2 = Math.abs(order[1] - order[5]);
		} else if (max2_index == 1){
			small2 = Math.abs(order[6] - order[2]);
		} else {
			small2 = Math.abs( order[max2_index - 1] - order[max2_index + 1] );
		}
    // 위와 동일
		
		sum = max1 * max2; 
    // 작은 사각형을 고려하지 않고 가장 큰 길이를 이용하여 넓이를 구하기
		sum -= small1 * small2;
    // 작은 사각형의 넓이를 구해서 빼기
		
		bw.write( sum * cnt + "\n" );
    // 총 넓이 * 단위 넓이당 참외 수확 개수 = 답
		
		bw.flush();
		bw.close();

	}
}
