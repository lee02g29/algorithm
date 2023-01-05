import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		String str = sc.nextLine();
            int[] fre = new int[26];
            int max = 0;
            int count = 0;
            int index = 1;


            str = str.toUpperCase();

            for(int i = 0; i < str.length(); i++) {
                int n = str.charAt(i) - 65;
                fre[n]++;
            }

            for(int i = 0; i < 26; i++) {
                if(max < fre[i]) {
                    max = fre[i];
                    index = i;
                    count = 1;
                }
                else if(max == fre[i]) count++;
            }

            if(count>= 2) System.out.println("?");
            else System.out.println((char)(index + 65));
        }
    		
}
