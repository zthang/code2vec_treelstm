private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
    if (recStack[i])
        return true;
    if (visited[i])
        return false;
    visited[i] = true;
    recStack[i] = true;
    List<Integer> children = adj.get(i);
    for (Integer c : children) if (isCyclicUtil(c, visited, recStack))
        return true;
    recStack[i] = false;
    return false;
}