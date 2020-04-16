static void buildDAG() {
    DAG = new HashSet[SCC];
    inDegree = new int[SCC];
    for (int i = 0; i < SCC; ++i) {
        DAG[i] = new HashSet<>();
    }
    for (int i = 0; i < V; ++i) {
        for (int node : adjList[i]) {
            if (scc[i] != scc[node] && !DAG[scc[i]].contains(scc[node])) {
                DAG[scc[i]].add(scc[node]);
                inDegree[scc[node]]++;
            }
        }
    }
}