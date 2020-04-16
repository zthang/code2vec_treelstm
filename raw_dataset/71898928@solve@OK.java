public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    if (k > 4 * n * m - 2 * n - 2 * m) {
        out.println("NO");
        return;
    }
    m--;
    n--;
    ArrayList<String> ans = new ArrayList<>();
    if (k >= m) {
        k -= m;
        for (int i = 0; i < m; i++) ans.add("R");
    } else {
        for (int i = 0; i < k; i++) ans.add("R");
        k = 0;
    }
    if (k >= m) {
        k -= m;
        for (int i = 0; i < m; i++) ans.add("L");
    } else {
        for (int i = 0; i < k; i++) ans.add("L");
        k = 0;
    }
    if (k > 0) {
        k--;
        ans.add("D");
    }
    for (int i = 1; i <= n; i++) {
        if (k >= m) {
            k -= m;
            for (int j = 0; j < m; j++) ans.add("R");
        } else {
            for (int j = 0; j < k; j++) ans.add("R");
            k = 0;
        }
        if (k == 0) {
            break;
        }
        for (int j = 0; j < m; j++) {
            if (k >= 3) {
                ans.add("UDL");
                k -= 3;
            } else if (k >= 2) {
                ans.add("UD");
                k -= 2;
            } else if (k >= 1) {
                ans.add("U");
                k -= 1;
            } else {
                break;
            }
        }
        if (k > 0 && i != n) {
            k--;
            ans.add("D");
        } else {
            break;
        }
    }
    if (k >= n) {
        k -= n;
        for (int i = 0; i < n; i++) ans.add("U");
    } else {
        for (int i = 0; i < k; i++) ans.add("U");
        k = 0;
    }
    int count = 0;
    int c = 0;
    StringBuffer an = new StringBuffer();
    for (int i = 0; i < ans.size() - 1; i++) {
        c = 0;
        while (i < ans.size() - 1 && ans.get(i) == ans.get(i + 1)) {
            c++;
            i++;
        }
        c++;
        an.append(c + " " + ans.get(i));
        an.append(System.getProperty("line.separator"));
        count++;
    }
    if (ans.size() >= 2 && ans.get(ans.size() - 1) != ans.get(ans.size() - 2)) {
        an.append(1 + " " + ans.get(ans.size() - 1));
        an.append(System.getProperty("line.separator"));
        count++;
    }
    if (ans.size() == 1) {
        an.append(1 + " " + ans.get(0));
        an.append(System.getProperty("line.separator"));
        count++;
    }
    out.println("YES");
    out.println(count);
    out.println(an);
}