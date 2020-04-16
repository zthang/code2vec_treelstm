public StringTree.TrieNode insert(StringTree.TrieNode root, int digit) {
    if (root.next[digit - l] == null) {
        root.next[digit - l] = newTrieNode(root, digit);
    }
    return root.next[digit - l];
}