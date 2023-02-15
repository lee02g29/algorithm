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
    	
    	String str = "";
    	while((str = bf.readLine()) != null) { // EOF를 처리, EOF일때까지 반복하기
    		String[] string = str.split(""); // 문장을 한 글자씩 분리하기
    		ArrayList<Integer> stack = new ArrayList<>(); // 괄호 스택
    		boolean check = true; // 올바른 괄호쌍인지 확인여부
   
     		if(string[0].equals(".")) break; // 시작이 '.'이면 마지막이므로 종료

    		else { // 아니라면 괄호 처리를 하기
	    		for(int i = 0 ; i < string.length; i++) { // 한글자씩 체크, 
	    			if(string[i].equals("(")) { // 여는 소괄호라면
	    				stack.add(1); // 스택에 추가, 1은 임의로 정한 숫자
	    			} else if(string[i].equals(")")) { // 닫는 소괄호라면
	    				if(stack.size() == 0) { // 스택이 비었는지 확인하기 = 여는 소괄호 없이 닫는 소괄호가 먼저 왔는지 체크하기
	    					bw.write("no" + "\n"); // 비었다면 올바르지 않음
	    					check = false;
	    					break;
	    				}
	    				
	    				if(stack.get( stack.size() - 1 ) != 1 ) { 
                // 스택에 마지막으로 입력된 값이 같은 소괄호가 아니라면. = 괄호 내에 있는 괄호도 균형이 있어야함을 체크 ex '[(]'
	    					bw.write("no" + "\n"); // 올바르지 않음
	    					check = false;
	    					break;
	    				} else { // 같은 괄호쌍이므로
	    					stack.remove( stack.size() - 1 ); // 마지막에 입력된 값을 제거
	    				}
	    			}
	    			
	    			if(string[i].equals("[")) { // 여는 대괄호의 경우
	    				stack.add(2);
	    			} else if(string[i].equals("]")) { // 닫는 대괄호의 경우
	    				if(stack.size() == 0) {
	    					bw.write("no" + "\n");
	    					check = false;
	    					break;
	    				} // 여는 대괄호가 없었다면 x
	    				
	    				if(stack.get( stack.size() - 1 ) != 2) { // 이전 괄호가 대괄호가 아니면 x
	    					bw.write("no" + "\n");
	    					check = false;
	    					break;
	    				} else { // 같은 괄호쌍이므로
	    					stack.remove( stack.size() - 1 ); // 마지막에 입력된 값을 제거
	    				}
	    			}
	    			
	    		}
	    		
	    		if(check && stack.size() != 0) bw.write("no" + "\n"); // 모든 괄호를 확인했는데 스택이 비지 않았음 = 여는 괄호가 남았음 = 올바르지 않음
	    		else if(check) bw.write("yes" + "\n"); // 다 확인을 했고, 그럼에도 check변수가 true이면 옳은 괄호쌍
    		}
    	}
    	bw.flush();
    	bw.close();
    }   
      	
}
