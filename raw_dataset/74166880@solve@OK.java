public static void solve(InputReader in, PrintWriter out) {
    int t = in.nextInt();
    for (int i = 0; i < t; ++i) {
        int n = in.nextInt();
        Set<Integer> set = new HashSet<>(n);
        int nonMarriedDaughter = -1;
        for (int j = 0; j < n; ++j) {
            int k = in.nextInt();
            boolean married = false;
            for (int jj = 0; jj < k; ++jj) {
                int current = in.nextInt();
                if (!set.contains(current)) {
                    married = true;
                    set.add(current);
                    in.skip();
                    break;
                }
            }
            if (!married && nonMarriedDaughter == -1) {
                nonMarriedDaughter = j;
            }
        }
        if (nonMarriedDaughter == -1) {
            System.out.println("OPTIMAL");
        } else {
            System.out.println("IMPROVE");
            for (int j = 1; j <= n; ++j) {
                if (!set.contains(j)) {
                    System.out.print(nonMarriedDaughter + 1);
                    System.out.print(" ");
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}