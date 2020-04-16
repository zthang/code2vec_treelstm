public static Trie insert(Trie root, int digit) {
    if (digit == 0) {
        return root;
    }
    root = insert(root, digit / 10);
    int tail = digit % 10;
    if (root.next[tail] == null) {
        root.next[tail] = new Trie(root, tail);
    }
    return root.next[tail];
}