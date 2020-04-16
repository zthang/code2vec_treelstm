static void cycleDfs(int v) {
    visited[v] = 1;
    for (int i = 0; i < (int) adjList[v].size(); i++) {
        if (visited[(int) adjList[v].get(i).a] == 0) {
            cycleDfs((int) adjList[v].get(i).a);
        } else if (visited[(int) adjList[v].get(i).a] == 1) {
            adjList[v].get(i).b = true;
            hasCycle = true;
        }
    }
    visited[v] = 2;
}