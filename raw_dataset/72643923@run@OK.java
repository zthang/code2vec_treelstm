void run() {
    try {
        in = new FastScanner(new File("A.in"));
        out = new PrintWriter(new File("A.out"));
        solve();
        out.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}