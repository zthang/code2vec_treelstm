static void recur(List<Integer> assigned) {
    if (assigned.size() < nodecount) {
        for (int i = 1; i <= 6; i++) {
            assigned.add(i);
            recur(assigned);
            assigned.remove(assigned.size() - 1);
        }
        return;
    }
    Set<Edge> added = new HashSet<>();
    int count = 0;
    // System.out.println(assigned.toString());
    for (int i = 0; i < edges.size(); i++) {
        // System.out.println(edges.get(i).n1); System.out.flush();
        // System.out.println(edges.get(i).n2); System.out.flush();
        int rn1 = assigned.get(edges.get(i).n1 - 1);
        int rn2 = assigned.get(edges.get(i).n2 - 1);
        String rn = Integer.toString(rn1) + Integer.toString(rn2);
        if (dominos.contains(rn)) {
            dominos.remove(rn);
            count++;
            added.add(new Edge(rn1, rn2));
        }
    }
    maxnumDos = Integer.max(maxnumDos, count);
    for (Edge edge : added) {
        dominos.add(Integer.toString(edge.n1) + Integer.toString(edge.n2));
    }
}