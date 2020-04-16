private static Stack<Integer> topologicalSort(Set<Integer>[] g) {
    Stack<Integer> stack = new Stack<>();
    int[] state = new int[g.length];
    for (int node = 0; node < g.length; node++) {
        if (!topoSortHelper(g, stack, state, node)) {
            return null;
        }
    }
    return stack;
}