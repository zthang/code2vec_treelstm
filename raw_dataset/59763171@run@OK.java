private void run() throws IOException {
    // new FastScanner(new FileInputStream(".in"));
    in = new FastScanner(System.in);
    // new PrintWriter(new FileOutputStream(".out"));
    out = new PrintWriter(System.out);
    for (int t = multitests ? in.nextInt() : 1; t-- > 0; ) solve();
    out.flush();
    out.close();
}