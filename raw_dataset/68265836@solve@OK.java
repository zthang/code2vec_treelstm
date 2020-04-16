static int[] solve(int node) {
    int[] res = new int[sz[node]];
    int idd = 0;
    for (int ii : child[node]) {
        int[] x = solve(ii);
        for (int i = 0; i < x.length; i++) {
            // gonna place at idd
            if (idd == c[node]) {
                res[idd++] = node;
            }
            res[idd++] = x[i];
        }
    }
    if (idd < res.length) {
        if (idd != c[node])
            isGood = false;
        res[idd++] = node;
    }
    return res;
}