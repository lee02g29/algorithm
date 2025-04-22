class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        for(int i = 0; i < new_id.length(); i++) {
            answer += Character.toLowerCase(new_id.charAt(i));
        } // 모두 소문자로
        
        answer = answer.replaceAll("[^a-z0-9-_.]",""); 
        // 조건을 제외한 문자 제거
        
        answer = answer.replaceAll("\\.{2,}",".");
        // .이 2개 이상이면 하나로
        
        answer = answer.replaceFirst("^\\.", ""); 
        // .으로 시작하면 .을 제거
        answer = answer.replaceFirst("\\.$", "");
        // .으로 끝나면 . 제거
        // 처음 만나는 것만 제거 나머지는 원래대로
        
        if(answer.length() == 0) answer = "a";
        // 남은 문자가 없으면 a
        
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceFirst("\\.$", "");
        } // 16자 이상이면 자르기, .으로 끝나면 제거하기
        
        if(answer.length() <= 2) { // 2글자 이하이면 3자까지 
            char temp = answer.charAt(answer.length() - 1);

            while(answer.length() < 3) { // 3자까지 마지막문자 더하기
                answer += temp;
            }
        }
                   
        return answer;
    }
}
