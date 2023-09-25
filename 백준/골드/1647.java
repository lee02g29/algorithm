import java.util.*;
import java.io.*;

class Main {
	public static int[] par;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
    // 집의 수, 길의 수
		
		par = new int[n + 1];
    // 대표 집 번호
    
		for(int i = 0; i <= n; i++) {
			par[i] = i;
		} // 최초의 대표 집 = 본인 집
		
		ArrayList<node> house = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			str = bf.readLine().split(" ");
			
			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			int len = Integer.parseInt(str[2]);
			
			house.add(new node(s, e, len));
		} // 시작집, 종료집, 유지비 저장
		
		Collections.sort(house);
    // 유지비 오름차순 정렬
		
		int ans = 0;
		int last = 0;
    // 하나의 마을일 때, 유지비
    // 마지막으로 저장된 유지비 = 제일 큰 유지비
    // 이걸 빼면 두 마을로 나뉘고, 유지비도 제일 작아짐
    
		for(int i = 0; i < m; i++) {
			int s = house.get(i).s;
			int e =  house.get(i).e;
			int len =  house.get(i).len;
			
			if(find(s) == find(e)) continue;
      // 같은 마을이면 패스

      // 아니면 같은 마을로 통합
			union(s, e);
			ans += len; // 총 유지비 체크
			last = len; // 마지막 유지비 갱신
		}
		
		bw.write(ans - last + "\n");
    // 총 유지비에서 마지막 유지비(제일 비싼거) 빼면
    // 마을 두 개로 분리가 가능
		
		bw.flush();
		bw.close();
	}
	
	public static int find(int x) {
		if(par[x] == x) return x;
		else return par[x] = find(par[x]);
	} // 대표 마을 찾기 = 파인드
  // 대표 마을이 본인이면 본인 반환
  // 아니라면 대표 마을을 찾아 저장하고 반환
	
	public static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(a == b) return;
		par[a] = b;
	} // 마을 통합
  // 같은 마을이면 x, 다른 마을이면 통합

  // 집 사이 길 클래스
	public static class node implements Comparable<node>{
		int s;
		int e;
		int len;
		
		public node(int s, int e, int len) {
			super();
			this.s = s;
			this.e = e;
			this.len = len;
		}

		@Override
		public int compareTo(node o) {
			return this.len - o.len;
		}
		
	}
}
