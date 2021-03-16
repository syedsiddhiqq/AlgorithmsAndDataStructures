package HackerRank;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 17/03/2021, Wednesday, 03:06
 */
public class ContactsSolution2 {
	static Scanner sc;
	static Trie root;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int op = sc.nextInt();
		root = new Trie(0);
		int i;
		String operation, word;
		for(i=0; i<op;i++) {
			operation = sc.next();
			word = sc.next();
			if(operation.equals("add")) {
				addWord(word);
			}
			if(operation.equals("find")) {
				System.out.println(count(word));
			}
		}
	}
	static void addWord(String word) {
		Trie currentTrie = root;
		int i, index;
		for(i=0; i<word.length();i++) {
			index = word.charAt(i)-'a';
			if(currentTrie.children[index] == null) {
				currentTrie.children[index] = new Trie(1);
			} else {
				currentTrie.children[index].count++;
			}
			currentTrie = currentTrie.children[index];
		}
	}
	static int count (String word) {
		int i, index;
		Trie currentTrie = root;
		for(i=0 ;i<word.length();i++) {
			index = word.charAt(i)-'a';
			if(currentTrie.children[index]==null) {
				return 0;
			} else {
				currentTrie = currentTrie.children[index];
			}
		}
		return currentTrie.count;
	}
	static class Trie {
		int count;
		Trie[] children;
		public Trie(int count) {
			this.count = count;
			this.children = new Trie[26];
		}
	}
}
