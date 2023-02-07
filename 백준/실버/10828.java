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
    	int[] stack = new int[n]; // 스택에 들어갈 숫자는 명령의 개수를 넘어설 수 없으므로, 배열의 크기는 n
    	int index = -1; // 스택 가장 위의 값의 위치(인덱스)를 저장할 변수. 0은 인덱스 값으로 존재하므로 x
    	
    	for(int i = 0; i < n; i++) {
    		stack[i] = -1; // 만약을 생각하여 -1으로 초기화. -1은 값이 없음을 뜻함
    	}
    	
    	for(int i = 0; i < n; i++) {
    		String[] str = bf.readLine().split(" ");
    		
    		switch(str[0]) {
    		case "push" : stack[++index] = Integer.parseInt( str[1] ); // 인덱스 값을 먼저 증가시키고, 그 위치에 값을 저장
    		break;
    		
    		case "pop" : if(index == -1) bw.write("-1" + "\n");
    		else {
    			bw.write( stack[index] + "\n");
    			stack[index--] = -1; // 현재 인덱스가 가리키는 자리의 값을 -1(없음)으로 바꾸고 인덱스 값 감소
    		}
    		break;
    		 		
    		case "size" : bw.write(index + 1 + "\n"); // length값을 써서는 안됨. -1이 들어있는 곳도 크기로 포함되기 때문.
    		break;
    		
    		case "empty" : if(index == -1) bw.write("1" + "\n");
    		else bw.write("0" + "\n");
    		break;
    		
    		case "top" : if(index == -1) bw.write("-1" + "\n");
    		else bw.write(stack[index] + "\n"); // index값이 가리키는 것은 스택 가장 위의 값.
    		break;

    		}
    	}
    		
    	bw.flush();
    	bw.close();
    }   
   
}
