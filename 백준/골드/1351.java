import java.util.*;
import java.io.*;

class Main {
	
	static Map<Long, Long> map;
	static int p, q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");
		
		Long n = Long.parseLong( str[0] );
		p = Integer.parseInt( str[1] );
		q = Integer.parseInt( str[2] );
    // 문제의 n, p, q
    // n은 10^12까지 갈 수 있으므로 long
		
		map = new HashMap<>();
    // i번째 숫자의 값
    // 배열로는 메모리 초과
    // 필요한 것만 저장하도록
		
		long ans = dp(n);
    // n부터 탑다운
    // 바텀업으로는 시간이 많이 들 것 같음
		
		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();
	}
	
	public static long dp(long n) {
		if(n == 0) return 1; // 문제의 조건에 따라 초기항은 1
		if(map.containsKey(n)) return map.get(n); 
    // n번째 값이 이미 구해졌다면 새로 구하지 않고
    // 있는 값 반환하기
		
		long x = (long) Math.floor(n / p);
		long y = (long) Math.floor(n / q);
    // 문제의 점화식
		
		map.put(n, dp(x) + dp(y));
    // 구한 결과 맵에 저장하기
		
		return map.get(n);
    // n번째 숫자 반환
	}

}
