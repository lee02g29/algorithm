import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) { 
			int len = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			
			ArrayList<Integer> stack = new ArrayList<>(); 
			boolean check = true; 
			
			for (int i = 0; i < len; i++) { // 문자 탐색
				if (str.charAt(i) == '(') { // 여는 '('의 경우
					stack.add(1); // 1 넣기, 임의의 숫자
				} else if (str.charAt(i) == ')') { // 닫는 ')'의 경우
					if (stack.size() == 0) { // 스택이 비었음 = 여는 괄호 없이 왔음
						check = false;
						break;
					}

					if (stack.get(stack.size() - 1) != 1) { 
            // 스택 맨 위를 봤을 때, 같은 종류가 아니면 올바르지 않음
            // () 괄호 사이에 남는 괄호가 있었다는 뜻
						check = false;
						break;
					} else { // 같은 종류면
						stack.remove(stack.size() - 1); // 스택에서 제거하기
					}
				}

        // 위와 괄호 종류만 다르고 방법은 같음
				if (str.charAt(i) == '[') { 
					stack.add(2);
				} else if (str.charAt(i) == ']') { 
					if (stack.size() == 0) {
						check = false;
						break;
					} 

					if (stack.get(stack.size() - 1) != 2) { 
						check = false;
						break;
					} else { 
						stack.remove(stack.size() - 1); 
					}
				}
				
				if (str.charAt(i) == '{') { 
					stack.add(3);
				} else if (str.charAt(i) == '}') { 
					if (stack.size() == 0) {
						check = false;
						break;
					} 

					if (stack.get(stack.size() - 1) != 3) { 
						check = false;
						break;
					} else { 
						stack.remove(stack.size() - 1); 
					}
				}
				
				if (str.charAt(i) == '<') { 
					stack.add(4);
				} else if (str.charAt(i) == '>') { 
					if (stack.size() == 0) {
						check = false;
						break;
					} 

					if (stack.get(stack.size() - 1) != 4) { 
						check = false;
						break;
					} else { 
						stack.remove(stack.size() - 1); 
					}
				}

			}
			
			if(!check) bw.write("#" + t + " 0" + "\n"); // 올바르지 않은 괄호
			else if (check && stack.size() != 0) 
        // 위에서 확인되지는 않았음 + 그렇지만 스택에 남았음 = 여는 괄호들이 남았음
        // 올바르지 않음
				bw.write("#" + t + " 0" + "\n"); 
			else if (check) // 모두 해당하지 않음 = 올바름
				bw.write("#" + t + " 1" + "\n"); 

		}
		bw.flush();
		bw.close();
	}

}
