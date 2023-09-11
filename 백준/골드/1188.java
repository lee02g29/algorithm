import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		int n = Integer.parseInt( str[0] ); // n개의 소시지
		int m = Integer.parseInt( str[1] ); // m명의 평론가
		
		int ans = gcd(n,m);
		
		bw.write((m - ans) + "\n");
    // ( (m / gcd(n, m)) - 1) * gcd(n, m) = m - gcd(n, m) 
    // n개의 소시지를 붙여서 생각해보기, 
    // 각 평론가는 n/m개의 소시지를 받음
    // 자르는 횟수는 항상 조각수보다 한 개 작음
		
		bw.flush();
		bw.close();

	}

	public static int gcd(int a, int b) { 
    // 최대 공약수, 유클리드 호제법
		if(b == 0) return a;
		return gcd(b, a % b);
	}

}
