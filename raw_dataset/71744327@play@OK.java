void play(int n, int m, int k) {
    for (int i = 0; i < n - 1; i++) {
        int x = 3 * (m - 1);
        if (k >= x) {
            a.add(new pair(m - 1, "RDU"));
            k -= x;
        } else {
            int y = k / 3;
            if (y > 0)
                a.add(new pair(y, "RDU"));
            k -= y * 3;
            if (k > 0) {
                a.add(new pair(1, "R"));
                k--;
            }
            if (k > 0) {
                a.add(new pair(1, "D"));
                k--;
            }
            return;
        }
        if (k == 0)
            return;
        x = m - 1;
        if (k >= x) {
            a.add(new pair(m - 1, "L"));
            k -= x;
        } else {
            a.add(new pair(k, "L"));
            return;
        }
        if (k > 0) {
            a.add(new pair(1, "D"));
            k--;
        }
        if (k == 0)
            return;
    }
    int x = m - 1;
    if (k >= x) {
        a.add(new pair(m - 1, "R"));
        k -= x;
    } else {
        a.add(new pair(k, "R"));
        return;
    }
    if (k == 0)
        return;
    if (k >= x) {
        a.add(new pair(m - 1, "L"));
        k -= x;
    } else {
        a.add(new pair(k, "L"));
        return;
    }
    if (k == 0)
        return;
    x = n - 1;
    if (k >= x && x > 0) {
        a.add(new pair(n - 1, "U"));
        k -= x;
    } else if (n > 1) {
        a.add(new pair(k, "U"));
        return;
    }
}