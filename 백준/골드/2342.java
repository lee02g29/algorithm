import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		
		int move = str.length; // 입력받은 개수
		
		int[] nums = new int[move];
		int[][][] ddr = new int[move][5][5]; 
    // ddr, dp용 배열 ddr[움직이는 횟수][왼발][오른발]
		int min = Integer.MAX_VALUE;
    // 최소 힘
    
		for(int i = 0; i < move; i++) {
		    for(int j = 0; j < 5; j++) {
		        for(int k = 0; k < 5; k++) {
		            ddr[i][j][k] = 100000000;
		        }
		    }
		} // 적당히 큰 수로 초기화
		
		for(int i = 0; i < move; i++) {
			nums[i] = Integer.parseInt(str[i]);
		} // 밟는 순서 입력받기

		ddr[0][0][0] = 0; // 초기항, 처음에는 0 0번째에 두 다리가 있다
		for(int n = 0; n < move - 1; n++) { // 이번에는 몇번째?
		    int next = nums[n]; // 이번에 밟는 숫자
		    for(int i = 0; i < 5; i++) { // 0~4칸에 왼발
			    for(int j = 0; j < 5; j++) { // 0~4칸에 오른발
			        
				    ddr[n + 1][i][next] = Math.min(ddr[n + 1][i][next], ddr[n][i][j] + move(j, next));
            //  다음 위치, 오른발 에너지 = 기존에 움직여 본 에너지, 현재 위치 + 움직일 때 에너지(오른쪽 다리를 움직임) 중 최소값
            // j 위치에서 -> next 위치로 이동
				    // System.out.println(ddr[n][i][next] + " " + ddr[n + 1][i][next] + " " + (ddr[n][i][j] + move(j, next)));
				     
				    ddr[n + 1][next][j] = Math.min(ddr[n + 1][next][j], ddr[n][i][j] + move(i, next));
            // 다음 위치, 왼발 에너지 = 기존에 움직여 본 에너지, 현재 위치 + 움직일 때 에너지(왼쪽 다리를 움직임)  중 최소값
            // i 위치에서 -> next 위치로 이동
				    // System.out.println(ddr[n][next][j] + " " + ddr[n + 1][next][j] + " " + (ddr[n][i][j] + move(i, next)));
			    }
		    }
		}
	    
	  for(int i = 0; i < 5; i++) {
		  for(int j = 0; j < 5; j++) {
          min = Math.min(min, ddr[move - 1][i][j]);
          // 마지막 움직임 중 에너지를 최소로 쓰는 경우 찾기
		  }
	  }
	    
	  bw.write(min + "\n");
		
		bw.flush();
		bw.close();
	}
	
		
	public static int move(int x, int y) { // 소모 에너지
    // 시작지점 x, 종료지점 y
		if(x == 0) return 2; // 0에서 움직일 경우
		if(Math.abs(x - y) == 2) return 4;
    // 반대방향으로 움직인다
		if(x == y) return 1;
    // 같은 방향을 누른다
		else return 3;
    // 그 외 = 인접한 경우
	}
}
