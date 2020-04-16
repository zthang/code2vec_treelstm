void solveMain() {
    int n = in.nextInt(), m = in.nextInt();
    int[][] a = new int[n][2];
    for (int i = 0; i < n; i++) {
        a[i][0] = i;
        a[i][1] = in.nextInt();
    }
    if (n > m || n == 2) {
        out.println("-1");
        return;
    }
    Arrays.sort(a, (e1, e2) -> Integer.compare(e1[1], e2[1]));
    long sum = 0;
    ArrayList<int[]> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        sum += a[i][1] * 2;
        ans.add(new int[] { i + 1, ((i + 1) % n) + 1 });
    }
    long d = m - n;
    sum += d * (a[0][1] + a[1][1]);
    out.println(sum);
    for (int[] e : ans) out.println(e[0] + " " + e[1]);
    for (int i = 0; i < d; i++) out.println((a[0][0] + 1) + " " + (a[1][0] + 1));
}