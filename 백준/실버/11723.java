import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int m = Integer.parseInt( bf.readLine() ); // 연산수
		
		ArrayList<Integer> arr = new ArrayList<>(); // 집합을 구현할 ArrayList
		
		for(int i = 0; i < m; i++) { 
			String[] str = bf.readLine().split(" ");
			int num = 0; // 숫자는 각 연산에서 처리, all의 경우는 숫자를 받지 않기 때문.
			
			switch(str[0]) { // 연산 종류 구분
			
			case "add" : // 숫자 추가
				num = Integer.parseInt( str[1] );
				if(!arr.contains(num)) arr.add(num); // 집합에 없으면 숫자추가
				break;
			
			case "remove" : // 숫자 제거
				num = Integer.parseInt( str[1] );
				if(!arr.contains(num)) break; // 집합에 없다면 연산 무시
				else {
					arr.remove(Integer.valueOf(num)); // 집합에 있다면 제거하기
				}
				break;
			
			case "check" :
				num = Integer.parseInt( str[1] );
				if(!arr.contains(num)) bw.write(0 + "\n"); // 숫자가 없다면 0출력
				else bw.write(1 + "\n"); // 숫자가 있다면 1출력
				break;
			
			case "toggle" :
				num = Integer.parseInt( str[1] );
				if(!arr.contains(num)) arr.add(num); // 숫자가 없다면 추가
				else arr.remove(Integer.valueOf(num)); // 숫자가 있다면 제거
				break;
			
			case "all" : // 집합을 1~20으로 만들기
				arr.clear(); // 미리 비워버리기
				for(int t = 1; t <= 20; t++) {
					arr.add(t);
				}
				break;
			
			case "empty" : // 집합 비우기
				arr.clear();
				break;
				
			}		
		}
		
		bw.flush();
		bw.close();

	}
}
