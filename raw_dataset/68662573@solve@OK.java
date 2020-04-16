void solve() throws IOException {
    scanner = new FastScanner(System.in);
    writer = new PrintWriter(System.out);
    int tests = scanner.nextInt();
    for (int t = 0; t < tests; t++) {
        int n = scanner.nextInt();
        List<Point> pts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            Point openPoint = new Point(l, true);
            Point closePoint = new Point(r, false);
            closePoint.openPoint = openPoint;
            pts.add(openPoint);
            pts.add(closePoint);
        }
        List<Point> lsInit = new ArrayList<>();
        Collections.sort(pts);
        int c = 0;
        for (Point p : pts) {
            if (p.open) {
                c++;
                if (c == 1)
                    lsInit.add(p);
            } else
                c--;
        }
        Set<Point> ls = new HashSet<>();
        for (Point p : pts) {
            if (p.open) {
                if (ls.size() == 1) {
                    Point prevOpen = ls.iterator().next();
                    prevOpen.diff++;
                }
                ls.add(p);
            } else {
                ls.remove(p.openPoint);
            }
        }
        Map<Integer, Integer> cnts = new HashMap<>();
        for (Point l : lsInit) cnts.merge(l.x, 1, Integer::sum);
        for (Point l : lsInit) {
            if (cnts.get(l.x) == 1)
                l.diff--;
        }
        int maxDiff = -1;
        for (Point p : pts) {
            if (p.open && p.diff > maxDiff)
                maxDiff = p.diff;
        }
        writer.println(lsInit.size() + maxDiff);
    }
    writer.close();
}