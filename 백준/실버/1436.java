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
    	int count = 0; // n번째 시리즈 확인용 변수 
    	int num = 666; // 가장 최초 시리즈, 반복할 필요가 없는 숫자를 줄이기 위해 이 숫자부터 시작
    	
    	while(num > 0) { // 멈출 때까지 계속 반복
    		if( series(num) == true ) { // 6이 3개 이상인 것을 확인했다면 
    			count++; // count를 증가
    		}
    		if( count == n ) { // 입력받은 n번째 시리즈를 찾았다면
    			bw.write(num + "\n"); // 그 시리즈의 제목(숫자)를 출력
    			break;
    		}
    		num++; // 다음 숫자를 탐색	
    	}
    	bw.flush();
    	bw.close();
    }   
    
    public static boolean series(int num) {
    	String str = Integer.toString(num); // 문자열로 변환
    	int len = 0; // 6이 연속으로 몇번 나왔는지 체크하기 위한 변수
    	
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) == '6') { // 해당 문자가 6이라면
    			len++; // 연속횟수를 증가
    		} else len = 0; 
    		if(len == 3) break; // 6이 연속 3개 이상이라면 종료. 
            // 작은 수부터 처리하기 때문에 뒤의 숫자는 확인하지 않아도 ok
    	}
    	
    	if(len >= 3) return true;
    	else return false;
        // 6이 3개 이상이면 true, 아니면 false를 반환
    }
}
