import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

class Main  {
    public static void main(String[] args) throws IOException{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      //scanner로는 시간 초과가 되므로 bufferedReader를 활용하자
    		
    	String[] str = bf.readLine().split(" ");       
    	int a = Integer.parseInt( str[0] );
    	int b = Integer.parseInt( str[1] );
    	int v = Integer.parseInt( str[2] );
      // bufferedReader는 문자열로만 입력을 받는다. 따라서 따로 처리가 필요하다
    		
    	int up = a - b;
    	int days = (int)Math.ceil((double)(v - a) / up);
      // 높이 = ( 달팽이가 올라가는 높이 - 달팽이가 내려가는 높이 ) * 날짜 수 + 달팽이가 올라가는 높이
      // 따라서, 날짜 수 = ( 높이 - 달팽이가 올라가는 높이 ) / ( 달팽이가 올라가는 높이 - 달팽이가 내려가는 높이 )
      // 조건 상 달팽이가 내려가는 높이도 양수로 받기 때문에 빼기로 계산
      // 소수점으로 나오는 경우에도 하루로 취급하여 올림처리
    		
    	System.out.println(days + 1);
    	// 도달하는 것은 계산한 날짜 + 1일
    }   
    
}
