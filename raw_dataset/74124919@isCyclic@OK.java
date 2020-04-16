private boolean isCyclic() {
    boolean[] visited = new boolean[v];
    boolean[] recStack = new boolean[v];
    for (int i = 0; i < v; i++) if (isCyclicUtil(i, visited, recStack))
        return true;
    return false;
}