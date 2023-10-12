import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ans = 99; // 평소에 0이나 -1로 초기화하는데
    // 둘 다 쓰는 값이라 적당한 값으로 초기화해줌
		
		String[] str = bf.readLine().split(" ");
		int x1 = Integer.parseInt(str[0]);
		int y1 = Integer.parseInt(str[1]);
    // 좌표 1

		str = bf.readLine().split(" ");
		int x2 = Integer.parseInt(str[0]);
		int y2 = Integer.parseInt(str[1]);
    // 좌표 2
    
		str = bf.readLine().split(" ");
		int x3 = Integer.parseInt(str[0]);
		int y3 = Integer.parseInt(str[1]);
    // 좌표 3

		int slope = (x2 - x1) * (y3 - y2) - (y2 - y1) * (x3 - x2);
    // 세 좌표의 외적 AB x AC
		
		if(slope > 0) { // 외적이 양수이면 반시계방샹
			bw.write("1" + "\n");
		} else if(slope < 0) { // 외적이 음수이면 시계방향
			bw.write("-1" + "\n");
		} else { // 외적이 0이면 일직선(평행)
			bw.write("0" + "\n");
		}
		
		bw.flush();
		bw.close();

	}

}
