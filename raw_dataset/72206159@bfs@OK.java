private void bfs(int src) {
    Node srcNode = nodes.get(src);
    srcNode.dist = 1;
    srcNode.currVisited = true;
    LinkedList<Node> toVisit = new LinkedList<>();
    toVisit.add(srcNode);
    while (!toVisit.isEmpty()) {
        Node node = toVisit.poll();
        for (Node adjacent : node.adjacents) {
            if (!adjacent.currVisited) {
                adjacent.dist = node.dist + 1;
                adjacent.currVisited = true;
                toVisit.add(adjacent);
            }
        }
    }
}