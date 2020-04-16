static void MainSolution() {
    t = ni();
    here: while (t-- > 0) {
        n = ni();
        m = ni();
        if (n == 2 || m < n) {
            for (int i = 0; i < n; i++) ni();
            pl(-1);
            continue here;
        }
        ArrayList<pair> ar = new ArrayList<>();
        for (int i = 1; i <= n; i++) ar.add(new pair(ni(), i));
        ar.sort(new Comparator<pair>() {

            @Override
            public int compare(pair o1, pair o2) {
                return o1.a - o2.a;
            }
        });
        ar.add(ar.get(0));
        int ans = 0;
        for (int i = 0; i < n; i++) ans += ar.get(i).a + ar.get(i + 1).a;
        ans += (ar.get(0).a + ar.get(1).a) * (m - n);
        pl(ans);
        for (int i = 0; i < n; i++) pl(ar.get(i).b + " " + ar.get(i + 1).b);
        for (int i = 0; i < m - n; i++) pl(ar.get(0).b + " " + ar.get(1).b);
    // pl(ar);
    }
}