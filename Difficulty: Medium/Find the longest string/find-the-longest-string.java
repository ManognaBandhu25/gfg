import java.util.*;

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
        String word = null; 
    }

    private TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEnd = true;
        node.word = word;
    }

    public String longestString(String[] words) {
        for (String word : words) {
            insert(word);
        }

        String result = "";
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TrieNode current = queue.poll();

            for (char ch = 'z'; ch >= 'a'; ch--) {
                TrieNode child = current.children.get(ch);
                if (child != null && child.isEnd) {
                    queue.offer(child);
                    String w = child.word;
                    if (w.length() > result.length() || 
                        (w.length() == result.length() && w.compareTo(result) < 0)) {
                        result = w;
                    }
                }
            }
        }

        return result;
    }
}
