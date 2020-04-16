static void dfs(int cur) {
    dfsNum[cur] = dfsLow[cur] = ++counter;
    stack.push(cur);
    for (int v : adjList[cur]) {
        if (dfsNum[v] == 0)
            dfs(v);
        if (scc[v] == -1)
            dfsLow[cur] = Math.min(dfsLow[cur], dfsLow[v]);
    }
    if (dfsNum[cur] == dfsLow[cur]) {
        while (true) {
            int v = stack.pop();
            scc[v] = SCC;
            if (v == cur)
                break;
        }
        SCC++;
    }
}