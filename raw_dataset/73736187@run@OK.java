void run() throws Exception {
    // oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
    is = System.in;
    out = new PrintWriter(System.out);
    long s = System.currentTimeMillis();
    solve();
    out.flush();
    tr(System.currentTimeMillis() - s + "ms");
}