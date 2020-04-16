// This function is a variation of DFSUtil() in
// https://www.geeksforgeeks.org/archives/18212
private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
    // part of recursion stack
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