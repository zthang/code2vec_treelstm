private int bfs(int label) {
    int maxVisitedNode = 0;
    Node fitsNode = nodes[label];
    fitsNode.visited = true;
    LinkedList<Node> toVisit = new LinkedList<>();
    toVisit.add(fitsNode);
    while (!toVisit.isEmpty()) {
        Node node = toVisit.poll();
        maxVisitedNode = Math.max(maxVisitedNode, node.label);
        for (Node adjacent : node.adjacents) {
            if (!adjacent.visited) {
                adjacent.visited = true;
                toVisit.add(adjacent);
            }
        }
    }
    return maxVisitedNode;
}