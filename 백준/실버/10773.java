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
    	ArrayList<Integer> money = new ArrayList<>(); // 돈을 부르는 순서대로 저장할 arraylist
    	int ans = 0;
    	
    	for(int i = 0 ; i < n; i++) {
    		int num = Integer.parseInt( bf.readLine() ); // 이번에 부른 돈
    		if(num > 0) money.add(num); // 0을 제외한 나머지는 돈이므로, arraylist에 저장
    		if(num == 0) money.remove( money.size() - 1); // 0이면 잘못 부른 것이므로, 최근에 저장된 수를 지우기
    	}
    	
    	for(int i = 0; i < money.size(); i++) {
    		ans = ans + money.get(i); // arraylist를 순회하며 남은 수(써져있는 수) 더하기
    	}
    	
		bw.write(ans + "\n");
    	bw.flush();
    	bw.close();
    }   
   
}
