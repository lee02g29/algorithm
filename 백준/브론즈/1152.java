import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		String[] str = sc.nextLine().strip().split(" ");
    		if(str[0].isEmpty()) System.out.println(str.length -1);
    		else System.out.println(str.length);   				
    }
}
