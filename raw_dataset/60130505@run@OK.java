void run() throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(System.out);
    long s = System.currentTimeMillis();
    solve();
    pw.flush();
}