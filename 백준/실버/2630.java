import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr; // 종이
    static int white; // 흰 종이 개수
    static int blue; // 파란 종이 개수

    public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine()); // 종이 사이즈

        arr = new int[n][n];
        white = 0;
        blue = 0;
        // 초기 세팅

        for(int i = 0; i < n; i++) {
            String[] str = bf.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        } // 종이 색

        divided(0, 0, n);
        // 색칠 시작
        
        bw.write(white + "\n" + blue + "\n");
        // 출력

        bw.flush();
        bw.close();
    }


  // 종이 자르기
    public static void divided(int x, int y, int size) {

        if(check(x, y, size)) { 
          // 해당 사이즈의 종이가 모두 같은 색이면
            if(arr[x][y] == 0) { // 흰색으로 같으면
                white++; // 흰색 개수 추가
            }
            else if(arr[x][y] == 1) { // 파란색으로 같으면
                blue++; // 파란색 개수 추가
            }

            return;
          // 색이 다 같으면 더 진행할 필요가 없음
        } 

        divided(x, y, size / 2);
        divided(x, y + (size / 2), size / 2);
        divided(x + (size / 2), y, size / 2);
        divided(x + (size / 2), y + (size / 2), size / 2);
      // 0 1
      // 2 3 
      // 0 1 2 3 순으로 분할하여 재귀로 진행

    }

    public static boolean check(int x, int y, int size) {
      // 모두 같은 색인지 체크
        int point = arr[x][y];
      // 기준점의 종이의 색

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(point != arr[i][j]) {
                    return false;
                } // 한 번이라도 다른 색이 나오면 x
            }
        }

        return true;
      // 위에서 반환되지 않았다면 같은색
    }

}
