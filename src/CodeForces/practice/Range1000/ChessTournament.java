package CodeForces.practice.Range1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 12/09/2021, Sunday, 23:59
 */
public class ChessTournament {
	private static Scanner fs = new Scanner(System.in);

	private static class Player{
		Player mappedWith;
		Integer index;

		Player(Integer index,Player mappedWith){
			this.mappedWith = mappedWith;
			this.index = index;
		}
	}

	private static void solve(){
		int length = fs.nextInt();
		char[] str = fs.next().toCharArray();
		List<Player> players = new ArrayList<>();
		Map<Integer, Player> playerMap = new HashMap<>();

		for(int i=0;i<length;i++){
			if(str[i] == '2'){
				Player player = new Player(i,null);
				playerMap.put(i,player);
				players.add(player);
			}
		}



		for(int i=0;i<players.size();i++){
			Player ithPlayer = players.get(i);
			for(int j=0;j<players.size();j++){
				if(i == j) continue;
				Player jthPlayer = players.get(j);
				if(jthPlayer.mappedWith == null || !jthPlayer.mappedWith.index.equals(ithPlayer.index)){
					ithPlayer.mappedWith = jthPlayer;
					break;
				}
			}
		}

		for(int i=0;i<players.size();i++){
			Player player = players.get(i);
			if(player.mappedWith == null){
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
		char[][] matrix = new char[length][length];
		for (char[] row: matrix)
			Arrays.fill(row, '0');
		for(int i=0;i<length;i++){
			if(str[i] == '1'){
				for(int j=0;j<length;j++){
					if(matrix[i][j] == '0'){
						if(i == j){
							matrix[i][j] = 'X';
						}else{
							matrix[i][j] = '=';
							matrix[j][i] = '=';
						}
					}
				}
			}else {
				for(int j=0;j<length;j++){
					if(matrix[i][j] == '0') {
						if(i == j){
							matrix[i][j] = 'X';
						}else{
							Player ithPlayer = playerMap.get(i);
							Player jthPlayer = playerMap.get(j);
							if(jthPlayer != null){
								matrix[i][j] = (ithPlayer.mappedWith.index.equals(jthPlayer.index)) ? '+' : '-';
								matrix[j][i] = matrix[i][j] == '+' ? '-' : '+';
							}else{
								matrix[i][j] = '=';
							}
						}
					}
				}
			}
		}

		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		for(int i=0;i<t;i++)
			solve();
	}
}
