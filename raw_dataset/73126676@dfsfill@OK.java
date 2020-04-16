private static void dfsfill(int v, int par, int pval, int[] subtree, int[] root) {
    root[v] = subtree[v] + pval;
    for (int child : edges[v]) {
        if (child != par) {
            pval = Math.max(root[v] - Math.max(subtree[child], 0), 0);
            dfsfill(child, v, pval, subtree, root);
        }
    }
}