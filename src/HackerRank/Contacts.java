package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 17/03/2021, Wednesday, 02:03
 * https://www.hackerrank.com/challenges/contacts/problem
 */
public class Contacts {
	static class TrieNode{
		Map<Character,TrieNode> map;
		boolean endOfWord = false;

		TrieNode() {
			this.map = new HashMap<>();
		}
	}

	private static int searchSubstr(String str, TrieNode root){
		int count = 0;
		TrieNode current = root;
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(!current.map.containsKey(ch)){
				return 0;
			}
			current = current.map.get(ch);
		}
		while(!current.map.isEmpty()){
			count = count+1;
			current.map.keySet().forEach(key->{

			});
		}
		return 0;
	}

	private static void insertRecursive(String s, TrieNode node, int index){
		if(index == s.length()){
			node.endOfWord = true;
			return;
		}
		if(!node.map.containsKey(s.charAt(index))){
			node.map.put(s.charAt(index),new TrieNode());
		}

		insertRecursive(s,node.map.get(s.charAt(index)),index+1);
	}

	static void contacts(List<String> queries) {
		TrieNode root = new TrieNode();
		for (String query : queries) {
			String[] splitArr = query.split(" ");
			if (splitArr[0].equals("add")) {
				insertRecursive(splitArr[1], root, 0);
			} else {
				System.out.println(searchSubstr(splitArr[1], root) - 1);
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		List<String> quries = new ArrayList<>();
		scanner.nextLine();
		while(n-- > 0){
			quries.add(scanner.nextLine());
		}

		contacts(quries);
	}
}
