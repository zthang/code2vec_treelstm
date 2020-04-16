public int ls(int i, ArrayList<Integer>[] adj, Pair<Integer, Integer>[] a, HashSet<Integer> hs, HashSet<Integer> list, HashSet<Integer> person) {
    int s = 0;
    if (list.contains(i))
        return 0;
    list.add(i);
    for (Integer p : adj[i]) {
        if (!person.contains(p)) {
            person.add(p);
            if (!hs.contains(a[p].getKey()) && !hs.contains(a[p].getValue())) {
                hs.add(a[p].getKey());
                hs.add(a[p].getValue());
                s += ls(a[p].getKey(), adj, a, hs, list, person);
                s += ls(a[p].getValue(), adj, a, hs, list, person);
            } else if (!hs.contains(a[p].getKey())) {
                hs.add(a[p].getKey());
                s += ls(a[p].getKey(), adj, a, hs, list, person);
            } else if (!hs.contains(a[p].getValue())) {
                hs.add(a[p].getValue());
                s += ls(a[p].getValue(), adj, a, hs, list, person);
            } else {
                ++s;
            }
        }
    }
    return s;
}