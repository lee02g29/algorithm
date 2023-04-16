import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       Scanner sc = new Scanner(System.in);
       
       int n = sc.nextInt();
       
       if(n % 8 == 0) { // 글자수를 8으로 나누었을 때, 나머지가 없는 경우
         System.out.println(2); // 2번째 손가락에서 멈춤 -> 검지
       } else if(n % 8 == 7) { // 글자수를 8으로 나누었을 때, 나머지가 7인 경우 
         System.out.println(3); // 3번째 손가락에서 멈춤 -> 중지
       } else if(n % 8 == 6) { // 글자수를 8으로 나누었을 때, 나머지가 6인 경우 
         System.out.println(4); // 4번째 손가락에서 멈춤 -> 약지
       } else { // 그 외에는 나머지만큼의 숫자에서 멈춘다.
         System.out.println(n % 8);
       }

    }
}
