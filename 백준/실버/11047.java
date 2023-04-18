import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		int n = Integer.parseInt( str[0] ); // 동전 종류 개수
		int k = Integer.parseInt( str[1] ); // 맞추려는 금액
		
		int[] money = new int[n]; // 동전 종류를 저장할 배열
		int coin = 0; // 이번 동전을 몇 개나 골랐는지
		int ans = 0; // 총 몇개의 동전을 가지고 있는지
		int current = 0; // 가지고 있는 금액
		
		for(int i = 0; i < n; i++) {
			money[i] = Integer.parseInt( bf.readLine() );
		}
		
		for(int i = n - 1; i >= 0; i--) { 
      // 큰 금액부터 확인함, 금액은 오름차순으로 입력되는 것이 보장되어 있음
      // 큰 금액부터 확인하는 것이 최소 개수임이 보장됨
			coin = 0; 
			
			while(current + money[i] * coin <= k) { 
        // 현재 총 금액이 k원 이하이면, 동전을 하나 늘리기, 넘어설 때까지 반복하기
				coin++;
			}

			current += money[i] * (coin - 1); // k원을 넘어서면서 1개의 동전을 더 세기 때문에 -1 해주기.
			ans += (coin - 1);
			if(ans == k) break; // k원에 도달했다면 반복 멈추기
		}
		
		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();

	}
}
