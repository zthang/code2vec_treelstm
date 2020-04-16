private void dfs(int node) {
    if (dump)
        System.out.println("dfs on node " + node + ", at time " + t);
    timeRange[node][0] = t;
    for (int next : nbs[node]) {
        if (timeRange[next][0] == 0) {
            ++t;
            dfs(next);
        }
    }
    timeRange[node][1] = t;
    subTreeSize[node] = t - timeRange[node][0] + 1;
}