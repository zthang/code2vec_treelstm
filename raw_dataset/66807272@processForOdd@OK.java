void processForOdd() {
    boolean[] isVisited = new boolean[n + 1];
    while (!oddQueue.isEmpty()) {
        int u = oddQueue.poll();
        isVisited[u] = true;
        for (int v : oddGraph[u]) {
            if (!isVisited[v]) {
                isVisited[v] = true;
                oddQueue.add(v);
                oddD[v] = oddD[u] + 1;
            }
        }
    }
}