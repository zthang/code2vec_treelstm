void run() throws Exception {
    in = new FastReader();
    out = new PrintWriter(System.out);
    int T = (multipleTC) ? ni() : 1;
    for (int i = 1; i <= T; i++) {
        solve(i);
        pn("");
    }
    out.flush();
    out.close();
}