public static void SolveC() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    Integer[] a = new Integer[n];
    for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
    }
    Arrays.sort(a);
    int mc = 0;
    long total = 0L;
    long[] adds = new long[m];
    long[] ans = new long[n];
    for (int i = 0; i < n; i++) {
        adds[mc] += a[i];
        total += adds[mc];
        ans[i] = total;
        mc++;
        if (mc >= m) {
            mc = 0;
        }
    }
    for (int i = 0; i < n; i++) System.out.print(ans[i] + " ");
    System.out.println();
    System.exit(0);
}