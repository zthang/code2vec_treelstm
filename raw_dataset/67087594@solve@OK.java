public void solve(Scanner sc, PrintWriter pw) throws IOException {
    int n = sc.nextInt();
    int m = sc.nextInt();
    long[] owe = new long[n];
    for (int i = 0; i < m; i++) {
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        int c = sc.nextInt();
        owe[a] += c;
        owe[b] -= c;
    }
    long tot = 0;
    int pos = 0, neg = 0;
    List<long[]> edge = new ArrayList<>();
    while (pos < n) {
        while (pos < n && owe[pos] <= 0) pos++;
        while (neg < n && owe[neg] >= 0) neg++;
        if (pos == n || neg == n)
            break;
        long abs = Math.min(owe[pos], -owe[neg]);
        tot += abs;
        edge.add(new long[] { pos + 1, neg + 1, abs });
        owe[pos] -= abs;
        owe[neg] += abs;
    }
    pw.println(edge.size());
    for (long[] trn : edge) {
        pw.println(trn[0] + " " + trn[1] + " " + trn[2]);
    }
}