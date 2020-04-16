void dfs(int x) {
    visited[x] = true;
    Iterator itr = adj[x].iterator();
    while (itr.hasNext()) {
        int z = (int) itr.next();
        if (!visited[z]) {
            dfs(z);
        }
    }
}