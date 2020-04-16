public void solve() {
    n = cin.nextInt();
    m = cin.nextInt();
    init();
    int x, y, ans = 0;
    for (int i = 0; i < m; i++) {
        x = cin.nextInt();
        y = cin.nextInt();
        insert(x, y);
        insert(y, x);
    }
    k = 0;
    for (int i = 1; i <= n; i++) {
        if (!use[i]) {
            a[k] = new wf();
            a[k].x = i;
            a[k].y = i;
            a[k].use = false;
            dfs(i);
            k++;
        }
    }
    int i, j = 1;
    for (i = 1; i <= n; i++) {
        if (a[idx[i]].use) {
            continue;
        }
        a[idx[i]].use = true;
        y = a[idx[i]].y;
        while (j <= y && j <= n) {
            if (!a[idx[j]].use) {
                ans++;
                a[idx[j]].use = true;
            }
            if (a[idx[j]].y > y) {
                y = a[idx[j]].y;
            }
            j++;
        }
        i = j - 1;
    }
    System.out.println(ans);
}