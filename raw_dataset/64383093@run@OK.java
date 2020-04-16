void run() throws Exception {
    if (fileIO) {
        in = new FastReader("C:/users/user/desktop/inp.in");
        out = new PrintWriter("C:/users/user/desktop/out.out");
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
}