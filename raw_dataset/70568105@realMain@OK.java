public void realMain() throws Exception {
    BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);
    String in = fin.readLine();
    String[] ar = in.split(" ");
    n = Integer.parseInt(ar[0]);
    nodes = new ArrayList<Node>();
    ArrayList<Point> points = new ArrayList<Point>();
    for (int i = 0; i < n; i++) {
        int ret = 0;
        boolean dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        int left = ret;
        ret = 0;
        dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        points.add(new Point(true, i, left, ret));
        points.add(new Point(false, i, ret, left));
        nodes.add(new Node(i));
    }
    int numedges = 0;
    Collections.sort(points);
    TreeSet<Pair> openintervals = new TreeSet<Pair>();
    for (Point p : points) {
        if (!p.isleft) {
            Pair pair = new Pair(p.value, p.lineid);
            openintervals.remove(pair);
        // System.err.println("tried to remove " + p.value + ", " + p.lineid + ": " + openintervals.remove(pair));
        } else {
            Pair pair = new Pair(p.othervalue, p.lineid);
            openintervals.add(pair);
            // System.err.println(openintervals);
            for (Pair pair2 : openintervals) {
                if (p.othervalue > pair2.value) {
                    nodes.get(p.lineid).neighbors.add(pair2.lineid);
                    nodes.get(pair2.lineid).neighbors.add(p.lineid);
                    numedges++;
                } else {
                    break;
                }
            }
        }
        if (numedges > n - 1) {
            System.out.println("NO");
            return;
        }
    }
    if (numedges != n - 1) {
        System.out.println("NO");
        return;
    }
    visited = new boolean[n];
    dfs(0);
    boolean yes = true;
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            yes = false;
        }
    }
    if (yes) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }
}