class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                answer += ch;
                isFirst = true; 
            } else {
                if (isFirst) { // 첫문자
                    answer += Character.toUpperCase(ch); 
                    // 소문자로 변환. 공백, 숫자는 그대로 반환됨
                } else { // 첫문자가 아님
                    answer += Character.toLowerCase(ch);
                   // 대문자료 변환. 마찬가지로 공백, 숫자는 그대로 반환됨
                }
                isFirst = false; 
            }
        }

        return answer;
    }
}
