import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int x = sc.nextInt();
    		int y = sc.nextInt();
    		int z = sc.nextInt();
    		int max = 0; // 나온 숫자 중 최대값
    		int temp = x; // 같은 수가 나왔을 경우, 그 수
    		int dice = 1; // 같은 수가 나온 주사위의 개수
    		int[] count = new int[7]; // 0은 쓰지 않음
    		
    		count[x]++;
    		count[y]++;
    		count[z]++;
    		
    		for(int i = 1; i <= 6 ; i++) {
    			if(count[i] >= 1) {
    				if(i > max) max = i;
    				if(count[i] >= 2) {
    					dice = count[i];
    					temp = i;
    				}
    			}
    		}
    		
    		if(dice == 3) System.out.println(10000 + (temp * 1000));
    		if(dice == 2) System.out.println(1000 + (temp * 100));
    		if(dice == 1) System.out.println(max * 100);   		
    }
}
