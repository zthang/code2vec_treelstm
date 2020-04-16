void solve() throws IOException {
    scanner = new FastScanner(System.in);
    writer = new PrintWriter(System.out);
    int tests = scanner.nextInt();
    for (int t = 0; t < tests; t++) {
        int n = scanner.nextInt();
        String s = scanner.next();
        printList(minLIS(n, s));
        printList(maxLIS(n, s));
    }
    writer.close();
}