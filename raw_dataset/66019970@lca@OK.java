public Node lca(SparseTable<Node> st, Node a, Node b) {
    return st.query(Math.min(a.dfn, b.dfn), Math.max(a.dfn, b.dfn));
}