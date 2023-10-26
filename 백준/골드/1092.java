import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());
		
		Integer[] crane = new Integer[n];
		// 크레인
		String[] str = bf.readLine().split(" ");
		
		
		for(int i = 0; i < n; i++) {
			crane[i] = Integer.parseInt(str[i]);
		} // 크레인의 최대 무게

		int m = Integer.parseInt(bf.readLine());
		
		ArrayList<Integer> weight = new ArrayList<>();
		// 박스 무게
		str = bf.readLine().split(" ");
		
		for(int i = 0; i < m; i++) {
			weight.add(Integer.parseInt(str[i]));
		} // 박스 무게 초기화	

		Arrays.sort(crane, Collections.reverseOrder());
		Collections.sort(weight, Collections.reverseOrder());
    // 둘 다 내림차순으로 정렬
		
		if(crane[0] < weight.get(0)) {
			bw.write("-1" + "\n"); 
      // 크레인의 최대 무게가 가장 큰 상자의 무게를 옮길 수 없다면
      // 다 옮길 수 없음을 의미
		} else {
			int cnt = 0; // 시간
			
			while(!weight.isEmpty()) { // 모든 상자를 옮길 때까지
				int index = 0; // 확인할 상자의 인덱스
				for(int i = 0; i < n;) { // 주의 i값을 증가시키지 않음
					if(index == weight.size()) break;
          // 상자의 끝까지 확인을 끝냈음 
          // = 이번 시간에 옮길 수 있는 건 다 옮김
          // 반복문 종료
					
					if(crane[i] >= weight.get(index)) {
						weight.remove(index);
						i++;	
            // 현재 크레인의 최대 무게가 
            // 확인중인 상자의 무게보다 크면
            // 상자를 옮기고
            // 다음 크레인 체크
					} else index++;
          // 그것이 아니면 다음 상자 확인
					
				}
				cnt++; // 시간 증가
			}
			
			bw.write(cnt + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	

}
