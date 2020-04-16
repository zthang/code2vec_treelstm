private static void solve(int n, int m, int[] weights) {
    if (m < n || n == 2) {
        System.out.println(-1);
    } else {
        int cost = 0;
        for (int i = 0; i < n; ++i) {
            cost += weights[i] * 2;
        }
        System.out.println(cost);
        System.out.println("1 2");
        System.out.println("1 " + n);
        for (int i = 2; i < n; i++) {
            System.out.println(i + " " + (i + 1));
        }
    }
}