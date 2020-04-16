HashMap<Integer, Long> merge(HashMap<Integer, Long> a, HashMap<Integer, Long> b) {
    HashMap<Integer, Long> big, small;
    if (a.size() > b.size()) {
        big = a;
        small = b;
    } else {
        big = b;
        small = a;
    }
    for (Entry<Integer, Long> e : small.entrySet()) big.put(e.getKey(), min(e.getValue(), big.getOrDefault(e.getKey(), oo)));
    return big;
}