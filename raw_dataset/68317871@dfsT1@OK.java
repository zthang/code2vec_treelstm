public void dfsT1(Node root, Edge from, int depth) {
    root.from = from;
    root.jump = new Node[20];
    root.depth = depth;
    if (root.from != null) {
        root.jump[0] = from.other(root);
        for (int i = 0; root.jump[i] != null; i++) {
            root.jump[i + 1] = root.jump[i].jump[i];
        }
    }
    for (Edge e : root.next) {
        if (e == from) {
            continue;
        }
        dfsT1(e.other(root), e, depth + 1);
    }
}