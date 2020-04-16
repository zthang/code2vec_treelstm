public void run() {
    long time = System.currentTimeMillis();
    boolean oj = judge || System.getProperty("ONLINE_JUDGE") != null;
    out = new PrintWriter(System.out);
    scn = new FastReader(oj);
    solve();
    out.flush();
    if (!oj) {
        System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - time + " ms" }));
    }
}