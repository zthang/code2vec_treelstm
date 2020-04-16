void run() throws Exception {
    long ct = System.currentTimeMillis();
    if (fileIO) {
        in = new FastReader("");
        out = new PrintWriter("");
    } else {
        in = new FastReader();
        out = new PrintWriter(System.out);
    }
    // Solution Credits: Taranpreet Singh
    int T = (multipleTC) ? ni() : 1;
    pre();
    for (int t = 1; t <= T; t++) solve(t);
    out.flush();
    out.close();
    System.err.println(System.currentTimeMillis() - ct);
}