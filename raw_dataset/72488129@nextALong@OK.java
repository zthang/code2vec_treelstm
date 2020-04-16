public void nextALong(long[] a, int off, int len) {
    for (int i = off; i < off + len; i++) {
        a[i] = nextLong();
    }
}