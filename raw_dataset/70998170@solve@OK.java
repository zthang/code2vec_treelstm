public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt(), m = s.nextInt(), k = s.nextInt();
    if (k > 4 * n * m - 2 * n - 2 * m) {
        w.println("NO");
        return;
    }
    w.println("YES");
    if (n == 1) {
        m--;
        if (k <= m) {
            w.println(1);
            w.println(k + " R");
            return;
        } else {
            w.println(2);
            w.println(m + " R");
            w.println((k - m) + " L");
            return;
        }
    }
    if (m == 1) {
        n--;
        if (k <= n) {
            w.println(1);
            w.println(k + " D");
            return;
        } else {
            w.println(2);
            w.println(n + " D");
            w.println((k - n) + " U");
            return;
        }
    }
    ArrayList<pair> ans = new ArrayList<>();
    int tot = 3 * (m - 1);
    for (int i = 0; i < n; i++) {
        if (i != n - 1) {
            if (k <= tot) {
                int req = k / 3, rem = k % 3;
                if (req > 0)
                    ans.add(new pair(req, "RDU"));
                if (rem == 1) {
                    ans.add(new pair(1, "R"));
                } else if (rem == 2) {
                    ans.add(new pair(1, "RD"));
                }
                break;
            }
            ans.add(new pair(m - 1, "RDU"));
            k -= tot;
            if (k <= m - 1) {
                ans.add(new pair(k, "L"));
                break;
            }
            ans.add(new pair(m - 1, "L"));
            k -= m - 1;
            ans.add(new pair(1, "D"));
            k--;
            if (k == 0)
                break;
        } else {
            if (k <= m - 1) {
                ans.add(new pair(k, "R"));
                break;
            }
            ans.add(new pair(m - 1, "R"));
            k -= m - 1;
            if (k <= m - 1) {
                ans.add(new pair(k, "L"));
                break;
            }
            ans.add(new pair(m - 1, "L"));
            k -= m - 1;
            if (k > 0) {
                ans.add(new pair(k, "U"));
            }
        }
    }
    w.println(ans.size());
    for (pair p : ans) w.println(p.x + " " + p.s);
}