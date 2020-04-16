public static <T> Map<T, Set<Integer>> invert(Collection<T> coll) {
    Map<T, Set<Integer>> map = new HashMap<>();
    int i = 0;
    for (T t : coll) {
        Set<Integer> set = map.get(t);
        if (set == null) {
            map.put(t, Collections.singleton(i));
        } else {
            if (!(set instanceof LinkedHashSet)) {
                set = new LinkedHashSet<>(set);
                map.put(t, set);
            }
            set.add(i);
        }
        i++;
    }
    return Collections.unmodifiableMap(map);
}