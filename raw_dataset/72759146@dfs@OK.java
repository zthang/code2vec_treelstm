void dfs(int curMax, ArrayList<Integer> arr) {
    ArrayList<Integer>[] next = new ArrayList[curMax + 1];
    int[] cntTot = new int[curMax + 1];
    for (int i = 0; i <= curMax; i++) {
        next[i] = new ArrayList<>();
    }
    for (int j : arr) {
        if (max[j] >= 0) {
            next[max[j]].add(j);
            cntTot[max[j]] += cnt[j];
        }
    }
    for (int i = 0; i <= curMax; i++) {
        if (cntTot[i] > N / 2) {
            for (int j : next[i]) {
                cntPrime[j][i]--;
                max[j] = findNext(max[j], cntPrime[j]);
            }
            res += (N - cntTot[i]) - cntTot[i];
            dfs(i, next[i]);
            break;
        }
    }
}