public void run() {
    try {
        if (systemIO) {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            in = new FastScanner(new File("frequent.in"));
            out = new PrintWriter(new File("frequent.out"));
        }
        solve();
        out.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}