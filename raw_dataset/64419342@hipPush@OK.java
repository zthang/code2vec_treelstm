public HashMap<Integer, Integer> hipPush(ArrayList<Integer> l) {
    HashMap<Integer, Integer> r = new HashMap<Integer, Integer>();
    TreeSet<Integer> s = new TreeSet<Integer>();
    for (int e : l) s.add(e);
    int p = 0;
    for (int e : s) {
        r.put(e, p);
        p++;
    }
    return r;
}