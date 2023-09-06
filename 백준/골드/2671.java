import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = bf.readLine(); // 이번 스트링
		
		boolean submarine = str.matches("(100+1+|01)+"); 
    // (100~1~|01)~의 정규식 표현
    // ~ -> + -> 한 번 이상 등장함
		
		if(submarine) { // 정규식으로 나타낼 수 있다
			bw.write("SUBMARINE" + "\n"); // 잠수함임
		} else {
			bw.write("NOISE" + "\n"); // 소음임
		}
		
		bw.flush();
		bw.close();

	}
	
}
