private static void bfs(Node source) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(source);
    source.dist1 = 0;
    while (!queue.isEmpty()) {
        Node node = queue.poll();
        for (Node c : node.children) {
            if (c.dist1 == -1) {
                queue.add(c);
                c.dist1 = node.dist1 + 1;
            }
        }
    }
}