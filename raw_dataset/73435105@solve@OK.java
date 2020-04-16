public static void solve(InputReader sc, PrintWriter pw) {
    int i, j = 0;
    int t = 1;
    // int t=sc.nextInt();
    u: while (t-- > 0) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] p = new long[n];
        for (i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();
            p[a - 1] -= c;
            p[b - 1] += c;
        }
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        for (i = 0; i < n; i++) {
            if (p[i] > 0)
                a2.add(i);
            else
                a1.add(i);
        }
        int r1 = 0, r2 = 0;
        ArrayList<String> l = new ArrayList<>();
        while (r1 < a1.size() && r2 < a2.size()) {
            int s1 = a1.get(r1);
            int s2 = a2.get(r2);
            long min = Math.min(-1 * p[s1], p[s2]);
            p[s1] += min;
            p[s2] -= min;
            if (min > 0)
                l.add((s1 + 1) + " " + (s2 + 1) + " " + min);
            // System.out.println(r1+" "+r2);
            if (p[s1] == 0)
                r1++;
            if (p[s2] == 0)
                r2++;
        }
        pw.println(l.size());
        for (String si : l) {
            pw.println(si);
        }
    }
}