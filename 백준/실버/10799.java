import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = bf.readLine();

        Stack<Character> stack = new Stack<>(); // 막대용 스택
        int cur = 0; // 현재 놓여있는 막대 수
        int cuts = 0; // 레이저에 의해 잘린 막대 수

        for(int i = 0; i < str.length(); i++) { // 막대 탐색
            char ch = str.charAt(i); // 현재 문자 확인

            if(ch == '(') { // 막대 시작이면
                stack.push(ch); // 막대 스택에 추가
                cur++; // 현재 수 증가
            } else if(ch == ')') { // 막대 끝이면
                cur--; // 현재 수 감소

                if(str.charAt(i - 1) == '(') { 
                  // 바로 이전 문자가 '('이면 레이저
                    cuts += cur; // 현재 수 만큼 막대가 잘려나감
                } else cuts += 1; // 레이저가 아니면 막대의 끝이므로 남은 조각 + 1
                
                stack.pop(); // 막대 제거
            }
        }

        bw.write(cuts + "\n");

        bw.flush();
        bw.close();
    }

}
