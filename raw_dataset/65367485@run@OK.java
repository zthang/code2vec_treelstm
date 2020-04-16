void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    long s = System.currentTimeMillis();
    solve();
    out.flush();
    out.close();
}