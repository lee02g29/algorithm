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
    	ArrayList<user> u = new ArrayList<>();
    	
    	for(int i = 0; i < n; i++) {
    		String[] input = bf.readLine().split(" ");
    		int age = Integer.parseInt(input[0]);
    		u.add( new user(age, input[1], i) ); // 나이, 이름, 가입순서 순
    	}
    	
    	Collections.sort(u);
    	
    	for(int i = 0; i < n; i++) {
    		bw.write(u.get(i).age + " " + u.get(i).name + "\n"); // 출력은 가입 순서를 제외하고 출력
    	}

    	bw.flush();
    	bw.close();
    }   
    public static class user implements Comparable<user>{ // 유저를 저장할 클래스, Comparable을 상속
    	int age; // 나이
    	String name; // 이름
    	int order; // 가입 순서, 임의로 설정한 변수
    	
    	user(int age, String name, int order) { // 생성자
    		this.age = age;
    		this.name = name;
    		this.order = order;
    	}
    	
    	@Override
    	public int compareTo(user u) { // compareTo함수 override
    		if(this.age == u.age) { // 나이가 같다면
    			return this.order - u.order; // 가입순서에 따라 정렬
    		} else {
    			return this.age - u.age; // 그 외에는 나이대로 정렬
    		}
    	} 	
    }
}
