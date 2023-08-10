import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) { // 케이스는 여러 번
			String[] str = bf.readLine().split(" ");

			int m = Integer.parseInt(str[0]); // 집의 수
			int n = Integer.parseInt(str[1]); // 길의 수
			
			if(m == 0 && n == 0) break; 
      // 문제 조건에 따라 둘 다 0이면 종료

			parent = new int[m + 1]; // 부모 노드 저장용

			int sum = 0; // 원래 총 길이
			int total = 0; // 줄이고 난 길이

			ArrayList<Pairs> arr = new ArrayList<>();

			for (int i = 0; i <= m; i++) {
				parent[i] = i; // 최초의 부모는 자신
			}

			for (int i = 0; i < n; i++) {
				str = bf.readLine().split(" ");

				int a = Integer.parseInt(str[0]); // 시작점
				int b = Integer.parseInt(str[1]); // 종료점
				int v = Integer.parseInt(str[2]); // 길이

				sum += v; // 길이 더하기

				if (parent[a] == parent[b]) // 부모가 같으면 계산안함
					continue;

				arr.add(new Pairs(v, new Pair(a, b))); 
        // 그래프 저장
			}

			Collections.sort(arr); // 정렬
      // 자세한 내용은 클래스 선언에서

			for (int i = 0; i < arr.size(); i++) { 
        // 최소 계산
				int a = find(arr.get(i).second.first);
				int b = find(arr.get(i).second.second);
				int v = arr.get(i).first;

				if (a == b) // a와 b가 같으면 계산 안함
					continue;

				union(a, b); // a와 b 합치기
				total += v; // 합쳐진 길이 더하기
			}

			System.out.println(sum - total);
      // 원래 길이 - 줄여진 길이
		}

		bw.flush();
		bw.close();
	}

	public static int find(int a) { // 부모 찾기
		if (parent[a] == a) 
      // 루트인 경우(부모가 자기 자신인 경우)
			return a; // 부모 반환
		else
			return parent[a] = find(parent[a]); 
    // 아니면 다시 부모를 찾기
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
    // 두 점의 부모를 찾기

		if (a == b) // 부모가 같다면
			return; // 합치지 않음

		parent[a] = b; // 합치고 부모를 새로 설정
	}

	public static class Pair implements Comparable<Pair> {
		int first; // 시작점
		int second; // 종료점

		Pair(int a, int b) {
			first = a;
			second = b;
		}

		@Override
		public int compareTo(Pair p) {
			if (this.first == p.first) { 
				return this.second - p.second; 
        // 시작점이 같으면 종료점을 기준으로 정렬
			} else // 시작점을 기준으로 정렬
				return this.first - p.first;
		}
	}

	public static class Pairs implements Comparable<Pairs> {
		int first; // 길이
		Pair second; // 좌표 페어

		Pairs(int a, Pair b) {
			first = a;
			second = b;
		}

		@Override
		public int compareTo(Pairs p) {
			if (this.first == p.first) { 
				return this.second.compareTo(p.second); 
        // 길이가 같다면 pair 클래스의 정렬을 호출(시작점 기준으로 정렬함)
			} else // 길이를 기준으로 정렬하기
				return this.first - p.first;
		}
	}

}
