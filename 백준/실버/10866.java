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
    	ArrayList<Integer> deque = new ArrayList<>();
    	
    	for(int i = 0; i < n; i++) {
    		String[] str = bf.readLine().split(" "); // 첫번째는 명령, 두번째는 명령에 필요한 입력값
    		
    		switch(str[0]) {
    		case "push_front" : deque.add(0, Integer.parseInt(str[1]) ); // arraylist에서 특정 위치에 값을 입력하는 방법
    		break;
    		
    		case "push_back" : deque.add( Integer.parseInt(str[1]) );
    		break;
    		
    		case "pop_front" : if(deque.size() == 0) bw.write("-1" + "\n");
    		else bw.write( deque.remove(0) + "\n"); // arrsylist의 특정 위치의 값을 삭제하는 방법
    		break;
    		
    		case "pop_back" : if(deque.size() == 0) bw.write("-1" + "\n");
    		else bw.write( deque.remove( deque.size() - 1) + "\n"); // 맨 뒤의 값은 size() - 1. 인덱스가 0부터 시작하기 때문
    		break;    		
    		
    		case "size" : bw.write(deque.size() + "\n");
    		break;
    		
    		case "empty" : if(deque.size() == 0) bw.write("1" + "\n"); // 이 부분에 주의할 것. 다른 부분은 -1이지만, 이 부분은 1을 출력
    		else bw.write("0" + "\n");
    		break;
    		
    		case "front" : if(deque.size() == 0) bw.write("-1" + "\n");
    		else bw.write(deque.get(0) + "\n"); // arrsylist의 특정 위치의 값에 접근하는 방법
    		break;
    		
    		case "back" : if(deque.size() == 0) bw.write("-1" + "\n");
    		else bw.write(deque.get( deque.size() - 1) + "\n");
    		break;
    		}
    	}
    		
    	bw.flush();
    	bw.close();
    }   
   
}
