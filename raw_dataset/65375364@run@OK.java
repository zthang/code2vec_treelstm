public void run() {
    try {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    } catch (Throwable t) {
        t.printStackTrace(System.err);
        System.exit(-1);
    }
}