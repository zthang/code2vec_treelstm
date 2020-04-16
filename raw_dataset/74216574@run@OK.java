void run() throws Exception {
    is = oj ? System.in : new FileInputStream(INPUT_FILE_NAME);
    out = new PrintWriter(System.out);
    long s = System.currentTimeMillis();
    solve();
    out.flush();
    debug(System.currentTimeMillis() - s + "ms");
}