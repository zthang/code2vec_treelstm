private static void secondTimeDfs(int parent) {
    for (int v : tree[parent]) {
        int parentContribution = res[parent] - Math.max(subTreeMaxDiff[v], 0);
        res[v] = subTreeMaxDiff[v] + (parentContribution > 0 ? parentContribution : 0);
        secondTimeDfs(v);
    }
}