import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		while(sc.hasNext()) {
    			int num = sc.nextInt();
    			if(num != 0) {
	    			int len = (int)(Math.log10(num) + 1);
	    			int[] pal = new int[len];
	    			int check = 1;
	    			
	    			for(int i = 0; i < len; i++) {
	    				pal[i] = num % 10;
	    				num = num / 10;
	    			}
	    			
	    			for(int i = 0; i <= (int)len / 2; i++) {
	    				if(pal[i] != pal[len- 1 - i] ) {
	    					System.out.println("no");
	    					check = 0;
	    					break;
	    				}
	    			}
	    			
	    			if(check == 1) System.out.println("yes");
    			}
    		}
    }
    		
}
