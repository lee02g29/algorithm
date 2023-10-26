import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int q = Integer.parseInt(str[1]);
    // n개의 숫자, q턴
		
		long[] nums = new long[n + 1];
    // 2^31이라서 int도 되긴 할 것
		
		str = bf.readLine().split(" ");
		
		for(int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(str[i - 1]);
		} // 초기값
		
		SegmentTree tree = new SegmentTree(n);
		tree.init(nums, 1, 1, n);
    // 세그먼트 트리 초기화
		
		for(int i = 0; i < q; i++) {
			str = bf.readLine().split(" ");
			
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
      // x~y 또는 y~x까지
			
			long sums = 0L;
			
			if(x <= y) {
				sums = tree.sum(1, 1, n, x, y);
			}
			else sums = tree.sum(1, 1, n, y, x);
      // x가 더 크면 y~x까지
      // 아니면 x~y까지의 합
			
			int a = Integer.parseInt(str[2]);
			int b = Integer.parseInt(str[3]);
      // a위치의 값을 b로

			tree.update(1, 1, n, a, b - nums[a]);
			nums[a] = b;
      // a위치의 값을 b로

			bw.write(sums + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static class SegmentTree {
		long[] tree;
		int treeSize;
    // 세그먼트 트리와 트리 사이즈
    
		SegmentTree(int arrSize) {
			int h = (int)Math.ceil(Math.log(arrSize) / Math.log(2));
      // 트리 높이 = log2(n)
      // 자바에서 log는 자연로그이므로, 이런 방식으로 구현함
      // 정확히 정수가 아닐 경우 + 1을 해주어야 해서 ceil 사용
			
			this.treeSize = (int)Math.pow(2, h + 1);
			tree = new long[treeSize];
      // 트리 노드 개수 = 2 ^ (h + 1)
		}
		
		public long init(long[] nums, int node, int start, int end) {
			if(start == end) { // start = end이면 리프노드임
				return tree[node] = nums[start];
        // 리프노트는 원래 값을 가짐
			}
			
			return tree[node] = 
					init(nums, node * 2, start, (start + end) / 2) +
					init(nums, node * 2 + 1, (start + end) / 2 + 1, end);
      // 그 외에는 왼쪽 노드와 오른쪽 노드의 합
		}
		
		public void update(int node, int start, int end, int index, long gap) {
			if(index < start || index > end) return;
      // 범위 바깥 x
			
			tree[node] += gap;
      // 그 외에는 원래값과 바꾸려는 값의 차이만큼 합
			
			if(start != end) {
				update(node * 2, start, (start + end) / 2, index, gap);
				update(node * 2 + 1, (start + end) / 2 + 1, end, index, gap);
        // 리프 노트가 아니면 오른쪽 노드와 왼쪽 노드를 갱신
			}
		}
		
		public long sum(int node, int start, int end, int left, int right) {
			if(left > end || right < start) {
				return 0;
			} // 범위 바깥은 0
			
			if(left <= start && end <= right) {
				return tree[node];
			} // 범위 내에 있다면 트리가 가진 값 반환
			
			return sum(node * 2, start, (start + end) / 2, left, right) + 
					sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		} // 그 외에는 왼쪽 노드와 오른쪽 노드 값 합해서 반환
		
	}

}
