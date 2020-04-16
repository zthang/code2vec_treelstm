public static boolean check(int[] array, int node) {
    for (int k = 0; k < array.length; k++) {
        if (array[k] == node)
            continue;
        int lca = lca(array[k], node);
        if (lca == array[k] || adj.get(lca).contains(array[k]))
            continue;
        return false;
    }
    return true;
}