public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        current = node;
    }
    return current.endOfWord;
}