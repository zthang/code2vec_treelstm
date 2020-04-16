public StringTree.TrieNode newTrieNode(StringTree.TrieNode p, int c) {
    StringTree.TrieNode node = newTrieNode();
    node.depth = p.depth + 1;
    node.value = c;
    node.jump[0] = p;
    node.r = mod.valueOf(p.r * 10L + c);
    for (int i = 0; node.jump[i] != null; i++) {
        node.jump[i + 1] = node.jump[i].jump[i];
    }
    return node;
}