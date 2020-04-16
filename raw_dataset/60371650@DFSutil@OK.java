private void DFSutil(int v, Set<Integer> greySet, boolean[] visited) {
    ArrayList<Integer> ret = new ArrayList<>();
    visited[v] = true;
    greySet.add(v);
    Iterator<Pair> iterator = edge[v].listIterator();
    while (iterator.hasNext()) {
        Pair node = iterator.next();
        int n = node.a;
        if (!visited[n]) {
            parent.put(n, v);
            DFSutil(n, greySet, visited);
        } else {
            if (greySet.contains(n)) {
                color.put(node.b, 1);
                cycle = true;
            }
        }
    }
    greySet.remove(v);
}