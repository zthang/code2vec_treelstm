public static int compare(Trie a, Trie b) {
    if (a.depth != b.depth) {
        return a.depth - b.depth;
    }
    if (a == b) {
        return 0;
    }
    Trie lca = lca(a, b);
    a = gotoDepth(a, lca.depth + 1);
    b = gotoDepth(b, lca.depth + 1);
    return a.c - b.c;
}