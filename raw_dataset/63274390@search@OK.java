int search(int x, HashMap<Integer, Integer> mp, HashSet<Integer> hs) {
    if (mp.containsKey(x))
        return mp.get(x);
    if (x == 0)
        return 0;
    int v = 0;
    for (int i = 0; i < 7; i++) {
        if ((x & (1 << i)) != 0) {
            int t = x;
            t ^= (1 << i);
            if (!hs.contains(t)) {
                hs.add(t);
                v += search(t, mp, hs);
            }
        }
    }
    mp.put(x, v);
    return v;
}