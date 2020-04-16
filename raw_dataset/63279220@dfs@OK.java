static long dfs(int v, int pc, int tc) {
    // out.println(v+" "+pc+" "+tc);
    visited[v] = true;
    mincolor[v] = tc;
    for (int i : list.get(v)) {
        if (visited[i] == false)
            return (cost[tc][v] + dfs(i, tc, 6 - pc - tc));
    }
    return cost[tc][v];
}