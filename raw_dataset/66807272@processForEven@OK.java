void processForEven() {
    boolean[] isVisited = new boolean[n + 1];
    while (!evenQueue.isEmpty()) {
        int u = evenQueue.poll();
        isVisited[u] = true;
        for (int v : evenGraph[u]) {
            if (!isVisited[v]) {
                isVisited[v] = true;
                evenQueue.add(v);
                evenD[v] = evenD[u] + 1;
            }
        }
    }
}