public void nextAInt(int[] a, int off, int len) {
    for (int i = off; i < off + len; i++) {
        a[i] = nextInt();
    }
}