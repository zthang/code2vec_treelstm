static void solve() {
    FastReader fr = new FastReader();
    PrintWriter op = new PrintWriter(System.out);
    int t = fr.nextInt(), ans[][], n, i, j, k, l, m, ptr;
    String s;
    byte[] a;
    while (t-- > 0) {
        n = fr.nextInt();
        s = fr.next();
        a = new byte[n - 1];
        ans = new int[2][n];
        for (i = 0; i + 1 < n; ++i) a[i] = (s.charAt(i) == '>') ? (byte) 1 : 0;
        i = 0;
        ptr = 1;
        while (i + 1 < n) {
            for (j = i; j + 1 < n; ++j) {
                if (a[j] == 1)
                    break;
            }
            --j;
            k = j;
            while (k + 1 < n - 1 && a[k + 1] == 1) ++k;
            ptr += (k - j);
            if (i == 0)
                ans[0][i] = ptr;
            else
                ans[0][++i] = ptr;
            m = ptr;
            for (l = i; l <= j; ++l) ans[0][l + 1] = ans[0][l] + 1;
            for (; l <= k; ++l) ans[0][l + 1] = --m;
            i = k + 1;
            ptr = ans[0][j + 1] + 1;
        }
        i = 0;
        ptr = n;
        while (i + 1 < n) {
            for (j = i; j + 1 < n; ++j) {
                if (a[j] == 0)
                    break;
            }
            --j;
            k = j;
            while (k + 1 < n - 1 && a[k + 1] == 0) ++k;
            ptr -= (k - j);
            if (i == 0)
                ans[1][i] = ptr;
            else
                ans[1][++i] = ptr;
            m = ptr;
            for (l = i; l <= j; ++l) ans[1][l + 1] = ans[1][l] - 1;
            for (; l <= k; ++l) ans[1][l + 1] = ++m;
            i = k + 1;
            ptr = ans[1][j + 1] - 1;
        }
        for (i = 0; i < n; ++i) op.print(ans[1][i] + " ");
        op.println();
        for (i = 0; i < n; ++i) op.print(ans[0][i] + " ");
        op.println();
    }
    op.flush();
    op.close();
}