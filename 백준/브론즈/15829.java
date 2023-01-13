import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);    
            long ans = 0;
            long pow = 1;

            int l = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();

            for(int s = 0; s < str.length(); s++) {
                int ch = str.charAt(s) - 96;
                ans = (ans + (ch % 1234567891) * (pow % 1234567891)) % 1234567891;
                pow = pow * 31 % 1234567891;

            }     

            System.out.println(ans % 1234567891);
            
        }
}
