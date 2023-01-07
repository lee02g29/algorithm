import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);

            String str = sc.nextLine();
            int[] count = new int[26];

            for(int i = 0; i < 26; i++) {
                count[i] = -1;
            }

            for(int s = 0; s < str.length(); s++) {
                int index = str.charAt(s) - 97;
                if(count[index] == -1){
                    count[index] = s;
                }
            }

            for(int i = 0; i < 26; i++) {
                System.out.print(count[i] +" ");
            }          
    }		
}
