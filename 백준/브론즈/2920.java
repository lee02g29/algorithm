import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int prev = n;
            int check = 1;
            
            if(n != 1 && n != 8) {
                System.out.println("mixed");
            } else {
                if(n == 8) {
                    for(int s = 7; s >= 1; s--) {
                        int num = sc.nextInt();
                        if(prev - 1 != num) {
                            System.out.println("mixed");
                            check = 0;
                            break;
                        } else prev = num;
                    }
                    if(check == 1) {
                        System.out.println("descending");
                    }
                    
                } else if(n == 1) {
                    for(int s = 2; s <= 8; s++) {
                        int num = sc.nextInt();
                        if(prev + 1 != num) {
                            System.out.println("mixed");
                            check = 0;
                            break;
                        } else prev = num;
                    }
                    if(check == 1) {
                        System.out.println("ascending");
                    }
                }
            }    
        }   
}
