package Algorithms.others;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 17/03/2021, Wednesday, 01:35
 */
class TrieDsImpl {




//	static TrieNode insert(String s,int index){
//		if(index == s.length() - 1){
//			return new TrieNode();
//		}
//
//	}


	static void insert(String s,TrieNode root){
		TrieNode currentNode = root;
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(!currentNode.map.containsKey(ch)){
				root.map.put(ch,new TrieNode());
			}else{
				currentNode = currentNode.map.get(ch);
			}
		}
		currentNode.endOfWord = true;
	}

	static boolean searchSubstr(String str,TrieNode root, int index){
		if(index == str.length() - 1 && root.map.containsKey(str.charAt(index))) return true;
		if(!root.map.containsKey(str.charAt(index))) return false;
		return searchSubstr(str,root.map.get(str.charAt(index)),index+1);
	}


	static boolean searchWord(String word,TrieNode root, int index){
		if(index == word.length() - 1){
			return root.endOfWord;
		}

		if(!root.map.containsKey(word.charAt(index))) return false;
		return searchWord(word,root.map.get(word.charAt(index)),index+1);
	}


	static void insertRecursive(String s,TrieNode node,int index){
		if(index == s.length() - 1){
			node.endOfWord = true;
			return;
		}
		if(!node.map.containsKey(s.charAt(index))){
			node.map.put(s.charAt(index),new TrieNode());
		}

		insertRecursive(s,node.map.get(s.charAt(index)),index+1);
	}


	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		List<String> strings = new ArrayList<>();
		strings.add("abc");
		strings.add("abd");
		strings.add("abcd");
		strings.add("lmn");
		strings.add("bbc");


		strings.forEach(str->{
//			insert(str,root);
			insertRecursive(str,root,0);
		});

	}
}


 class TrieNode{
	Map<Character,TrieNode> map;
	boolean endOfWord = false;

	public TrieNode() {
		this.map = new HashMap<>();
	}
}



