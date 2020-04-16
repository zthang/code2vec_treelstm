static long go(int i, int j) {
    if (i == j)
        return 0;
    if (i == 0 && j == 1)
        return 0;
    // i < j
    if (i == 1 || i == 0)
        return numPs[j];
    if (largestPF[i] != largestPF[j])
        return numPs[i] + numPs[j];
    else {
        // LCA is matching of their pfs
        long res = numPs[i] + numPs[j];
        long match = 0;
        for (int k = largestPF[i]; k >= 2; k--) {
            match += Math.min(occs[i][k], occs[j][k]);
            if (occs[i][k] != occs[j][k])
                break;
        }
        return res - 2 * match;
    }
}