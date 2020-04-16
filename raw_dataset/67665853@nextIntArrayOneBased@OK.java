public final int[] nextIntArrayOneBased(final int n) {
    int[] ret = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        ret[i] = nextInt();
    }
    return ret;
}