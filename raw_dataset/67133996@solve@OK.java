void solve() throws Exception {
    int n = sc.nextInt();
    int m = sc.nextInt();
    long[] val = new long[n];
    for (int i = 0; i < m; i++) {
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        long monet = sc.nextInt();
        val[a] -= monet;
        val[b] += monet;
    }
    PriorityQueue<Node> pos = new PriorityQueue<>(), neg = new PriorityQueue<>();
    for (int i = 0; i < n; i++) if (val[i] > 0)
        pos.add(new Node(val[i], i));
    else if (val[i] < 0)
        neg.add(new Node(val[i], i));
    // print(val);
    ArrayList<String> ans = new ArrayList<>();
    while (!neg.isEmpty()) {
        Node nextN = neg.poll();
        if (nextN.val == 0)
            continue;
        Node nextP = pos.poll();
        while (nextP.val == 0) nextP = pos.poll();
        if (-nextN.val > nextP.val) {
            ans.add((nextN.idx + 1) + " " + (nextP.idx + 1) + " " + nextP.val);
            neg.add(new Node(nextN.val + nextP.val, nextN.idx));
        } else if (-nextN.val < nextP.val) {
            ans.add((nextN.idx + 1) + " " + (nextP.idx + 1) + " " + -nextN.val);
            pos.add(new Node(nextP.val + nextN.val, nextP.idx));
        } else
            ans.add((nextN.idx + 1) + " " + (nextP.idx + 1) + " " + nextP.val);
    }
    System.out.println(ans.size());
    for (String an : ans) System.out.println(an);
}