public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    int m = in.readInt();
    Node[] people = new Node[n + 1];
    Node[] cats = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
        people[i] = new Node();
        cats[i] = new Node();
        people[i].opposite = cats[i];
        cats[i].opposite = people[i];
    }
    for (int i = 1; i <= m; i++) {
        Node a = people[in.readInt()];
        Node b = cats[in.readInt()];
        a.next.add(b);
        b.next.add(a);
    }
    dfs(people[1], 0);
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        if (people[i].visited) {
            cnt++;
        }
    }
    if (cnt < n) {
        out.println("Yes");
        out.append(cnt).append(' ').append(n - cnt).append('\n');
        for (int i = 1; i <= n; i++) {
            if (people[i].visited) {
                out.append(i).append(' ');
            }
        }
        out.println();
        for (int i = 1; i <= n; i++) {
            if (!people[i].visited) {
                out.append(i).append(' ');
            }
        }
        out.println();
        return;
    }
    for (int i = 1; i <= n; i++) {
        people[i].visited = cats[i].visited = false;
    }
    dfs(cats[1], 0);
    cnt = 0;
    for (int i = 1; i <= n; i++) {
        if (cats[i].visited) {
            cnt++;
        }
    }
    if (cnt == n) {
        out.println("No");
        return;
    }
    out.println("Yes");
    out.append(n - cnt).append(' ').append(cnt).append('\n');
    for (int i = 1; i <= n; i++) {
        if (!cats[i].visited) {
            out.append(i).append(' ');
        }
    }
    out.println();
    for (int i = 1; i <= n; i++) {
        if (cats[i].visited) {
            out.append(i).append(' ');
        }
    }
    out.println();
    return;
}