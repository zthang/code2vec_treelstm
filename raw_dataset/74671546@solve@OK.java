public void solve(int testNumber, InputReader in, PrintWriter out) {
    int ntests = in.nextInt();
    for (int i = 0; i < ntests; i++) {
        int n = in.nextInt();
        boolean[] d = new boolean[n];
        boolean[] ki = new boolean[n];
        for (int j = 0; j < n; j++) {
            int k = in.nextInt();
            for (int l = 0; l < k; l++) {
                int a = in.nextInt() - 1;
                if (d[j] || ki[a])
                    continue;
                ki[a] = d[j] = true;
            }
        }
        int freed = -1;
        for (int j = 0; j < n; j++) {
            if (!d[j]) {
                freed = j;
                break;
            }
        }
        int freek = -1;
        for (int j = 0; j < n; j++) {
            if (!ki[j]) {
                freek = j;
                break;
            }
        }
        if (freed == -1) {
            assert freed == -1;
            out.println("OPTIMAL");
            continue;
        }
        out.println("IMPROVE");
        out.println((freed + 1) + " " + (freek + 1));
    }
}