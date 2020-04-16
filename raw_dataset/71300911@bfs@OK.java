static void bfs(Node from, Node[] nodes) {
    ArrayDeque<Node> bfs = new ArrayDeque<>();
    for (Node nn : nodes) nn.dist = -1;
    bfs.add(from);
    from.dist = 0;
    while (!bfs.isEmpty()) {
        Node next = bfs.remove();
        for (Node nn : next.adj) {
            if (nn.dist == -1) {
                nn.dist = next.dist + 1;
                bfs.add(nn);
            }
        }
    }
}