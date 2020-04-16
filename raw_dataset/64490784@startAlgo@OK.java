void startAlgo() {
    ArrayList<Integer> removedNodes = new ArrayList<Integer>();
    int component = 0;
    while (!nodes.isEmpty()) {
        component++;
        int u = nodes.first();
        queue.add(u);
        nodes.remove(u);
        while (!queue.isEmpty()) {
            u = queue.pollFirst();
            for (int v : nodes) {
                if (!graph[u].contains(v)) {
                    queue.add(v);
                    removedNodes.add(v);
                }
            }
            for (int rn : removedNodes) {
                nodes.remove(rn);
            }
            removedNodes.clear();
            nodes.remove(u);
        }
    }
    z.println(component - 1);
}