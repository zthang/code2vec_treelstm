public static void solve(InputReader sc, PrintWriter pw) {
    int i, j = 0;
    int t = sc.nextInt();
    while (t-- > 0) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        long sum = 0;
        int min = 100000, mini = -1, min2 = 100000, mini2 = -1;
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (min > a[i]) {
                min = a[i];
                mini = i;
            }
            sum += 2 * a[i];
        }
        for (i = 0; i < n; i++) {
            if (mini == i)
                continue;
            if (min2 > a[i]) {
                min2 = a[i];
                mini2 = i;
            }
        // sum+=2*a[i];
        }
        if (m < n || n == 2) {
            pw.println("-1");
            continue;
        }
        sum += (a[mini] + a[mini2]) * (m - n);
        pw.println(sum);
        // Arrays.sort(a);
        for (i = 0; i < n; i++) {
            pw.println((i + 1) + " " + ((i == n - 1) ? 1 : i + 2));
        }
        for (i = 0; i < m - n; i++) {
            pw.println((mini + 1) + " " + (mini2 + 1));
        }
    }
}