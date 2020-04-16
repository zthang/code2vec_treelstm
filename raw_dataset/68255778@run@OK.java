void run() throws Exception {
    // int n = 2000, m = 99999;
    // Random gen = new Random();
    // StringBuilder sb = new StringBuilder();
    // sb.append(n + " ");
    // for (int i = 0; i < n; i++) {
    // sb.append(i + " " + gen.nextInt(n-i) + "\n");
    // }
    // INPUT = sb.toString();
    is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
    out = new PrintWriter(System.out);
    long s = System.currentTimeMillis();
    solve();
    out.flush();
    tr(System.currentTimeMillis() - s + "ms");
}