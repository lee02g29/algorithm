import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
      int n = Integer.parseInt( bf.readLine() ); // 단어 수
      
      int cnt = 0;
      boolean check = true; // 이번 단어가 그룹단어인지 여부
      
      for(int i = 0; i < n; i++) {
          String str = bf.readLine(); // 이번 단어 입력받기
          char[] ch = str.toCharArray(); // String을 char배열로 변환하기
          
    	  boolean[] alpha = new boolean[27]; // 알파벳이 이미 등장했는지 여부 배열
    	  check = true; // 일단은 그룹단어라고 가정하기

    	  for(int j = 0; j < ch.length - 1; j++) { 
          // 단어를 구성하는 글자들 확인하기 -> 2개씩 체크할 예정이기에 끝까지 탐색하지 않음
        	  char c1 = ch[j]; // 글자1
        	  char c2 = ch[j + 1]; // 글자1의 다음 글자
        	  
        	  if(c1 != c2) { // 글자가 서로 다르다면
        		  
        		  if( alpha[(int)(c1 - 'a')] ) { // 글자1이 이미 등장한 적이 있다면
        			  check = false; // 이 단어는 그룹단어가 아님
        			  break;
        		  } else { // 등장한 적이 없다면
        			  alpha[(int)(c1 - 'a')] = true;  // 등장했음을 저장함
        		  }
        	  }
        	  
          }
    	  
    	  if( alpha[ ch[ch.length - 1] - 'a'] ) check = false; // 마지막 글자를 체크, 등장한 적이 있다면 그룹단어가 아님
    	  
    	  if(check) cnt++; // 그룹 단어가 맞다면 숫자 증가시키기
    	  
      }
      
      bw.write(cnt + "\n");
      
      
      bw.flush();
      bw.close();
      
    }
}
