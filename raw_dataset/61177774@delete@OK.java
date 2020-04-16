private boolean delete(TrieNode current, String word, int index) {
    if (index == word.length()) {
        if (!current.endOfWord) {
            return false;
        }
        current.endOfWord = false;
        return current.children.size() == 0;
    }
    char ch = word.charAt(index);
    TrieNode node = current.children.get(ch);
    if (node == null) {
        return false;
    }
    boolean shouldDeleteCurrentNode = delete(node, word, index + 1);
    if (shouldDeleteCurrentNode) {
        current.children.remove(ch);
        return current.children.size() == 0;
    }
    return false;
}