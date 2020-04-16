private static void bfs1(Node source) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(source);
    source.dist2 = 0;
    while (!queue.isEmpty()) {
        Node node = queue.poll();
        for (Node c : node.children) {
            if (c.dist2 == -1) {
                queue.add(c);
                c.dist2 = node.dist2 + 1;
            }
        }
    }
}