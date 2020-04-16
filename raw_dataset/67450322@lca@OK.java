public static Trie lca(Trie a, Trie b) {
    if (a.depth > b.depth) {
        Trie tmp = a;
        a = b;
        b = tmp;
    }
    b = gotoDepth(b, a.depth);
    if (a == b) {
        return a;
    }
    for (int i = 20; i >= 0; i--) {
        if (a.jump[i] == b.jump[i]) {
            continue;
        }
        a = a.jump[i];
        b = b.jump[i];
    }
    return a.jump[0];
}