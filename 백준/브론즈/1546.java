import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int n = sc.nextInt();
    		int[] score = new int[n];
    		int max = 0;
    		double avg = 0;
    		
    		for(int i = 0; i < n; i++) {
    			score[i] = sc.nextInt();
    			if(score[i] > max) max = score[i];
    		}
    		
    		for(int i = 0; i < n; i++) {
    			avg = avg + ((double)score[i] / max * 100);
    		}
    		
    		System.out.println(avg / n);
    }
}
