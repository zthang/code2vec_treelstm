private static void buildDSU() {
    parentSet = new int[n + 5];
    rankSet = new int[n + 5];
    for (int ii = 0; ii <= n; ii++) {
        parentSet[ii] = ii;
        rankSet[ii] = 0;
    }
}