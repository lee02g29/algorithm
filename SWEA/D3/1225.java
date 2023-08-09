import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt( bf.readLine() ); // 테스트케이스 번호
			
			String[] str = bf.readLine().split(" ");
			
			Queue<Integer> queue = new LinkedList<>(); 
      // 앞에서 숫자를 제거하여, 뒤로 넣기 위한 큐
			
			for(int j = 0; j < 8; j++) {
				queue.add( Integer.parseInt(str[j]) );
			} // 숫자 입력
			
			boolean check = true; // 반복 여부
			
			while(true) {
				for(int j = 1; j <= 5; j++) { 사이클마다 1~5빼기
					int temp = queue.poll() - j;
					
					if(temp <= 0) { // 숫자를 빼고 난 이후 0보다 작거나 같다면
						queue.add(0); // 0으로 큐에 넣고
						check = false; // 반복문 그만 돌기
						break;
					}
					else queue.add(temp); // 0보다 크면 큐에 그 숫자 넣기
				}
				if(!check) break;
			
			}
			
			bw.write("#" + t + " ");
			
			for(int j = 0; j < 8; j++) {
				bw.write(queue.poll() + " "); 
        // 큐 숫자 출력(암호문 출력)
			}
			
			bw.write("\n");

		}
		
		bw.flush();
		bw.close();

	}

}
