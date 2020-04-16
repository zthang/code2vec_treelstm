public static int permutation(int i, int[] p, int msk) {
    if (i == 7)
        return 0;
    int maxTotal = 0;
    for (int num = 1; num <= 6; num++) {
        int newMsk = msk;
        int tot = 0;
        p[i] = num;
        for (int j = 0; j < i; j++) {
            if (adjList[j][i]) {
                int min = Math.min(num, p[j]);
                int max = Math.max(num, p[j]);
                int idx = (max * (max - 1) / 2) + min;
                if ((newMsk & (1 << idx)) == 0) {
                    newMsk |= (1 << idx);
                    tot++;
                }
            }
        }
        maxTotal = Math.max(maxTotal, permutation(i + 1, p, newMsk) + tot);
    }
    return maxTotal;
}