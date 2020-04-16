static void solve() {
    n = in.nextInt();
    a = new int[n][2];
    for (int i = 0; i < n; i++) {
        a[i][0] = in.nextInt();
        a[i][1] = in.nextInt();
    }
    Arrays.sort(a, (o1, o2) -> Integer.compare(o1[0], o2[0]));
    lol = new int[n];
    pq = new PriorityQueue<>((o1, o2) -> Integer.compare(a[o1][1], a[o2][1]));
    for (int i = 0; i < n; i++) {
        while (!pq.isEmpty() && a[pq.peek()][1] < a[i][0]) {
            pq.poll();
        }
        if (pq.size() == 1) {
            lol[pq.peek()]++;
        }
        if (pq.isEmpty()) {
            lol[i]--;
        }
        pq.add(i);
    }
    int best = -1;
    for (int i = 0; i < n; i++) {
        if (best == -1 || lol[i] > lol[best]) {
            best = i;
        }
    }
    // out.println(best);
    int ans = 0, max = -INF;
    for (int i = 0; i < n; i++) {
        if (i == best)
            continue;
        if (a[i][0] > max) {
            ans++;
        }
        max = Math.max(max, a[i][1]);
    }
    out.println(ans);
}