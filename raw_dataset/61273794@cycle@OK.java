private boolean cycle(ArrayList<Integer>[] graph, int root) {
    boolean[] vis = new boolean[graph.length];
    Stack<Integer> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
        int node = stack.pop();
        if (node == root && vis[root])
            return true;
        if (vis[node])
            continue;
        vis[node] = true;
        stack.addAll(graph[node]);
    }
    return false;
}