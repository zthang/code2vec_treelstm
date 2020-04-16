public static void dfs(String st, ArrayList<Integer>[] tree, int[][] color, long cost, int root, int pos, int pha) {
    visited.put(root, 0);
    int y = pos;
    if (y % 3 == 0)
        y = 3;
    else
        y = y % 3;
    yu += color[st.charAt(y) - '0'][root];
    ans[pha][root] = st.charAt(y) - '0';
    for (int i = 0; i < tree[root].size(); i++) {
        int val = tree[root].get(i);
        if (!visited.containsKey(val))
            dfs(st, tree, color, cost, val, pos + 1, pha);
    }
}