public void dfs(BNumbersOnTree.Node root) {
    Splay merged = Splay.NIL;
    for (BNumbersOnTree.Node node : root.next) {
        dfs(node);
        Splay.splay(node.splay);
        merged = Splay.merge(merged, node.splay);
    }
    if (merged.size < root.ci) {
        valid = false;
        return;
    }
    if (root.ci == 0) {
        merged = Splay.merge(root.splay, merged);
        return;
    }
    merged = Splay.selectKthAsRoot(merged, root.ci);
    Splay right = Splay.splitRight(merged);
    merged = Splay.merge(merged, root.splay);
    merged = Splay.merge(merged, right);
}