public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long[] bal = new long[n];
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        long c = in.nextLong();
        bal[a] -= c;
        bal[b] += c;
    }
    Queue<Integer> pos = new ArrayDeque<>();
    Queue<Integer> neg = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        if (bal[i] > 0)
            pos.add(i);
        if (bal[i] < 0)
            neg.add(i);
        bal[i] = Math.abs(bal[i]);
    }
    List<String> output = new ArrayList<>();
    while (!pos.isEmpty() && !neg.isEmpty()) {
        int a = neg.poll();
        int b = pos.poll();
        long c = Math.min(bal[a], bal[b]);
        bal[a] -= c;
        bal[b] -= c;
        output.add(Util.join(a + 1, b + 1, c));
        if (bal[a] > 0)
            neg.add(a);
        if (bal[b] > 0)
            pos.add(b);
    }
    out.println(output.size());
    for (String s : output) out.println(s);
}