void solve(IO io, PrintWriter out) {
    int t = io.nextInt();
    while (t-- > 0) {
        int n = io.nextInt();
        boolean[] one = new boolean[n + 1];
        boolean[] two = new boolean[n + 1];
        int flag = 0;
        for (int i = 1; i <= n; i++) {
            int k = io.nextInt();
            for (int j = 0; j < k; j++) {
                int tmp = io.nextInt();
                if (one[i] || two[tmp])
                    continue;
                else {
                    one[i] = true;
                    two[tmp] = true;
                    flag++;
                }
            }
        }
        if (flag == n)
            out.println("OPTIMAL");
        else {
            int a = 0, b = 0;
            for (int i = 1; i <= n; i++) {
                if (!one[i])
                    a = i;
            }
            for (int i = 1; i <= n; i++) {
                if (!two[i])
                    b = i;
            }
            out.println("IMPROVE\n" + a + " " + b);
        }
    }
}