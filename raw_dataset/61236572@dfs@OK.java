static void dfs(int vertex) {
    color[vertex] = 1;
    for (int i = 0; i < graph[vertex].size(); i++) {
        edge e = graph[vertex].get(i);
        int to = e.to;
        if (color[to] == 0) {
            dfs(to);
        } else if (color[to] == 1) {
            isCyclic = true;
            back[e.no] = true;
        }
    }
    color[vertex] = 2;
}