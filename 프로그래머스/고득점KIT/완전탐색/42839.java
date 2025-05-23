import java.util.*;

class Solution {
  ArrayList<Integer> visit = new ArrayList<>();
  // 완성된 숫자 판별 여부 체크
  boolean[] checked; // n번째 숫자 사용여부 체크
  char[] nums; // 숫자 분리
  int answer;
  int number_cnt; // 순열을 통해 만들어진 새로운 숫자

  public int solution(String numbers) {
    answer = 0;
    nums = new char[numbers.length()];
    checked = new boolean[numbers.length()];
    number_cnt = numbers.length();

    for (int i = 1; i <= numbers.length(); i++) {
      // 각 길이마다 수열 새로 시작
      permutation(0, i, numbers);
    }

    return answer;
  }

  public void permutation(int cnt, int len, String numbers) {
    if (cnt == len) { // 현재 만든 숫자의 길이기 len이라면
      String new_num = "";
      for (int i = 0; i < len; i++) {
        new_num += nums[i];
      } // 배열에 있는 숫자 꺼내서 배열 만듬

      if (isPrime(Integer.parseInt(new_num))) {
        answer++;
      } // 만든 수가 소수면 +1

      return; // 이면 순열 끝
    }

    for (int i = 0; i < number_cnt; i++) { // 모든 숫자를 탐색
      if (checked[i] == true)
        continue; // 현재 숫자 사용중

      nums[cnt] = numbers.charAt(i);
      // 이번 숫자를 사용
      checked[i] = true; // 사용 여부 체크
      permutation(cnt + 1, len, numbers);
      // 다음 숫자 찾으러
      checked[i] = false;
      // 숫자 사용 끝
    }
  }

  public boolean isPrime(int num) {

    if (visit.contains(num))
      return false; // 이미 판별한 적 있으면 x
    if (num == 0 || num == 1)
      return false; // 0과 1 판별
    if (num == 2) { // 2 판별
      visit.add(num); // 판별한 숫자 추가
      return true;
    }

    visit.add(num); // 이번 숫자를 판별 리스트에 넣음
    for (int i = 2; i * i <= num; i++) { // 소수 판별
      if (num % i == 0)
        return false;
    }

    return true;
  }
}
