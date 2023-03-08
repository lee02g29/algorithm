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
    	
    	int n = Integer.parseInt( bf.readLine() ); // n까지의 수
    	ArrayList<Integer> stack = new ArrayList<>(); // 스택 수열을 위한 스택
    	ArrayList<String> str = new ArrayList<>(); // pop, push연산 순서를 저장할 리스트
    	int current = 1; // 현재 추가해야할 숫자를 나타내는 변수
    	boolean check = true; // 스택 수열이 가능한지 여부
    	
    	for(int i = 0; i < n; i++) {
    		int t = Integer.parseInt( bf.readLine() ); // 출력해야할 숫자
    		
    		if(current <= t) { // 현재 추가해야할 숫자보다 출력해야할 숫자가 같거나 크다면
    			
    			while(current <= t) { // 출력해야할 숫자까지의 숫자들을 모두 스택에 넣기
    				stack.add(current);
    				str.add("+"); // push를 의미하는 +를 리스트에 저장
    				current++;
    			}
    			
    			stack.remove( stack.size() - 1); // 이후 맨 위의 숫자(출력해야할 숫자)를 스택에서 제거
    			str.add("-"); // pop을 뜻하는 -를 리스트에 저장
    		} else if(current > t) { // 현재 추가해야할 숫자보다 출력해야할 숫자가 작다면
    			
    			if(stack.get( stack.size() - 1 ) == t) { // 스택 맨위의 숫자와 출력해야할 숫자를 비교하고, 같다면
    				stack.remove( stack.size() - 1 ); // 그 값을 출력
        			str.add("-"); // pop을 뜻하는 -를 리스트에 저장
    			} else { // 같지 않다면
    				check = false; // 출력할 수 없으므로, check 값을 false로 바꾼다
    				break; // 이미 출력할 수 없음이 확인됐으므로 반복을 종료.
    			}
    		}
		
    	}
    	
    	if(check) { // 출력할 수 있는 수열이라면
			for(int k = 0; k < str.size(); k++) {
				bw.write(str.get(k) + "\n"); // 연산 순서를 저장한 리스트의 값을 출력
			}
		} else { // 출력할 수 없다면
			bw.write("NO" + "\n"); // 해당하는 문자열을 출력
		}
    	

    	bw.flush();
    	bw.close();
    }   
      	
}
