import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhf on 15/6/14.
 */

class TrieNode {
    static int R = 26;
    char val;
    Boolean isLeaf = false;

    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode() {}

    public TrieNode(char c) {
        val = c;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                TrieNode temp = new TrieNode(c);
                node.children.put(c, temp);
                node = temp;
            }
        }
        node.isLeaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

public class ImplementTrie {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("fuck");
        t.insert("shell");
        t.insert("suck");
        t.insert("she");
        System.out.println(t.startsWith("shel"));
    }
}
