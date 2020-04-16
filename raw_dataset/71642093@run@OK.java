private void run() {
    Scanner cin = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = cin.nextInt();
    int m = cin.nextInt();
    int k = cin.nextInt();
    a = new int[k];
    for (int i = 0; i < k; i++) {
        a[i] = cin.nextInt();
    }
    path = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
        path[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int x = cin.nextInt();
        int y = cin.nextInt();
        path[x].add(y);
        path[y].add(x);
    }
    int[] distFrom1 = getDist(1, n);
    int[] distFromN = getDist(n, n);
    Point[] points = new Point[k];
    for (int i = 0; i < k; i++) {
        int x = a[i];
        points[i] = new Point(distFrom1[x], distFromN[x]);
    }
    Arrays.sort(points);
    int[] maxY = new int[k + 1];
    for (int i = k - 1; i >= 0; i--) {
        maxY[i] = Math.max(maxY[i + 1], points[i].y);
    }
    int ans = 0;
    for (int i = 0; i < k - 1; i++) {
        ans = Math.max(points[i].x + maxY[i + 1], ans);
    }
    if (distFrom1[n] > 0) {
        out.println(Math.min(ans + 1, distFrom1[n]));
    } else {
        out.println(ans + 1);
    }
    out.close();
}