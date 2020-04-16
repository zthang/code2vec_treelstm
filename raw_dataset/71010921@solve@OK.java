void solve() {
    int n = scn.nextInt(), m = scn.nextInt(), k = scn.nextInt();
    if (k > 4 * n * m - 2 * n - 2 * m) {
        out.println("NO");
        return;
    }
    out.println("YES");
    ArrayList<String> ls = new ArrayList<String>();
    int y = 0, x = 0;
    int step = 1;
    while (k > 0) {
        if (step == 1) {
            if (k > n - 1) {
                if (n - 1 > 0)
                    ls.add(n - 1 + " D");
                k -= n - 1;
            } else {
                if (k > 0)
                    ls.add(k + " D");
                k = 0;
                break;
            }
            if (k > n - 1) {
                if (n - 1 > 0)
                    ls.add(n - 1 + " U");
                k -= n - 1;
            } else {
                if (k > 0)
                    ls.add(k + " U");
                k = 0;
                break;
            }
            if (k > 0) {
                ls.add("1 R");
                y++;
                k--;
            }
            if (y == m - 1) {
                step = 2;
            }
            if (k == 0) {
                break;
            }
        } else if (step == 2) {
            if (k > n - 1) {
                if (n - 1 > 0)
                    ls.add(n - 1 + " D");
                k -= n - 1;
            } else {
                if (k > 0)
                    ls.add(k + " D");
                k = 0;
                break;
            }
            step = 3;
            x = n - 1;
        } else if (step == 3) {
            if (k > m - 1) {
                if (m - 1 > 0)
                    ls.add(m - 1 + " L");
                k -= m - 1;
            } else {
                if (k > 0)
                    ls.add(k + " L");
                k = 0;
                break;
            }
            if (k > m - 1) {
                if (m - 1 > 0)
                    ls.add(m - 1 + " R");
                k -= m - 1;
            } else {
                if (k > 0)
                    ls.add(k + " R");
                k = 0;
                break;
            }
            if (k > 0) {
                ls.add("1 U");
                k--;
                x--;
            }
            if (x == 0) {
                step = 4;
            }
            if (k == 0) {
                break;
            }
        } else if (step == 4) {
            if (k > m - 1) {
                if (m - 1 > 0)
                    ls.add(m - 1 + " L");
                k -= m - 1;
            } else {
                if (k > 0)
                    ls.add(k + " L");
                k = 0;
                break;
            }
        }
    }
    out.println(ls.size());
    for (String s : ls) {
        out.println(s);
    }
}