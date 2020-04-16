public long[] readLongArray(int tokens) {
    long[] ret = new long[tokens];
    for (int i = 0; i < tokens; i++) {
        ret[i] = nextLong();
    }
    return ret;
}