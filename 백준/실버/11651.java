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
    	ArrayList<pair> coord = new ArrayList<>();
    	
    	for(int i = 0; i < n; i++) {
    		String[] nums = bf.readLine().split(" ");
    		int x = Integer.parseInt( nums[0] );
    		int y = Integer.parseInt( nums[1] );
    		coord.add(new pair(x, y));
    	}
    	
    	Collections.sort(coord);
    	
    	for(int i = 0; i < n; i++) {
    		bw.write(coord.get(i).x +" " + coord.get(i).y + "\n");
    	}

    	bw.flush();
    	bw.close();
    }   
    
    static class pair implements Comparable<pair>{ // 좌표를 저장할 pair 클래스
    	int x, y;
    	pair(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	
    	@Override
    	public int compareTo(pair p1) { // y값을 오름차순으로 정렬, 같다면 x의 값에 따라 정렬
        	if(this.y == p1.y) { // y의 값이 같다면
        		return this.x - p1.x;
                // 함수를 호출한 좌표의 x 값 > 매개변수로 입력된 좌표의 x 값 이라면
                // 객체의 자리를 자꾼다.
        	} else
        		return this.y - p1.y;
                // 함수를 호출한 좌표의 y 값 > 매개변수로 입력된 좌표의 y 값 이라면
                // 객체의 자리를 자꾼다.
        }
    }    
}
