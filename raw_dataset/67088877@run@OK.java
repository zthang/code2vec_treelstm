void run() {
    try {
        in = new FastScanner(new File("D.in"));
        out = new PrintWriter(new File("D.out"));
        solve();
        out.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}