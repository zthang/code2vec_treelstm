public static void dfs(int curr, LinkedList<Integer>[] edges, int[] size, boolean[] seen) {
    size[curr] = 1;
    seen[curr] = true;
    for (int next : edges[curr]) if (!seen[next]) {
        dfs(next, edges, size, seen);
        size[curr] += size[next];
    }
    return;
}