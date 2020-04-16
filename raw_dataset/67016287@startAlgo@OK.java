void startAlgo() {
    while (edges-- > 0) {
        int u = k.nextInt() - 1;
        int v = k.nextInt() - 1;
        union.mergeSets(u, v);
    }
    int count = 0;
    int rootNode = 0;
    while (true) {
        for (int node = rootNode; node <= union.getMax(rootNode); node++) {
            if (!union.isSameSet(rootNode, node)) {
                union.mergeSets(rootNode, node);
                count++;
            }
        }
        if (union.getMax(rootNode) == nodes - 1) {
            break;
        }
        rootNode = union.getMax(rootNode) + 1;
    }
    z.println(count);
}