static void bfs(Node[] nodes, Node from) {
    for (Node nn : nodes) nn.dist = -1;
    from.dist = 0;
    ArrayDeque<Node> bfs = new ArrayDeque<>();
    bfs.add(from);
    while (!bfs.isEmpty()) {
        Node next = bfs.remove();
        for (Node nn : next.backwards) {
            if (nn.dist == -1) {
                nn.dist = next.dist + 1;
                bfs.add(nn);
            }
        }
    }
}