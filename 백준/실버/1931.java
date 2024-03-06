import java.io.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(bf.readLine()); // 회의 개수
        int meeting = 0; // 최대 회의 개수
        int time = 0; // 현재 시간

        ArrayList<Pair> arr = new ArrayList<>(); // 시작시간, 종료시간 저장 리스트

        for(int i = 0; i < cnt; i++) {
            String[] str = bf.readLine().split(" ");

            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            arr.add(new Pair(x, y));
        } // 회의 정보 저장
        
        Collections.sort(arr);
        // 회의 정렬 - 종료 시간을 기준으로

        for(int i = 0; i < cnt; i++) {
            Pair p = arr.get(i);

            if(time <= p.x) {
                time = p.y;
                meeting++;
            } // 현재 시간보다 회의의 시작 시간이 더 늦다면
          // 회의를 진행
          // 먼저 나오는 것이 시작 시간이 가장 빠르므로, 따로 처리 필요 x
        }

        bw.write(meeting + "\n"); // 출력

        bw.flush();
        bw.close();
    }

    static class Pair implements Comparable<Pair> {
      // 회의 정보 클래스
        int x; // 시작 시간
        int y; // 종료 시간

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p1) {
            if(this.y == p1.y) { // 종료 시간이 같다면
                return this.x - p1.x; // 시작 시간이 이른 순서대로
            } else { // 그 외에는 종료 시간을 기준으로 정렬
                return this.y - p1.y;
            }
        }
    }
}
