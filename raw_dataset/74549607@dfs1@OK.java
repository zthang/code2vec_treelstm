void dfs1(int nd, int pr) {
    dp1[nd] = arr[nd] == 1 ? 1 : -1;
    for (int i = 0; i < arl.get(nd).size(); i++) {
        if (arl.get(nd).get(i) == pr) {
            continue;
        }
        dfs1(arl.get(nd).get(i), nd);
        dp1[nd] += Math.max(0, dp1[arl.get(nd).get(i)]);
    }
}