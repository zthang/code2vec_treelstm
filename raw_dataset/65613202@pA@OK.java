public static <T> void pA(T[] a, int n) throws IOException {
    for (int i = 0; i < n; i++) {
        log.write(a[i].toString() + "\n");
    }
    log.write("\n");
}