public void solve() throws QuickAnswer {
    int k = nextInt();
    Tree tree = Tree.treeBuilder().nodeCount(2 * k).withWeights().build(this::nextInt);
    int[] counts = new int[2 * k];
    int[] togo = new int[2 * k];
    int pos = 0;
    int end = 0;
    Integer[] order = new Integer[2 * k];
    for (int i = 0; i < 2 * k; i++) {
        order[i] = i;
    }
    Arrays.sort(order, (i1, i2) -> tree.level[i2] - tree.level[i1]);
    for (int i : order) {
        counts[i]++;
        if (i == 0)
            continue;
        counts[tree.parent[i]] += counts[i];
    }
    long min = 0;
    long max = 0;
    for (int i = 0; i < tree.edgeCount; i++) {
        int n1 = tree.edgeFrom[i];
        int n2 = tree.edgeTo[i];
        int n = tree.level[n1] < tree.level[n2] ? n2 : n1;
        if (counts[n] % 2 == 1)
            min += tree.edgeWeight[i];
        max += (long) tree.edgeWeight[i] * Math.min(counts[n], 2 * k - counts[n]);
    }
    print(min + " " + max);
}