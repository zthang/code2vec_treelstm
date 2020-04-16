private void bfs(List<Integer> src) {
    LinkedList<Node> toVisit = new LinkedList<>();
    for (int x : src) {
        Node node = nodes.get(x);
        node.visited = true;
        toVisit.add(node);
    }
    while (!toVisit.isEmpty()) {
        Node node = toVisit.poll();
        for (Node adj : node.nodes) {
            if (!adj.visited) {
                adj.dist = node.dist + 1;
                adj.visited = true;
                toVisit.add(adj);
            }
        }
    }
}