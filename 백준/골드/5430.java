import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(bf.readLine());

        while (test-- > 0) {
            boolean isPossible = true; // 가능한지 여부
            boolean isOrder = true; // 원래 순서대로인지 여부

            String[] str = bf.readLine().split(""); // 함수 순서

            int size = Integer.parseInt(bf.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            // 숫자 배열

            int first = 0;
            int last = size;
            // 포인터

            String temps = bf.readLine().replace("[", "").replace("]", "");
            temps = temps.replace(",", " ");
            // 배열 괄호를 지우고, 컴마를 띄어쓰기로 변경

            String[] nums = temps.split(" ");

            if(size == 0) {
                if (str[0].equals("D")) {
                    isPossible = false;
                }
            } // 배열 사이즈가 0인데 지우려고 할 때는 불가능함

            for (int i = 0; i < size; i++) {
                arr.add(Integer.parseInt(nums[i]));
            } // 숫자 배열에 넣기

            for (int i = 0; i < str.length; i++) {
                if (str[i].equals("R")) {
                    isOrder = !isOrder;
                } // R함수를 호출할 때, isOrder를 반대로 변경

                else if (str[i].equals("D")) {
                    if (first >= last) { 
                      // 연산 진행 중, 배열의 크기가 0이 될 때 삭제를 시도할 때
                        isPossible = false;
                        break;
                      // 불가능하므로 바로 진행을 종료
                    } else {
                        if(isOrder) // 정 방향일 때
                        {
                            first++;
                        } // 역방향일 때
                        else { 
                            last--;
                        }
                    }
                }
            }

            if (isPossible) { // 가능할 때
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                if(isOrder) { // 정방향일 때 출력
                    for (int i = first; i < last; i++) {
                        if (i == last - 1) {
                            sb.append(arr.get(i) + "");
                        } else
                            sb.append(arr.get(i) + ",");
                    }
                } else { // 역방향일 때 출력
                    for (int i = last - 1; i >= first; i--) {
                        if (i == first) {
                            sb.append(arr.get(i) + "");
                        } else
                            sb.append(arr.get(i) + ",");
                    }
                }
                sb.append("]");
                bw.write(sb + "\n");
            } else { // 불가능할 때
                bw.write("error" + "\n");
            }

        }

        bw.flush();
        bw.close();
    }
}
