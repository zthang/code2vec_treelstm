private HashMap<Integer, Integer> addToHashMap(HashMap<Integer, Integer> map, int[] arr) {
    for (int val : arr) {
        if (!map.containsKey(val)) {
            map.put(val, 1);
        } else {
            map.put(val, map.get(val) + 1);
        }
    }
    return map;
}