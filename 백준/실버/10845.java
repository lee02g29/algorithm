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
    	ArrayList<Integer> queue = new ArrayList<>();
    	
    	for(int i = 0; i < n; i++) { // switch - case문
    		String[] str = bf.readLine().split(" "); // push인 경우, push할 숫자도 같이 들어오기 때문에 배열로 처리
    		
    		switch(str[0]) {
    		case "push" : queue.add( Integer.parseInt(str[1]) );
    		break;
    		
    		case "pop" : if(queue.size() == 0) bw.write("-1" + "\n");
    		else bw.write( queue.remove(0) + "\n");
    		break;
    		
    		case "size" : bw.write(queue.size() + "\n");
    		break;
    		
    		case "empty" : if(queue.size() == 0) bw.write("1" + "\n");
    		else bw.write("0" + "\n");
    		break;
    		
    		case "front" : if(queue.size() == 0) bw.write("-1" + "\n");
    		else bw.write(queue.get(0) + "\n");
    		break;
    		
    		case "back" : if(queue.size() == 0) bw.write("-1" + "\n");
    		else bw.write(queue.get( queue.size() - 1) + "\n");
    		break;
    		}
        // 각 출력에 개행문자와 각 case문에 break를 붙여주는 것을 잊지 말기
    	}
    		
    	bw.flush();
    	bw.close();
    }       

}
