import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = bf.readLine();
		int num = Integer.parseInt( bf.readLine() ); // num번 째 문자를 출력하기
		bw.write(str.charAt(num - 1) + "\n"); // 문자의 인덱스는 0부터이고, 입력값은 1부터이니 1을 빼주기
		
		bw.flush();
		bw.close();

	}
}
