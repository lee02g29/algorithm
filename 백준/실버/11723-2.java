import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int m = Integer.parseInt( bf.readLine() );
		
		int[] arr = new int[21]; // 있는지 확인할 배열을 구현, 0 없음 1 있음, 0번인덱스는 사용x
		
		for(int i = 0; i < m; i++) {
			String[] str = bf.readLine().split(" ");
			int num = 0;
			
			switch(str[0]) {
			
			case "add" : 
				num = Integer.parseInt( str[1] ); 
				if(arr[num] == 0) arr[num] = 1; // 숫자가 없다면 추가 -> 배열 값을 1로 변경
				break;
			
			case "remove" : 	
				num = Integer.parseInt( str[1] );
				if(arr[num] == 0) break; // 숫자가 없다면 연산 무시
				else {
					arr[num] = 0;  // 숫자가 있다면 삭제 -> 배열 값을 0로 변경
				}
				break;
			
			case "check" :
				num = Integer.parseInt( str[1] );
				if(arr[num] == 0) bw.write(0 + "\n"); // 숫자가 없다면 0출력
				else bw.write(1 + "\n"); // 숫자가 있다면 1출력
				break;
			
			case "toggle" :
				num = Integer.parseInt( str[1] );
				if(arr[num] == 0) arr[num] = 1; // 배열 값이 0이라면(숫자가 없다면) 1로 변경(숫자 추가)
				else arr[num] = 0; // 배열 값이 1이라면(숫자가 있다면) 0으로 변경(숫자 제거)
				break;
			
			case "all" :
				for(int t = 1; t <= 20; t++) { // 모든 값을 1로 변경
					arr[t] = 1;
				}
				break;
			
			case "empty" :
				for(int t = 1; t <= 20; t++) { // 모든 값을 0으로 변경
					arr[t] = 0;
				}
				break;
				
			}
			
		}
		
		bw.flush();
		bw.close();

	}
}
