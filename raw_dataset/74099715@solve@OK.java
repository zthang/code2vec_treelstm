public static void solve(Scanner in) {
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        boolean[] married = new boolean[n];
        boolean[] princeTaken = new boolean[n];
        int unMarried = n;
        boolean isMarried = false;
        for (int i = 0; i < n; i++) {
            // ith daughter
            isMarried = false;
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                // k and princes list (for each daughter)
                int temp = in.nextInt();
                if (princeTaken[temp - 1] != true && !isMarried) {
                    princeTaken[temp - 1] = true;
                    married[i] = true;
                    unMarried--;
                    isMarried = true;
                }
            }
        }
        if (unMarried == 0) {
            System.out.println("OPTIMAL");
        } else {
            System.out.println("IMPROVE");
            for (int i = 0; i < n; i++) {
                if (married[i] == false) {
                    System.out.print(i + 1 + " ");
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (princeTaken[i] == false) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}