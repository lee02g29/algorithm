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

        String[] str = bf.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int ans = 0;

        if(n < 3) { // 세로가 좁음
            if(n == 1) ans = 1; // 세로가 1칸이면 출발지만 갈 수 있음
            else ans = Math.min(4, (m - 1) / 2 + 1); 
            // 세로가 2칸이라면 -> 위 아래 2칸 이동은 안됨 -> 오른쪽으로 2칸 이동만 가능
            // 따라서 출발지점을 제외하고 이동가능한 칸수를 카운트
        } else { // 세로가 충분히 넓음
            if(m < 7){ // 그렇지만 가로가 좁음
                ans = Math.min(4, m); 
                // 문제 조건상 4회를 모두 쓸 수 없는 크기기에 이동 횟수는 3회로 제한
                // 따라서 최대 칸 수는 출발지 1칸 + 이동한 3칸
                // 그러나 크기에 따라서, 4칸까지 갈 수 없는 경우가 있기 때문에
                // m의 크기와 최대 칸 수 4칸을 비교하여 적은 쪽을 채택
            }
            else {
                ans = (m - 6) + 4;
                // 가로도 길고, 세로도 길다면
                // 일단 모든 방식으로 이동
                // 그 외에는 1칸씩 오른쪽으로 이동한다면 그것이 최대
                // 1칸씩 이동한 횟수 + 모든 방식을 한 번씩 이동한 4회를 더하기
            }
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }

}
