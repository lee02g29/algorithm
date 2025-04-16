class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true; // 첫 문자인가?

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // 이번 문자 추출

            if (ch == ' ') { // 공백 처리
                answer += ch;
                isFirst = true; // 첫 문자 처리를 위해 true
            } else {
                if (isFirst && ch >= 'a' && ch <= 'z') { // 첫문자이고 소문자
                    answer += (char)(ch - 32); // 소문자 -> 대문자
                } else if (!isFirst && ch >= 'A' && ch <= 'Z') { // 첫문자가 아니고 대문자
                    answer += (char)(ch + 32); // 대문자 -> 소문자
                } else {
                    answer += ch; // 그 외엔 그대로
                }
                isFirst = false; // 변환을 했다면 이 이후는 첫문자가 아님
            }
        }
        
        return answer;
    }
}
