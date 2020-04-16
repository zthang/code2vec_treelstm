// String.format("%8.3f", ans).replace(',', '.')
private void run() throws IOException {
    if (systemIO) {
        in = new solveLOL.FastScanner(System.in);
        out = new PrintWriter(System.out);
    } else {
        in = new solveLOL.FastScanner(new File("input.txt"));
        out = new PrintWriter(new File("output.txt"));
    }
    for (int t = multitests ? in.nextInt() : 1; t-- > 0; ) solve();
    out.close();
}