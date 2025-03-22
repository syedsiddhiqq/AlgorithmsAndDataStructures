package LeetCode.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieGrouping {
    public static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current.children.putIfAbsent(ch, new TrieNode());
                current = current.children.get(ch);
            }
            current.isEndOfWord = true;
        }

        public List<String> getWordsWithPrefix(String prefix) {
            List<String> result = new ArrayList<>();
            TrieNode current = root;

            for (char ch : prefix.toCharArray()) {
                if (!current.children.containsKey(ch)) {
                    return result; // No words with this prefix
                }
                current = current.children.get(ch);
            }

            collectAllWords(current, new StringBuilder(prefix), result);
            return result;
        }

        private void collectAllWords(TrieNode node, StringBuilder prefix, List<String> result) {
            if (node.isEndOfWord) {
                result.add(prefix.toString());
            }

            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                prefix.append(entry.getKey());
                collectAllWords(entry.getValue(), prefix, result);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("jump");
        trie.insert("run");
        trie.insert("run");
        trie.insert("jump");
        trie.insert("run");

        System.out.println("Words with prefix 'app': " + trie.getWordsWithPrefix("app"));
        System.out.println("Words with prefix 'ap': " + trie.getWordsWithPrefix("ap"));
        System.out.println("Words with prefix 'ba': " + trie.getWordsWithPrefix("ba"));
        System.out.println("Words with prefix 'x': " + trie.getWordsWithPrefix("x"));
    }
}
