public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    int m = in.readInt();
    long[] right = new long[n];
    for (int i = 0; i < n; i++) {
        right[i] = in.readLong();
    }
    IntegerList[] indeg = new IntegerList[n];
    for (int i = 0; i < n; i++) {
        indeg[i] = new IntegerList();
    }
    for (int i = 0; i < m; i++) {
        int a = in.readInt() - 1;
        int b = in.readInt() - 1;
        indeg[b].add(a);
    }
    for (int i = 0; i < n; i++) {
        indeg[i].unique();
    }
    Modular mod = new Modular(1e9 + 7);
    LongObjectHashMap<Node> map = new LongObjectHashMap<>(n, false);
    for (int i = 0; i < n; i++) {
        if (indeg[i].isEmpty()) {
            continue;
        }
        long key = DigitUtils.asLong(hash(indeg[i], mod, 31), hash(indeg[i], mod, 41));
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            node.indeg = indeg[i].size();
            node.sum = 0;
            map.put(key, node);
        }
        node.sum += right[i];
    }
    List<Node> list = new ArrayList<>(map.size());
    long g = 0;
    for (LongObjectEntryIterator<Node> iterator = map.iterator(); iterator.hasNext(); ) {
        iterator.next();
        list.add(iterator.getEntryValue());
        g += iterator.getEntryValue().sum;
    }
    Node[] nodes = list.toArray(new Node[0]);
    debug.debug("map", map);
    while (true) {
        Node index = null;
        for (Node node : nodes) {
            if (node.sum % g == 0) {
                continue;
            }
            if (index == null || node.indeg < index.indeg) {
                index = node;
            }
        }
        if (index == null) {
            break;
        }
        debug.debug("index.sum", index.sum);
        g = GCDs.gcd(g, index.sum);
    }
    out.println(g);
}