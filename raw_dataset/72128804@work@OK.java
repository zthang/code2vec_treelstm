void work() {
    int n = ni(), m = ni(), s = ni();
    if (4 * n * m - 2 * n - 2 * m < s) {
        out.println("NO");
        return;
    }
    out.println("YES");
    ArrayList<String> list = new ArrayList();
    for (int j = 1; s > 0 && j < m; j++) {
        if (s > 0) {
            list.add(1 + " " + "R");
            s--;
        }
        if (n - 1 < s) {
            if (n - 1 > 0)
                list.add((n - 1) + " " + "D");
            s -= n - 1;
        } else {
            if (s > 0)
                list.add(s + " " + "D");
            s = 0;
        }
        if (n - 1 < s) {
            if (n - 1 > 0)
                list.add((n - 1) + " " + "U");
            s -= n - 1;
        } else {
            if (s > 0)
                list.add(s + " " + "U");
            s = 0;
        }
    }
    if (m - 1 < s) {
        if (m - 1 > 0)
            list.add((m - 1) + " " + "L");
        s -= m - 1;
    } else {
        if (s > 0)
            list.add(s + " " + "L");
        s = 0;
    }
    for (int i = 1; i < n && s > 0; i++) {
        if (s > 0) {
            list.add(1 + " " + "D");
            s--;
        }
        if (m - 1 < s) {
            if (m - 1 > 0)
                list.add((m - 1) + " " + "R");
            s -= m - 1;
        } else {
            if (s > 0)
                list.add(s + " " + "R");
            s = 0;
        }
        if (m - 1 < s) {
            if (m - 1 > 0)
                list.add((m - 1) + " " + "L");
            s -= m - 1;
        } else {
            if (s > 0)
                list.add(s + " " + "L");
            s = 0;
        }
    }
    if (n - 1 < s) {
        if ((n - 1) > 0)
            list.add((n - 1) + " " + "U");
        s -= n - 1;
    } else {
        if (s > 0)
            list.add(s + " " + "U");
        s = 0;
    }
    out.println(list.size());
    for (String str : list) {
        out.println(str);
    }
}