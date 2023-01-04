import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int test_case = sc.nextInt();

            for(int t = 0; t < test_case; t++) {
                int people = sc.nextInt();
                int[] board = new int[people];
                int avg = 0;
                int up = 0;

                for(int i = 0 ; i < people; i++) {
                    int score = sc.nextInt();
                    board[i] = score;
                    avg = avg + score;
                }
                avg = (int)Math.ceil(avg / people);

                for(int i = 0; i < people; i++) {
                    if(board[i] > avg) {
                        up++;
                    }
                }
                double temp = ((double) up / people) * 100;
                String result = String.format("%.3f", temp);
                System.out.println(result + "%");

            }
        }
    		
}
