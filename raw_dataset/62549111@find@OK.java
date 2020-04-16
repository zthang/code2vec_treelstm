static long find(int n, int p, int[] dm, int ind) {
    int i, j;
    long ans = cst[dm[ind]][n];
    for (i = 0; i < grph.get(n).size(); ++i) {
        j = grph.get(n).get(i);
        if (j != p)
            ans += find(j, n, dm, (ind + 1) % 3);
    }
    return ans;
}