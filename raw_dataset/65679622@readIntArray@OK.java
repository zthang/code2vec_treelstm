public int[] readIntArray(int start, int n) {
    int[] ret = new int[start + n];
    for (int i = start; i < start + n; ++i) {
        ret[i] = this.nextInt();
    }
    return ret;
}