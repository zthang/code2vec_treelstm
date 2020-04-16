public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt();
    Point[] p = new Point[n];
    for (int i = 0; i < n; i++) {
        p[i] = new Point(c.readInt(), c.readInt(), i);
    }
    for (int i = 0; i < n; i++) {
        p[i].c = c.readInt();
        p[i].xc = p[i].c;
    }
    for (int i = 0; i < n; i++) {
        p[i].k = c.readInt();
    }
    PriorityQueue<Point> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
        pq.add(p[i]);
    }
    Point[] ar = new Point[n];
    while (!pq.isEmpty()) {
        Point p1 = pq.poll();
        ar[p1.ind] = p1;
        PriorityQueue<Point> temp = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Point p2 = pq.poll();
            if (p2.xc > con(p1, p2)) {
                p2.cost = false;
                p2.l = p1.ind;
                p2.r = p2.ind;
                p2.xc = con(p1, p2);
            }
            temp.add(p2);
        }
        pq = temp;
    }
    int cnt = 0, cnt2 = 0;
    long totCost = 0;
    for (Point d : ar) {
        if (d.cost) {
            cnt++;
        } else {
            cnt2++;
        }
        totCost += d.xc;
    }
    w.printLine(totCost);
    w.printLine(cnt);
    for (Point d : ar) {
        if (d.cost) {
            w.print(d.ind + 1 + " ");
        }
    }
    w.printLine();
    w.printLine(cnt2);
    for (Point d : ar) {
        if (!d.cost) {
            w.printLine(d.l + 1 + " " + (d.r + 1));
        }
    }
}