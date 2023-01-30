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
    	ArrayList<Size> people = new ArrayList<>();
    	
    	for(int i = 0; i < n; i++) {
    		String[] str = bf.readLine().split(" ");
    		int weight = Integer.parseInt( str[0] );
    		int height = Integer.parseInt( str[1] );
    		people.add( new Size(weight, height) ); 
    	}
    	
    	for(int i = 0; i < n; i++) {
    		int rank = 0; // 덩치 순위
    		for(int j = 0; j < n; j++) {
    			if(i == j) continue; // 같은 사람과 비교는 하지 않기
    			else {
    				rank = rank + calc(people.get(i), people.get(j));
            // 덩치가 크면 1을 반환 받기에 그냥 더하기
    			}
    		}
    		bw.write( (rank + 1) + " ");
        // 문제에 나온대로 순위는 자신보다 덩치가 큰 사람 + 1
    	}

    	bw.flush();
    	bw.close();
    }   
    
    public static class Size{
    	int weight;
    	int height; 
 	
    	Size(int w, int h) {
    		this.weight = w;
    		this.height = h;
    	}	
    }
    
    public static int calc(Size s1, Size s2) { // s1 : 순위를 측정할 대상 s2 : 비교 대상
		if(s1.weight < s2.weight && s1.height < s2.height) { // 덩치가 s1 < s2이면 
			return 1; // 1을 반환, 반환한 값을 바로 더할 예정이기 때문
		} else return 0; // 그 외에는 0을 반환
	}
}
