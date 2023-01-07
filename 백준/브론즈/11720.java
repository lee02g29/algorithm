import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);

            int len = sc.nextInt();
            sc.nextLine();
            String[] number = sc.nextLine().split("");
            
            int sum = 0;

            for(int i = 0; i < len; i++) {
                sum = sum + Integer.parseInt( number[i] );
            }

            System.out.println(sum);
    }		
    
}
