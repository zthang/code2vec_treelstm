void solve(InputReader in, PrintWriter out) throws IOException {
    int n = in.nextInt();
    int[] p = new int[n];
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
        p[i] = in.nextInt() - 1;
    }
    for (int i = 0; i < n; i++) {
        c[i] = in.nextInt();
    }
    boolean[] vis = new boolean[n];
    boolean f = false;
    int min = n;
    for (int i = 0; i < n; i++) {
        if (vis[i])
            continue;
        int j = i;
        boolean alle = true;
        int[] l = new int[n];
        int y = 0;
        while (!vis[j]) {
            vis[j] = true;
            l[y++] = c[j];
            alle = alle & (c[j] == c[i]);
            j = p[j];
        }
        if (alle) {
            f = true;
            break;
        }
        min = Math.min(min, go(Arrays.copyOf(l, y)));
    }
    if (f) {
        out.println(1);
    } else {
        out.println(min);
    }
}