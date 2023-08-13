import java.util.*;
import java.io.*;

class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static String[] next = {">", "v", "<", "^"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt( bf.readLine() );
		
		for(int t = 1; t <= test; t++) {
			String[] str = bf.readLine().split(" ");
			
			int h = Integer.parseInt( str[0] );
			int w = Integer.parseInt( str[1] );
			
			String[][] board = new String[h][w];
			int x = 0;
			int y = 0;
			int dir = 0;
			int idx = 0;
			
			for(int i = 0; i < h; i++) {
				str = bf.readLine().split("");
				
				for(int j = 0; j < w; j++) {
					board[i][j] = str[j];
					if( str[j].equals(">") || str[j].equals("v") || 
							str[j].equals("<") || str[j].equals("^")) {
						x = i;
						y = j;
						
						if( board[x][y].equals(">") ) dir = 0;
						else if( board[x][y].equals("v") ) dir = 1;
						else if( board[x][y].equals("<") ) dir = 2;
						else if( board[x][y].equals("^") ) dir = 3;
						
					}
				}
			}

			int len = Integer.parseInt( bf.readLine() );
			String input = bf.readLine();
			
			
			for(int s = 0; s < len; s++) {

				if(input.charAt(s) == 'U') {
					dir = 3;
					board[x][y] = "^";
					
					if(x > 0 && board[x-1][y].equals(".")) {
						board[x-1][y] = board[x][y];
						board[x][y] = ".";
						x -= 1;
					}
				}
				
				else if(input.charAt(s) == 'D') {
					dir = 1;
					board[x][y] = "v";
					
					if(x < h - 1 && board[x+1][y].equals(".")) {
						board[x+1][y] = board[x][y];
						board[x][y] = ".";
						x += 1;
					}
				}
				
				else if(input.charAt(s) == 'L') {
					dir = 2;
					board[x][y] = "<";
					
					if(y > 0 && board[x][y-1].equals(".")) {
						board[x][y-1] = board[x][y];
						board[x][y] = ".";
						y -= 1;
					}
				} 
				
				else if(input.charAt(s) == 'R') {
					dir = 0;
					board[x][y] = ">";
					
					if(y < w - 1 && board[x][y+1].equals(".")) {
						board[x][y+1] = board[x][y];
						board[x][y] = ".";
						y += 1;
					}
				} 
				
				else if(input.charAt(s) == 'S') {
					if(dir == 0) {
						idx = y;
						while(true) {
							if(idx + 1 >= w || board[x][idx + 1].equals("#")) break;
							if(board[x][idx + 1].equals("*")) {
								board[x][idx + 1] = ".";
								break;
							}
							idx++;
						}
											
					}
					
					else if(dir == 1) {
						idx = x;
						while(true) {
							if(idx + 1 >= h || board[idx + 1][y].equals("#")) break;
							if(board[idx + 1][y].equals("*")) {
								board[idx + 1][y] = ".";
								break;
							}
							idx++;
						}
						
					}
					
					else if(dir == 2) {
						idx = y;
						while(true) {
							if(idx - 1 < 0 || board[x][idx-1].equals("#")) break;
							if(board[x][idx-1].equals("*")) {
								board[x][idx-1] = ".";
								break;
							}
							idx--;
						}
						
						
					} else if(dir == 3) {
						idx = x;
						while(true) {
							if(idx - 1 < 0 || board[idx -1][y].equals("#")) break;
							if(board[idx - 1][y].equals("*")) {
								board[idx - 1][y] = ".";
								break;
							}
							idx--;
						}
												
					}
				} 
			}
			
			bw.write("#" + t + " ");
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					bw.write(board[i][j]);
				}
				bw.write("\n");
			}
			
		}
		
		bw.flush();
		bw.close();
	}

}
