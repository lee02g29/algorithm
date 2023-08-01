import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Solution
{	

	public static void main(String args[]) throws Exception
	{
        
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		ArrayList<Integer> land = new ArrayList<>();
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
				int dump = Integer.parseInt( bf.readLine() ); // 덤프 횟수
				String[] str = bf.readLine().split(" ");
				
				land = new ArrayList<>();
				
				for(int j = 0; j < str.length; j++) {
					land.add(Integer.parseInt( str[j]) );
				}
				
				Collections.sort(land, Collections.reverseOrder()); // 내림차순 정렬
				
				for(int j = 0; j < dump; j++) { // 덤프시작
					int max = land.get(0);
					int min = land.get(99);
          // 최대값과 최소값
					
					land.remove(99);
					land.remove(0);
          // 리스트에서 제거하기
					
					land.add(max - 1);
					land.add(min + 1);
          // 최대값 -1, 최소값 + 1해서 리스트에 넣기
					
					Collections.sort(land, Collections.reverseOrder());
          // 다시 정렬하기
				}
	
				bw.write("#" + test_case +  " " + (land.get(0) - land.get(99)) + "\n"); 
      // 차이 출력하기
		}
	
		bw.flush();
		bw.close();
        
	}
}
