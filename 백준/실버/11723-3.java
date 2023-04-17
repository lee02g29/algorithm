import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int m = Integer.parseInt( bf.readLine() );
		
		int bit = 0; // 비트마스킹 방식을 사용. 초기엔 아무 숫자도 없으므로 0 
    // 1의 자리 숫자도 사용함(0번째 인덱스), 따라서 숫자를 입력받고 사용할 때 -1이 됨을 주의할 것.
		
		for(int i = 0; i < m; i++) {
			String[] str = bf.readLine().split(" ");
			int num = 0;
			
			switch(str[0]) {
			
			case "add" : 
				num = Integer.parseInt( str[1] );
				bit |= (1 << (num-1)); // 1을 왼쪽으로 (num-1)만큼 시프트, bit값과 or 연산으로 값을 추가한다.
				break;
			
			case "remove" : 	
				num = Integer.parseInt( str[1] );
				bit &= ~(1 << (num-1)); // 1을 왼쪽으로 (num-1)만큼 시프트하고 not연산으로 비트를 반전, 그리고 bit값과 and 연산을 통하여 값을 제거.
        // not연산을 통하여 그 위치의 비트값은 0이 되고, and연산을 하면 1 & 0 -> 0이 되어 제거. 0 & 0 -> 0
				break;
			
			case "check" :
				num = Integer.parseInt( str[1] );
				if( (bit & (1 << (num-1)) ) == 0) bw.write(0 + "\n"); // 1을 왼쪽으로 (num-1)만큼 시프트 후 bit값과 and 연산. 그 결과 0이었으면 그 값은 없었던 것.
				else bw.write(1 + "\n"); // 결과가 1이었으면 값은 있었던 것. 
				break;
			
			case "toggle" :
				num = Integer.parseInt( str[1] );
				bit ^= (1 << (num-1)); // 1을 왼쪽으로 (num-1)만큼 시프트 후 bit값과 xor연산. 0 ^ 1 = 1(값이 없었던 경우), 1 ^ 1 = 0(값이 있었던 경우)
				break;
			
			case "all" :
				bit |= ~(1 << 20); // 1을 왼쪽으로 20만큼 시프트 후 not연산으로 비트를 반전. bit값과 or 연산을 통하여 모든 값을 1로. 
        // 이 코드에서는 범위로 0~19를 사용하므로 20까지 시프트해주어야 함. 만약 1~20를 사용한다면 21까지 시프트할 것.
				break;
			
			case "empty" :
				bit = 0; // 0으로 만들면 모든 비트가 0이 되므로, 없는 것이 됨
				break;
				
			}			
		}
		
		bw.flush();
		bw.close();

	}
}
