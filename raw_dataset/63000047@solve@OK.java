public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int numTests = in.nextInt();
    for (int test = 0; test < numTests; test++) {
        int n = in.nextInt();
        int m = in.nextInt();
        SCCGraph g = new SCCGraph(n);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            g.addEdge(a, b);
        }
        g.findSCC();
        if (g.numComps == 1) {
            out.println("No");
            continue;
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (g.comp[i] == 0) {
                ++k;
            }
        }
        out.println("Yes");
        out.println(k + " " + (n - k));
        for (int step = 0; step < 2; step++) {
            for (int i = 0; i < n; i++) {
                if ((g.comp[i] == 0) == (step == 0)) {
                    out.print((i + 1) + " ");
                }
            }
            out.println();
        }
    }
}