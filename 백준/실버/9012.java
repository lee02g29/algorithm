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
    	
    	int n = Integer.parseInt( bf.readLine() ); // 테스트 케이스 개수

    	for(int t = 0; t < n; t++) { // 테스트 케이스 수 만큼 반복하기
    		String[] str = bf.readLine().split(""); // 괄호를 분리하기
    		int check = 0; // VPS 체크용 변수. 확인이 끝났을때 0이 되어야 VPS라고 할 수 있다.
    		
    		for(int i = 0; i < str.length; i++) {
    			if(str[i].equals("(")) { // 괄호가 '(' 라면
    				check++; // 체크 + 1
    			} else if(str[i].equals(")")) { // 괄호가 ')'라면
    				check--; // 체크 - 1
    			}
    			
    			if(check < 0) { // 체크의 값이 0미만이면 ')'괄호가 쌍을 이루지 못하는 경우가 있다는 뜻이므로
    				break; // 바로 확인 종료
    			}
    		}
    		
    		if(check == 0) bw.write("YES" + "\n"); // 체크의 값이 0이다 = 모든 괄호가 정상적인 쌍을 이루었다 = VPS다
    		else bw.write("NO" + "\n"); // 체크의 값이 0이 아니다 = 모든 괄호가 정상적인 쌍을 이루지 못했다 = VPS가 아니다
        // 참고 : 체크의 값이 0보다 크면 '('가 더 많음을 의미, 0보다 작으면 ')'가 더 많음을 의미
		}
		
    	bw.flush();
    	bw.close();
    }   
   
}
