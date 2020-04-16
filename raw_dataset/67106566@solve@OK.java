public void solve() throws FileNotFoundException {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    int n = in.nextInt();
    int m = in.nextInt();
    long[] a = new long[n + 5];
    for (int i = 0; i < m; i++) {
        int x = in.nextInt();
        int y = in.nextInt();
        long d = in.nextLong();
        a[x] -= d;
        a[y] += d;
    }
    Vector<Integer> v = new Vector<>();
    Vector<Integer> v1 = new Vector<>();
    for (int i = 1; i <= n; i++) {
        if (a[i] > 0) {
            v.add(i);
        } else if (a[i] < 0) {
            v1.add(i);
        }
    }
    int idx = 0;
    Vector<pair> ans = new Vector<>();
    long rem = 0L;
    if (v.size() > 0)
        rem = a[(int) v.get(0)];
    for (int i = 0; i < v1.size() && idx < v.size(); i++) {
        long can = a[v1.get(i)] * -1L;
        while (idx < v.size() && can > 0L) {
            long have = Math.min(rem, can);
            can -= have;
            rem -= have;
            ans.add(new pair(v1.get(i), v.get(idx), have));
            if (rem == 0) {
                idx++;
                if (idx >= v.size())
                    break;
                rem = a[v.get(idx)];
            }
        }
    }
    pw.println(ans.size());
    for (int i = 0; i < ans.size(); i++) {
        pw.println(ans.get(i));
    }
    ;
    pw.flush();
    pw.close();
}