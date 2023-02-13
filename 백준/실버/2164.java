import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

class Main  {
    public static void main(String[] args) throws IOException{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt( bf.readLine() );
    	Queue<Integer> card = new LinkedList<>();
      // Queue를 사용하기, ArrayList는 시프트가 발생해서 시간초과가 발생함
    	
    	for(int i = 1; i <= n; i++) {
    		card.add(i); // 카드 값 순서대로 저장하기
    	}
    	
    	while(true) {
    		if(card.size() == 1) break; // 카드가 한장이 남으면 종료
    		else {
    			card.remove(); // 첫 값은 삭제하기
    			int num = card.remove(); // 그 다음 값은 빼서
    			card.add(num); // 뒤에 다시 넣기
    		}
    	}
    	
    	bw.write(card.peek() + "\n"); // 마지막으로 남은 숫자 출력하기
    	
    	bw.flush();
    	bw.close();
    }   
   
}
