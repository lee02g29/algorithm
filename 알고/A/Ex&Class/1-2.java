import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       Scanner sc = new Scanner(System.in);
       
       int n = sc.nextInt();
       
       if( n % 4 == 0 && n % 100 != 0 || n % 400 == 0 ) { // 윤년은 4의 배수이며 100의 배수는 아닐 것, 또는 400의 배수일 것.
         System.out.println("YES");
       } else {
         System.out.println("NO");
       }

    }
}
