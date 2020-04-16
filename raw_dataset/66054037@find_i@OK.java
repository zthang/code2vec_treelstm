static int find_i(long value, long[] d) {
    for (int i = 0; i < d.length; i++) {
        if (d[i] <= value) {
            return i + 1;
        }
    }
    return d.length;
}