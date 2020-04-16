public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    final int N = 200002;
    DisjointSet ds = new DisjointSet(200002);
    int[] mn = new int[N];
    int[] mx = new int[N];
    for (int i = 1; i <= n; ++i) {
        mn[i] = mx[i] = i;
    }
    for (int i = 0; i < m; ++i) {
        int a = in.nextInt();
        int b = in.nextInt();
        int da = ds.find(a);
        int db = ds.find(b);
        if (da != db) {
            ds.union(da, db);
            mn[da] = Math.min(mn[da], a);
            mn[da] = Math.min(mn[da], b);
            mn[da] = Math.min(mn[da], mn[db]);
            mx[da] = Math.max(mx[da], a);
            mx[da] = Math.max(mx[da], b);
            mx[da] = Math.max(mx[da], mx[db]);
        }
    }
    Vector<Segment> segments = new Vector<>();
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 1; i <= n; ++i) {
        int da = ds.find(i);
        if (!set.contains(da)) {
            set.add(da);
            segments.add(new Segment(mn[da], mx[da]));
        }
    }
    Collections.sort(segments, new Comparator<Segment>() {

        public int compare(Segment o1, Segment o2) {
            if (o1.a != o2.a)
                return o1.a - o2.a;
            else
                return o1.b - o2.b;
        }
    });
    int result = 0;
    Segment last = null;
    for (Segment seg : segments) {
        // out.println(seg.a+" "+seg.b);
        if (last == null) {
            last = seg;
        } else {
            if (seg.a < last.b) {
                result++;
                if (seg.b > last.b) {
                    last = seg;
                } else {
                }
            } else {
                last = seg;
            }
        }
    }
    out.println(result);
}