import java.util.*;

class Solution {
  int[] dun;
  boolean[] checked;
  int len;
  int answer;

  public int solution(int k, int[][] dungeons) {
    answer = -1;
    len = dungeons.length;
    dun = new int[len];
    checked = new boolean[len];

    permutation(0, k, dungeons);
    // 순열. 0번째부터 시작

    return answer;
  }

  public void permutation(int cnt, int energy, int[][] dungeons) {
    if (cnt == len) {
      answer = Math.max(answer, count(energy, dungeons));
      return;
    } // 길이까지 순서를 정했다면, 개수를 세서 큰 값을 채택

    for (int i = 0; i < len; i++) {
      if (checked[i] == true) {
        continue;
      } // 사용중인 

      dun[cnt] = i;
      checked[i] = true;
      // 사용
      
      permutation(cnt + 1, energy, dungeons);
      // 다음 위치
      
      checked[i] = false;
      // 사용 반납
    }
  }

  public int count(int energy, int[][] dungeons) {
    // 에너지 소모 체크 함수
    int cnt = 0;
    int total = energy;

    for (int i = 0; i < len; i++) {
      int cur = dun[i]; // 이번 방문 던전
      int need = dungeons[cur][0]; // 필요 피로도
      int use = dungeons[cur][1]; // 소모 피로도

      if (total < need) // 현재 피로도가 필요 피로도보다 적으면
        break; // 그만 돌기
      total -= use; // 피로도 소모
      cnt++; // 개수 증가
    }

    return cnt; // 탐사한 던전수 반환
  }
}
