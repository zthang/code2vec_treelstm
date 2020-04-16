void run() throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    ob = new PrintWriter(System.out);
    int t = ni();
    while (t-- > 0) {
        solve();
    }
    ob.flush();
}