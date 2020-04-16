private static boolean topoSortHelper(Set<Integer>[] g, Stack<Integer> stack, int[] state, int currNode) {
    if (state[currNode] == VISITED) {
        return true;
    } else if (state[currNode] == VISITING) {
        return false;
    }
    state[currNode] = VISITING;
    for (int neighbor : g[currNode]) {
        if (!topoSortHelper(g, stack, state, neighbor)) {
            return false;
        }
    }
    state[currNode] = VISITED;
    stack.push(currNode);
    return true;
}