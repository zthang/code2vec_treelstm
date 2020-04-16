private static void solve() throws IOException {
    int n = enter.nextInt();
    d = new pair[n];
    ans = new int[2 * n];
    vert = new LinkedList[2 * n];
    for (int i = 0; i < 2 * n; i++) {
        vert[i] = new LinkedList<>();
    }
    for (int i = 0; i < n; i++) {
        d[i] = new pair(enter.nextInt(), i);
    }
    Arrays.sort(d, pair::compareTo);
    ans[0] = d[0].order * 2 + 1;
    ans[d[0].dist] = d[0].order * 2 + 2;
    int last = d[0].dist;
    for (int i = 1; i < last; i++) {
        ans[i] = d[i].order * 2 + 1;
        if (i + d[i].dist <= last) {
            vert[i + d[i].dist - 1].addLast(d[i].order * 2 + 2);
        } else {
            if (ans[i + d[i].dist] == 0) {
                ans[i + d[i].dist] = d[i].order * 2 + 2;
            } else {
                vert[i + d[i].dist - 1].add(d[i].order * 2 + 2);
            }
        }
    }
    int last2 = 2 * n;
    for (int i = 0; i < 2 * n; i++) {
        if (ans[i] == 0) {
            last2 = i;
            break;
        }
    }
    for (int i = last; i < n; i++, last2++) {
        ans[last2] = d[i].order * 2 + 1;
        vert[last2 - d[i].dist + 1].addLast(d[i].order * 2 + 2);
    }
    last = last2;
    for (int v : vert[0]) {
        out.println(v + " " + ans[0]);
    }
    for (int i = 1; i < last; i++) {
        for (int v : vert[i]) {
            out.println(v + " " + ans[i]);
        }
        out.println(ans[i] + " " + ans[i - 1]);
    }
}