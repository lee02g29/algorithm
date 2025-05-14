import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Books books = new Books();
        
        for(int i = 0; i < phone_book.length; i++) {
            books.insert(phone_book[i]);
        } // 문자열들을 node에 넣기
        
         for(int i = 0; i < phone_book.length; i++) {
            if(books.check(phone_book[i])) { 
              // 해당 문자열이 어떤 문자열의 접두사라면
                answer = false; 
                break;
            }
             
        }
        
        return answer;
    }
}

class Books {
    Node root = new Node(); // 전화번호부 노드
    
    void insert(String s) {
        Node node = this.root;
        // 루트 노트부터 시작
        
        for(int i = 0; i < s.length(); i++) {
            if(!node.childNode.containsKey(s.charAt(i))) {
              // 이번 노드가, 문자 s를 자식 노드로 가지고 있지 않다면,
                node.childNode.put(s.charAt(i), new Node());
              // 문자 s를 자식 노드로 넣기
            }
            node = node.childNode.get(s.charAt(i));
            // 다음 노드로 넘어가기
        }
        
        node.endWord = true;
        // 문자열 모두 탐색 후, 마지막 노드에 마지막 글자임을 표시
    }
    
    boolean check(String s) {
        Node node = this.root;
        // 루트 노트부터 시작
        
        for(int i = 0; i < s.length(); i++) {
            node = node.childNode.getOrDefault(s.charAt(i), null);
            // 현재 문자의 자식 노드가 있다면 이동, 없다면 null
            
            if(node == null) return false;
            // 자식 노드를 가지지 않았음 = 해당 문자가 없으므로 접두사 아님
        }
        
        if(node.childNode.isEmpty()) return false;
        // 모든 문자를 탐색했지만 자식 노드가 없음 → 자신이 단어의 끝
        // → 다른 단어의 접두사가 아님
        
        return true;
        // // 그 외에는 현재 단어가 다른 단어의 접두사임
    }
}

class Node {
  Map<Character, Node> childNode = new HashMap<>(); 
  // [문자 S와 자식 노드]를 구조로 가지는 해시맵
    
	boolean endWord; // 해당 문자가 마지막 문자인지 여부
}
