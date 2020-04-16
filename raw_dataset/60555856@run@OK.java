void run() {
    try {
        in = new FastScanner(new File("F.in"));
        out = new PrintWriter(new File("F.out"));
        solve();
        out.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}