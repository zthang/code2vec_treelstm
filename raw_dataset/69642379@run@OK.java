void run() throws Exception {
    is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
    pw = new PrintWriter(System.out);
    long s = System.currentTimeMillis();
    solve();
    pw.flush();
    if (!INPUT.isEmpty())
        tr(System.currentTimeMillis() - s + "ms");
}