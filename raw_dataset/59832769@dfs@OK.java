public void dfs(Vertex curr, boolean[] visited, ArrayDeque<Vertex> order, boolean reverse, int component) {
    if (visited[curr.index]) {
        return;
    }
    visited[curr.index] = true;
    curr.comp = component;
    if (reverse) {
        for (Vertex other : curr.rev) {
            dfs(other, visited, order, reverse, component);
        }
    } else {
        for (Vertex other : curr.neighbors) {
            dfs(other, visited, order, reverse, component);
        }
        order.push(curr);
    }
}