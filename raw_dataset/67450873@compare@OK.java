public static int compare(StringTree.TrieNode a, StringTree.TrieNode b) {
    if (a.depth != b.depth) {
        return a.depth - b.depth;
    }
    if (a == b) {
        return 0;
    }
    StringTree.TrieNode lca = lca(a, b);
    a = gotoDepth(a, lca.depth + 1);
    b = gotoDepth(b, lca.depth + 1);
    return a.value - b.value;
}