public TreeMap<Integer, Integer> thipPush(ArrayList<Integer> l) {
    TreeMap<Integer, Integer> r = new TreeMap<Integer, Integer>();
    Collections.sort(l);
    int b = -(mod + 9393);
    int p = 0;
    for (int e : l) {
        if (b != e) {
            r.put(e, p);
            p++;
        }
        b = e;
    }
    return r;
}