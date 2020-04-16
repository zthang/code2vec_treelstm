public static void DFS(LinkedList<Integer>[] adjList, int curr, int other, boolean[] visited, boolean flag) {
    if (curr == other)
        return;
    visited[curr] = true;
    for (int dest : adjList[curr]) {
        if (!visited[dest])
            DFS(adjList, dest, other, visited, flag);
    }
}