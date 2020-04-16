public static void dfs(int u) {
    s.add(u);
    dfsLow[u] = dfsNum[u] = ++time;
    for (int v : adjList[u]) {
        if (dfsNum[v] == 0)
            dfs(v);
        if (!inSCC[v])
            dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);
    }
    if (dfsLow[u] == dfsNum[u]) {
        while (true) {
            int num = s.pop();
            SCC[num] = SCCidx;
            inSCC[num] = true;
            if (dfsLow[num] == dfsNum[num])
                break;
        }
        SCCidx++;
    }
}