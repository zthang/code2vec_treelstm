static void sol(int i) {
    // System.out.println(i+" i");
    if (i == 0) {
        if (ff) {
            sol(i + 1);
        }
    } else if (i == n) {
        sb = new StringBuilder();
        for (int l : ans) sb.append(l + "");
        c++;
        // System.out.println(c);
        sq.add(sb);
        if (c == k)
            ff = false;
    } else {
        for (int y = 0; y < np[i].size(); y++) {
            ans[np[i].get(y)] = 1;
            if (ff) {
                sol(i + 1);
                ans[np[i].get(y)] = 0;
            }
            if (!ff)
                return;
        }
    }
}