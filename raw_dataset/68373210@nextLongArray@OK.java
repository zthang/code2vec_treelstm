public long[] nextLongArray(int N) {
    long[] ret = new long[N];
    for (int i = 0; i < N; i++) ret[i] = this.nextLong();
    return ret;
}