void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    long time = System.currentTimeMillis();
    int t = nextInt();
    for (int i = 0; i < t; i++) {
        solve();
    }
    System.err.println("time = " + (System.currentTimeMillis() - time));
    out.close();
}