public static long fn(int[][] reb, int a, int b, int n, int x, int k) {
    long ans = 0;
    int m = reb.length;
    mas = new int[n];
    for (int j = 0; j < n; j++) {
        mas[j] = j;
    }
    for (int j = 0; j < m; j++) {
        int u = reb[j][0];
        int v = reb[j][1];
        if (u != a && u != b && v != a && v != b) {
            ob(u, v);
        }
    }
    long[] fn = new long[n];
    for (int j = 0; j < n; j++) {
        fn[get(j)]++;
    }
    fn[get(x)]--;
    fn[get(a)]--;
    long s = n - 2;
    if (k == 1) {
        for (int i = 0; i < n; i++) {
            if (i != x && get(i) == get(x))
                ch[i]++;
        }
    } else {
        long[] fk = new long[n];
        long sm = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 2) {
                fk[get(i)]++;
                sm++;
            }
        }
        long p = 0;
        for (int i = 0; i < n; i++) {
            p += (sm - fk[i]) * fk[i];
        }
        ans -= p;
    }
    for (int j = 0; j < n; j++) {
        // if (j == a || j == b || j == x) continue;
        ans += (s - fn[j]) * fn[j];
    }
    return ans / 2;
}