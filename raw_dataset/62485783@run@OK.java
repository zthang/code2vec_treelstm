private void run() {
    try {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}