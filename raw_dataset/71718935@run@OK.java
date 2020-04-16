public void run() {
    try {
        if (systemIO) {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));
        }
        solve();
        out.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}