public void run() {
    sc = new FastScanner(oj ? System.in : new ByteArrayInputStream(INPUT.getBytes()));
    out = new PrintWriter(System.out);
    long s = System.currentTimeMillis();
    try {
        solve();
    } catch (ExitException ignored) {
    }
    out.flush();
    tr(System.currentTimeMillis() - s + "ms");
}