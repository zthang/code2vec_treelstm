void solve() {
    int Q = ni();
    while (Q-- > 0) {
        int N = ni();
        char[] a = ns().toCharArray();
        int min = 0;
        int max = 0;
        int[] res = new int[N];
        for (int i = 1; i < N; i++) {
            if (a[i - 1] == '<') {
                int cnt = 0;
                for (int j = i; j < N && a[j - 1] == '<'; j++) cnt++;
                min -= cnt;
                for (int j = 0; j <= cnt; j++) res[i + j - 1] = min + j;
                i += cnt - 1;
            } else
                res[i] = --min;
        }
        print(min, res);
        res = new int[N];
        min = 0;
        max = 0;
        for (int i = 1; i < N; i++) {
            if (a[i - 1] == '<')
                res[i] = ++max;
            else
                res[i] = --min;
        }
        // tr(N, res);
        print(min, res);
    }
}