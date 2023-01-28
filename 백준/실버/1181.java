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
    	HashSet<String> input = new HashSet<>(); // 중복제거용 hashSet
    	ArrayList<Voca> voca = new ArrayList<>();
    	
    	for(int i = 1; i <= n; i++) {
    		String str = bf.readLine();
    		input.add( str ); // hashSet에 저장
    	}
    	
    	for(String str : input) { 
    		// hashSet은 순서가 고려되지 않기 떄문에 인덱스를 통한 값 확인이 안됨
    		// for each 구문을 활용하여 접근해야 함
    		voca.add(new Voca(str));
    	}
    	
    	Collections.sort(voca);
    	
    	for(int i = 0; i < voca.size(); i++) { 
    		// 중복제거를 통하여 arrayList의 사이즈는 n보다 작아질 수 있다
    		bw.write(voca.get(i).str + "\n");
    	}

    	bw.flush();
    	bw.close();
    }   
    
    public static class Voca implements Comparable<Voca>{
    	String str;
    	int len; // 길이를 저장할 임의의 변수
 	
    	Voca(String str) {
    		this.str = str;
    		this.len = str.length();
    	}
    	
    	@Override
    	public int compareTo(Voca v) {
    		if(this.len == v.len) { // 길이가 같다면
    			return this.str.compareTo(v.str);
    			// compareTo를 활용하여 사전 순으로 정렬
    		} // 그 외엔 길이순으로 정렬
    		else return this.len - v.len;
    	}
    }
}
