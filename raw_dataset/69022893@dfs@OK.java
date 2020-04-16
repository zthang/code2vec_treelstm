static void dfs(int s, int t) {
    visited[s] = true;
    count++;
    // System.out.println(" count= "+count);
    for (int i = 0; i < adj.get(s).size(); i++) {
        int next = adj.get(s).get(i);
        // System.out.println(" next= "+next);
        if (!visited[next] && next != t) {
            dfs(next, t);
        }
    }
}