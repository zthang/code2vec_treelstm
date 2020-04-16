private void bfs(int label) {
    Node root = nodes.get(label);
    root.visited = true;
    LinkedList<Node> linkedList = new LinkedList<>();
    linkedList.add(root);
    while (!linkedList.isEmpty()) {
        Node node = linkedList.poll();
        for (Node adjacent : node.adjacents) {
            if (!adjacent.visited) {
                adjacent.visited = true;
                adjacent.dist = node.dist + 1;
                linkedList.add(adjacent);
            }
        }
    }
}