public void run() {
    InputReader sc = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int t = sc.nextInt();
    while (t-- > 0) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Pair[] p = new Pair[n + 1];
        p[0] = new Pair(-1, 1, 1);
        for (int i = 1; i <= n; i++) {
            p[i] = new Pair(sc.nextLong(), i, 1);
        }
        Arrays.parallelSort(p);
        if (n != 2 && m >= n) {
            long cost = 0;
            ArrayList<Pair> ans = new ArrayList();
            for (int i = 2; i < p.length; i++) {
                cost += p[i].a + p[i - 1].a;
                ans.add(new Pair(p[i].b, p[i - 1].b, 1));
            }
            ans.add(new Pair(p[p.length - 1].b, p[1].b, 1));
            cost += p[p.length - 1].a + p[1].a;
            m = m - n;
            for (int i = 0; i < m; i++) {
                cost += p[1].a + p[2].a;
                ans.add(new Pair(p[1].b, p[2].b, 1));
            }
            w.println(cost);
            for (int i = 0; i < ans.size(); i++) {
                w.println(ans.get(i).a + " " + ans.get(i).b);
            }
        } else {
            w.println("-1");
        }
    }
    w.close();
}