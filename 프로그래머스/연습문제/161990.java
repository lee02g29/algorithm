class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lux = wallpaper.length - 1;
        int luy = wallpaper[0].length() - 1;
        // 임의의 최대값. 문제 조건상 50이나 51이어도 문제 없음
      
        int rdx = 0;
        int rdy = 0;
        // 임의의 최소값. -1이어도 문제 없음
        
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++ ){
              if(wallpaper[i].charAt(j) == '.') {
                  continue;
              } // 빈 공간은 패스
                
                if(lux > i) lux = i;
                if(luy > j) luy = j;
                
                if(rdx < i) rdx = i;
                if(rdy < j) rdy = j;
                // 파일이라면, 가장 위쪽, 왼쪽, 아래쪽, 오른쪽 좌표를 찾기
                // lux luy Math.min, rdx rdy는 Math.Max를 사용하면 더 간략한 코드
            }

        }
        
        answer[0] = lux; 
        answer[1] = luy;
        answer[2] = rdx + 1;
        answer[3] = rdy + 1;
        // rdx와 rdy는 도착지점의 좌상단(배열)의 좌표를 저장했음
        // 그러나, 실제 도착지점은 우하단의 좌표가 필요하므로 + 1씩
        
        return answer;
    }
}
