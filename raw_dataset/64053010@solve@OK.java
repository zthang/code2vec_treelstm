public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    Points[] points = new Points[N];
    for (int i = 0; i < N; i++) {
        points[i] = new Points(i);
    }
    for (int i = 0; i < N; i++) {
        points[i].x = in.nextInt();
        points[i].y = in.nextInt();
    }
    for (int i = 0; i < N; i++) {
        points[i].c = in.nextInt();
        points[i].cost = points[i].c;
    }
    for (int i = 0; i < N; i++) {
        points[i].k = in.nextInt();
    }
    PriorityQueue<Points> queue = new PriorityQueue<>(new Comparator<Points>() {

        public int compare(Points o1, Points o2) {
            if (o1.cost != o2.cost) {
                return Long.compare(o1.cost, o2.cost);
            }
            return o1.index - o2.index;
        }
    });
    for (int i = 0; i < N; i++) {
        queue.add(points[i]);
    }
    long cost = 0;
    boolean[] isStation = new boolean[N];
    ArrayList<Integer> stations = new ArrayList<>();
    ArrayList<String> edges = new ArrayList<>();
    while (!queue.isEmpty()) {
        Points point = queue.poll();
        if (point.visited) {
            continue;
        }
        if (point.parent == -1) {
            stations.add(point.index + 1);
        } else {
            edges.add((point.parent + 1) + " " + (point.index + 1));
        }
        cost += point.cost;
        point.visited = true;
        for (int i = 0; i < N; i++) {
            if (!points[i].visited) {
                long p = (Math.abs(points[i].x - point.x) + Math.abs(points[i].y - point.y)) * (points[i].k + point.k);
                if (p <= points[i].cost) {
                    points[i].parent = point.index;
                    points[i].cost = p;
                    queue.remove(points[i]);
                    queue.add(points[i]);
                }
            }
        }
    }
    // for (int i = 0; i < N; i++) {
    // if (!isStation[points[i].index]) {
    // long min = Constants.INFINITY;
    // int minIndex = -1;
    // for (int j = 0; j < N; j++) {
    // if (isStation[points[j].index]) {
    // long p = (Math.abs(points[i].x - points[j].x) + Math.abs(points[i].y - points[j].y)) * (points[i].k + points[j].k);
    // DebugUtils.debug(p, points[j], points[i]);
    // if (p < min) {
    // min = p;
    // minIndex = j;
    // }
    // }
    // }
    // cost += min;
    // edges.add((points[i].index + 1) + " " + (points[minIndex].index + 1));
    // }
    // }
    out.printLine(cost);
    out.printLine(stations.size());
    for (int i : stations) {
        out.print(i + " ");
    }
    out.printLine();
    out.printLine(edges.size());
    for (String s : edges) {
        out.printLine(s);
    }
}