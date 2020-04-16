static int knapSack(long W, int[] wt, int[] val, int n) {
    // Base Case
    if (n <= 0 || W == 0)
        return 0;
    if (wt[n - 1] > W)
        return knapSack(W, wt, val, n - 1);
    else
        return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 2), knapSack(W, wt, val, n - 1));
}