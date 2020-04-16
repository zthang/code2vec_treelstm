public void run() throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    int T = ni();
    for (int t = 1; t <= T; t++) {
        solve();
    }
    out.flush();
}