/**
 * Created by yhf on 15/6/15.
 */

/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

class WordDictionary {

    Trie t = new Trie();

    // Adds a word into the data structure.
    public void addWord(String word) {
        t.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, t.getRoot());
    }

    private boolean search(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != '.') {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    return false;
                }
            } else {
                for (TrieNode child : node.children.values()) {
                    if (search(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return node.isLeaf;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");


public class AddAndSearchWord {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");

        boolean b1 = wordDictionary.search("a");
        boolean b2 = wordDictionary.search(".at");

        wordDictionary.addWord("bat");

        boolean b3 = wordDictionary.search(".at");
        boolean b4 = wordDictionary.search("an.");

        boolean b5 = wordDictionary.search("a.d.");
        boolean b6 = wordDictionary.search("b.");
    }
}


