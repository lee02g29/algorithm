import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

class Main  {
    public static void main(String[] args) throws IOException{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt( bf.readLine() );
    	int[] count = new int[n];
    	int[] temp = new int[n]; // 임시 배열
    	
    	for(int i = 0; i < n; i++) {
    		int num = Integer.parseInt( bf.readLine() );
    		count[i] = num;
    	}
    	
    	mergeSort(count, temp, 0, count.length - 1);
    	
    	for(int i = 0; i < n; i++) {
    		bw.write(count[i] + "\n");
    	}

    	bw.flush();
    	bw.close();
    }   
    
    public static void mergeSort(int[] array, int[] temp, int left, int right) {
    	if( left < right ) {
    		int m = left + ( right - left ) / 2; // 두 부분으로 나누기
    		mergeSort(array, temp, left, m); // 좌측 배열
    		mergeSort(array, temp, m + 1, right); // 우측 배열
    		merge(array, temp, left, m, right); // 병합하기
    	} 	
    }
    
    public static void merge(int[] array, int[] temp, int left, int mid, int right) {
    	for(int i = left; i <= right; i++) {
    		temp[i] = array[i]; // 임시배열으로 값 복사
    	}
    	
    	int partLeft = left; // 왼쪽 부분
    	int partRight = mid + 1; // 오른쪽 부분
    	int index = left; // 인덱스
    	
    	while( partLeft <= mid && partRight <= right ) {
    		// 왼쪽 부분이 중간을 넘어서지 않고, 오른쪽 부분이 끝부분을 넘어가지 않는 한도내에서 반복
    		if( temp[partLeft] <= temp[partRight] ) { 
    			// 왼쪽 부분이 오른쪽 부분보다 작다면
    			array[index] = temp[partLeft]; // 왼쪽 값을 먼저 저장
    			partLeft++; // 다음 왼쪽 부분을 탐색하기 위하여 값 증가
    		} else { // 오른쪽 부분이 더 작다면 
    			array[index] = temp[partRight]; // 오른쪽 부분을 먼저 저장
    			partRight++; // 다음 오른쪽 부분을 탐색하기 위하여 값 증가
    		}
    		index++; // 인덱스 값 증가
    	}

    	
    	for(int i = 0; i <= mid - partLeft; i++) {
    		array[index + i] = temp[partLeft + i];
    	}
    	// 왼쪽의 남은 부분만 저장하기
    	// 이유 - 오른쪽 부분이 이미 다 들어갔고 왼쪽만 남았으면,왼쪽 남은 부분을 저장하면 된다
    	// 반대로 왼쪽 부분이 다 들어갔고 오른쪽 부분만 남았다면, 이미 정렬이 된 것이다.
    }
}
