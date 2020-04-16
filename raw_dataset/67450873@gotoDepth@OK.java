public static StringTree.TrieNode gotoDepth(StringTree.TrieNode t, int d) {
    if (t.depth == d) {
        return t;
    }
    int log = CachedLog2.floorLog(t.depth - d);
    return gotoDepth(t.jump[log], d);
}