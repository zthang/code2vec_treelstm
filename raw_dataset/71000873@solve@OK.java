void solve() throws IOException {
    int n = ni(), m = ni(), k = ni();
    if (k > 4 * n * m - 2 * n - 2 * m) {
        System.out.println("NO");
        return;
    }
    if (m == 1) {
        if (k > n - 1) {
            System.out.println("YES");
            System.out.println(2);
            System.out.println((n - 1) + " D");
            System.out.println((k - n + 1) + " U");
        } else {
            System.out.println("YES");
            System.out.println(1);
            System.out.println(k + " D");
        }
        return;
    }
    StringBuilder A = new StringBuilder();
    int ans = 0;
    outer: while (true) {
        for (int x = 1; x < n; x++) {
            if (k >= m - 1) {
                A.append(m - 1);
                A.append(" R\n");
                ans++;
                k = k - m + 1;
            } else {
                A.append(k);
                A.append(" R\n");
                ans++;
                k = 0;
            }
            if (k == 0)
                break outer;
            if (k >= (m - 1) * 3) {
                A.append(m - 1);
                A.append(" DUL\n");
                ans++;
                k = k - (m - 1) * 3;
            } else {
                if (k / 3 > 0) {
                    A.append(k / 3);
                    A.append(" DUL\n");
                    ans++;
                }
                if (k % 3 == 1) {
                    A.append("1 D\n");
                    ans++;
                }
                if (k % 3 == 2) {
                    A.append("1 DU\n");
                    ans++;
                }
                k = 0;
            }
            if (k == 0)
                break outer;
            A.append("1 D\n");
            ans++;
            k--;
            if (k == 0)
                break outer;
        }
        if (k >= m - 1) {
            A.append(m - 1);
            A.append(" R\n");
            ans++;
            k = k - m + 1;
        } else {
            A.append(k);
            A.append(" R\n");
            ans++;
            k = 0;
        }
        if (k == 0)
            break outer;
        if (k >= m - 1) {
            A.append(m - 1);
            A.append(" L\n");
            ans++;
            k = k - m + 1;
        } else {
            A.append(k);
            A.append(" L\n");
            ans++;
            k = 0;
        }
        if (k == 0)
            break outer;
        if (k >= n - 1) {
            A.append(n - 1);
            A.append(" U\n");
            ans++;
            k = k - n + 1;
        } else {
            A.append(k);
            A.append(" U\n");
            ans++;
            k = 0;
        }
        if (k == 0)
            break outer;
    }
    System.out.println("YES");
    System.out.println(ans);
    System.out.print(A);
}