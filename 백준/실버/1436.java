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
    	int count = 0;
    	int num = 666;
    	
    	while(num > 0) {
    		if( series(num) == true ) {
    			count++;
    		}
    		if( count == n ) {
    			bw.write(num + "\n");
    			break;
    		}
    		num++;   		
    	}
    	bw.flush();
    	bw.close();
    }   
    
    public static boolean series(int num) {
    	String str = Integer.toString(num);
    	int len = 0;
    	
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) == '6') {
    			len++;
    		} else len = 0; 
    		if(len == 3) break;
    	}
    	
    	if(len >= 3) return true;
    	else return false;
    }
}
