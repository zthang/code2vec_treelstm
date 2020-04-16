public static void dfs(int curr, LinkedList<Integer>[] edges, boolean[] seen, int forbid) {
    seen[curr] = true;
    for (int next : edges[curr]) if (!seen[next] && next != forbid)
        dfs(next, edges, seen, forbid);
}