package LeetCode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 30/12/2021, Thursday, 00:09
 */
public class WordSearch2 {
	private class Words{
		List<String> words = new ArrayList<>();
		int maxLength = Integer.MIN_VALUE;

		Words(){

		}
	}

	List<String> output = new ArrayList<>();
	int row,col;
	int[][] visited;
	public List<String> findWords(char[][] board, String[] words) {
		Map<Character,Words> map = new HashMap<>();
		row = board.length;
		col = board[0].length;
		visited = new int[row][col];
		for(String word: words){
			char ch = word.charAt(0);
			if(map.containsKey(ch)){
				Words obj = map.get(ch);
				obj.words.add(word);
				obj.maxLength = Math.max(obj.maxLength, word.length());
			}else{
				Words obj = new Words();
				obj.words.add(word);
				obj.maxLength = word.length();
				map.put(ch,obj);
			}
		}

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(map.containsKey(board[i][j])){
					Words obj = map.get(board[i][j]);
					findWord(board,obj.maxLength,"",obj.words,i,j);
				}
			}
		}

		return output;
	}

	private void findWord(char[][] board,int maxLength,String word,List<String> words,int i, int j){
		if(words.contains(word)){
			output.add(word);
			words.remove(word);
			return;
		}
		if(i < 0 || j < 0 || i >= row || j >= col || visited[i][j] == 1 || word.length() > maxLength) return;
		visited[i][j] = 1;
		String temp = word + board[i][j] + "";
		findWord(board,maxLength,temp,words,i,j-1);
		findWord(board,maxLength,temp,words,i,j+1);
		findWord(board,maxLength,temp,words,i+1,j);
		findWord(board,maxLength,temp,words,i-1,j);
		visited[i][j] = 0;
	}

	public static void main(String[] args) {
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain","oathi","oathk","oathf","oate","oathii","oathfi","oathfii"};

		char[][] board1 = {{'a'}};
		String[] words1 = {"a"};
		WordSearch2 wordSearch2 = new WordSearch2();
		wordSearch2.findWords(board,words);
	}
}
