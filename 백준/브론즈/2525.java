import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int hour = sc.nextInt();
    		int minute = sc.nextInt();
    		
    		int time = sc.nextInt();

    		int t1 = time / 60;
    		int t2 = time % 60;
    		
    		minute = minute + t2;
    		hour = hour + t1;
    		
    		if(minute >= 60) {
    			minute = minute - 60;
    			hour++;
    		} 
    		
    		if(hour > 23) {
    			hour = hour % 24;
    		}
    		
    		System.out.println(hour + " " + minute);
    }
}
