public static void insert(HashMap<Integer, Node> map, int left, int val, int right) {
    map.put(val, new Node());
    map.get(val).left = left;
    map.get(val).right = right;
    map.get(left).right = val;
    map.get(right).left = val;
}