private static void solve() {
    long cost = 0L;
    List<Integer> poweredCities = new ArrayList<>();
    List<Edge> wiredCities = new ArrayList<>();
    int count = 0;
    for (int ii = 0; ii < edges.size(); ii++) {
        int u = edges.get(ii).u;
        int v = edges.get(ii).v;
        long w = edges.get(ii).w;
        if (!isSameSet(u, v)) {
            cost += w;
            unionSet(u, v);
            if (u == 0)
                poweredCities.add(v);
            else
                wiredCities.add(edges.get(ii));
            if (++count == nodes.size() - 1)
                break;
        }
    }
    System.out.println(cost);
    System.out.println(poweredCities.size());
    for (Integer poweredCity : poweredCities) {
        System.out.print(poweredCity + " ");
    }
    System.out.println();
    System.out.println(wiredCities.size());
    for (Edge wiredCity : wiredCities) {
        System.out.println(wiredCity.u + " " + wiredCity.v);
    }
}