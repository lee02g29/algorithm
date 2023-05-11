import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      boolean[] check = new boolean[10001];
      
      for(int i = 1; i <= 10000; i++) { // 10000이하의 양의 정수만 체크
    	  int temp = i;
    	  int sum = i; // 기존의 수를 미리 저장
    	  
    	  while(temp > 0) { // 각 자리의 합을 더하는 과정
    		  sum += temp % 10;
    		  temp /= 10;
    	  }
    	  
    	  if(sum <= 10000) { // 더하는 과정에서 10000이 넘어가면 처리하지 않음
    		  check[sum] = true; // 해당 숫자의 생성자가 존재함을 의미
    	  }
 
      }
      
      for(int i = 1; i <= 10000; i++) {
    	  if(check[i] == false) { // 생성자가 없다면
    		  bw.write(i + "\n"); // 그 숫자를 출력
    	  }
    	  
      }
      
      bw.flush();
      bw.close();
      
    }
}
