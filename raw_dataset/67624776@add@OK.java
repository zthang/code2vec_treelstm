static void add(Map<Integer, List<Integer>> map, int root, int v) {
    if (map.containsKey(root))
        map.get(root).add(v);
    else {
        List<Integer> temp = new ArrayList<>();
        temp.add(v);
        map.put(root, temp);
    }
}