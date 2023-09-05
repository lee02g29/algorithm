import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int t = 0; t < n; t++) {
			int add = Integer.parseInt(bf.readLine());
			String[] list = new String[add];
			telBooks books = new telBooks(); // trie 전화번호부
			boolean check = false; // 일관성이 없는가?
			
			for(int i = 0; i < add; i++) {
				String str = bf.readLine();
				books.insert(str); // 전화번호 입력
				list[i] = str;
			}
			
			for(String s : list) { // 전화번호 탐색
				if(books.check(s)) { // 해당 전화번호부는 일관성이 없는가?
					check = true; // 없다고 판명되면 체크
					break; // 확인되면 그만봐도 ok
				}
			}
			
			if(!check) bw.write("YES\n");
			else bw.write("NO\n");
		}

		
		bw.flush();
		bw.close();

	}
	
	public static class telBooks {
		Node root = new Node();
		
		void insert(String str) { // 전화번호 추가하기
			Node node = this.root; // 루트노드부터 시작하기
			
			for(int i = 0; i < str.length(); i++) {
				node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
        // 해당 문자가 없다면 추가하기
			}
			
			node.endWord = true; // 마지막 문자에 체크하기
		}
		
		boolean check(String str) { // 일관성 여부 체크
			Node node = this.root;
			for(int i = 0; i < str.length(); i++) {
				node = node.childNode.getOrDefault(str.charAt(i), null);
        // 문자가 존재하지 않으면 null, 있으면 다음 노드
				
				if(node == null) return false; 
			}
			
			if(node.childNode.isEmpty()) return false;
      // 마지막 노드의 자식노드가 없음 = 이번 문자열임 = 체크 안함
			
			return true; 
      // 자식 노드가 있음 = 이번 문자열을 접두어로 하는 전화번호가 있음 = 일관성이 없음
		}
		
	}
	
	static class Node {
		Map<Character, Node> childNode = new HashMap<>(); // 맵. 이번 문자와 다음 노드
		boolean endWord; // 이게 마지막 문자인가?
	}
}
