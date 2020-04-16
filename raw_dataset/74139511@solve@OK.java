public void solve(int testNumber, InputReader in, PrintWriter out) {
    int t = in.nextInt();
    while (t > 0) {
        t--;
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            for (int j = 0; j < k; j++) g.get(i).add(in.nextInt() - 1);
        }
        boolean[] used = new boolean[n];
        int d = -1;
        int c = 0;
        for (int i = 0; i < n; i++) {
            boolean f = false;
            for (int j = 0, sz = g.get(i).size(); j < sz; j++) {
                int h = g.get(i).get(j);
                if (!used[h]) {
                    used[h] = true;
                    c++;
                    f = true;
                    break;
                }
            }
            if (!f && d == -1)
                d = i;
        }
        if (c == n)
            out.println("OPTIMAL");
        else {
            out.println("IMPROVE");
            if (d != -1) {
                for (int i = 0; i < n; i++) if (!used[i]) {
                    out.println((d + 1) + " " + (i + 1));
                    break;
                }
            } else
                out.println("1 1");
        }
    }
}