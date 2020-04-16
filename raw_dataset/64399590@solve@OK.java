public void solve(int testNumber, FastInput in, FastOutput out) {
    n = in.readInt();
    nodes = new Node[n];
    for (int i = 0; i < n; i++) {
        nodes[i] = new Node();
        nodes[i].id = i;
    }
    map = new LinkedHashMap<>(200000);
    for (int i = 0; i < n; i++) {
        int k = in.readInt();
        for (int j = 0; j < k; j++) {
            long x = in.readInt();
            map.put(x, nodes[i]);
            nodes[i].sum += x;
        }
    }
    long total = 0;
    for (Node node : nodes) {
        total += node.sum;
    }
    if (total % n != 0) {
        out.println("No");
        return;
    }
    long avg = total / n;
    notExist = (long) 1e18;
    mask2Key = new long[1 << n];
    Arrays.fill(mask2Key, notExist);
    sequence = new HashMap<>(200000);
    for (Map.Entry<Long, Node> kv : map.entrySet()) {
        for (Node node : nodes) {
            node.handled = false;
        }
        long key = kv.getKey();
        Node node = kv.getValue();
        node.handled = true;
        int mask = bo.setBit(0, node.id, true);
        LongList list = new LongList(15);
        list.add(key);
        long req = avg - (node.sum - key);
        boolean valid = true;
        while (true) {
            if (req == key) {
                break;
            }
            Node next = map.get(req);
            if (next == null || next.handled) {
                valid = false;
                break;
            }
            next.handled = true;
            list.add(req);
            req = avg - (next.sum - req);
            mask = bo.setBit(mask, next.id, true);
        }
        if (!valid) {
            continue;
        }
        mask2Key[mask] = key;
        sequence.put(key, list);
    }
    dp = new boolean[1 << n];
    for (int i = 0; i < (1 << n); i++) {
        dp[i] = mask2Key[i] != notExist;
        sg.setSet(i);
        while (!dp[i] && sg.hasNext()) {
            int next = sg.next();
            if (next == 0 || next == i) {
                continue;
            }
            dp[i] = dp[i] || (dp[next] && dp[i - next]);
        }
    }
    if (!dp[(1 << n) - 1]) {
        out.println("No");
        return;
    }
    populate((1 << n) - 1);
    out.println("Yes");
    for (Node node : nodes) {
        out.append(node.out).append(' ').append(node.to + 1).append('\n');
    }
}