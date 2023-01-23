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
    	int[] order = new int[n];
    	
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
    
    static class pair implements Comparable<pair>{
    	int x, y;
    	pair(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	
    	@Override
    	public int compareTo(pair p1) {
        	if(this.x == p1.x) {
        		return this.y - p1.y;
        	} else
        		return this.x - p1.x;
        }
    }    
}
