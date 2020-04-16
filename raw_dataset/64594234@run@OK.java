void run() throws IOException {
    int n = nextInt();
    cost_of_comp = new long[n];
    parent = new int[n];
    min_cost_for_station = new Point[n];
    rank = new int[n];
    Point[] a = new Point[n];
    long[] c = new long[n];
    long[] k = new long[n];
    for (int i = 0; i < a.length; i++) {
        a[i] = new Point(nextInt(), nextInt());
        parent[i] = i;
    }
    for (int i = 0; i < c.length; i++) {
        c[i] = nextInt();
    }
    for (int i = 0; i < k.length; i++) {
        k[i] = nextInt();
    }
    for (int i = 0; i < n; i++) {
        min_cost_for_station[i] = new Point(c[i], i);
        cost_of_comp[i] = c[i];
    }
    ArrayList<Tuple> al = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            long e = (k[i] + k[j]) * dist(a[i], a[j]);
            al.add(new Tuple(i, j, e));
        }
    }
    Collections.sort(al, new TupleComp());
    Tuple[] edges = new Tuple[al.size()];
    for (int i = 0; i < al.size(); i++) {
        edges[i] = al.get(i);
    }
    ArrayList<Point> cities = new ArrayList<>();
    for (int i = 0; i < edges.length; i++) {
        int from = edges[i].from;
        int to = edges[i].to;
        long ves = edges[i].ves;
        if (get(from) != get(to)) {
            if (ves < max(min_cost_for_station[get(from)].x, min_cost_for_station[get(to)].x)) {
                cities.add(new Point(from + 1, to + 1));
                unite(from, to, ves);
            }
        }
    }
    long cost_all = 0;
    ArrayList<Integer> stations = new ArrayList<>();
    TreeSet<Integer> used = new TreeSet<>();
    for (int i = 0; i < n; i++) {
        int x = get(i);
        if (!used.contains(x)) {
            used.add(x);
            stations.add(min_cost_for_station[x].y + 1);
            cost_all += cost_of_comp[x];
        }
    }
    pw.println(cost_all);
    pw.println(stations.size());
    for (int i = 0; i < stations.size(); i++) {
        pw.print(stations.get(i) + " ");
    }
    pw.println();
    pw.println(cities.size());
    for (int i = 0; i < cities.size(); i++) {
        pw.println(cities.get(i).x + " " + cities.get(i).y);
    }
    pw.close();
}