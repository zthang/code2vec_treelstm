public static void dfs(int node, int par) {
    parent[node] = par;
    count++;
    timeIn[node] = count;
    for (int each : adjList[node]) {
        if (each != par)
            dfs(each, node);
    }
    count++;
    timeOut[node] = count;
}