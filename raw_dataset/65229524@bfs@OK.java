static int bfs(node theNode) {
    int max = 0;
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    theNode.visited = true;
    Queue<node> cola = new LinkedList<node>();
    cola.add(theNode);
    while (!cola.isEmpty()) {
        node act = cola.poll();
        max = Math.max(max, act.id);
        for (node adj : act.adj) {
            if (!adj.visited) {
                adj.visited = true;
                cola.add(adj);
            }
        }
    }
    return max;
}