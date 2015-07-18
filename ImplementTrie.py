"""
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
"""


class TrieNode:
    # Initialize your data structure here.
    def __init__(self, x=None):
        self.val = x
        self.children = []
        self.is_leaf = False

    def __repr__(self):
        return self.val

    def get_child(self, x):
        for child in self.children:
            if child.val == x:
                return child
        return None


class Trie:

    def __init__(self):
        self.root = TrieNode()

    # @param {string} word
    # @return {void}
    # Inserts a word into the trie.
    def insert(self, word):
        root = self.root
        for char in word:
            child = root.get_child(char)
            if not child:
                child = TrieNode(char)
                root.children.append(child)
            root = child
        root.is_leaf = True

    # @param {string} word
    # @return {boolean}
    # Returns if the word is in the trie.
    def search(self, word):
        root = self.root
        for char in word:
            child = root.get_child(char)
            if not child:
                return False
            root = child
        return root.is_leaf

    # @param {string} prefix
    # @return {boolean}
    # Returns if there is any word in the trie
    # that starts with the given prefix.
    def startsWith(self, prefix):
        root = self.root
        for char in prefix:
            child = root.get_child(char)
            if not child:
                return False
            root = child
        return True


if __name__ == '__main__':
    # Your Trie object will be instantiated and called as such:
    trie = Trie()
    trie.insert("abc")
    # print trie.search("abc")
    # print trie.search("ab")
    trie.insert("ab")
    print trie.root.children[0].children[0].children[0].children
    print trie.search("ab")
    # trie.insert("ab")
    # print trie.search("ab")
