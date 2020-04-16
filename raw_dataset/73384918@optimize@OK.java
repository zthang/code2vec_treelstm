public boolean optimize(int root, IntegerList circle) {
    Arrays.fill(dist, -1);
    Arrays.fill(prev, -1);
    Arrays.fill(tag, null);
    dq.clear();
    dist[root] = 0;
    boolean ans = false;
    for (UndirectedEdge e : g[root]) {
        if (dist[e.to] != -1) {
            if (e.to == root && (circle.size() == 0 || circle.size() > 1)) {
                circle.clear();
                circle.add(root);
                ans = true;
            }
            if (circle.size() == 0 || circle.size() > 2) {
                circle.clear();
                circle.add(root);
                circle.add(e.to);
                ans = true;
            }
            continue;
        }
        dist[e.to] = 1;
        tag[e.to] = e;
        prev[e.to] = root;
        dq.addLast(e.to);
    }
    if (circle.size() == 1 || circle.size() == 2) {
        return ans;
    }
    UndirectedEdge cross = null;
    int best = circle.size() == 0 ? g.length + 1 : circle.size();
    while (!dq.isEmpty()) {
        int head = dq.removeFirst();
        for (UndirectedEdge e : g[head]) {
            if (dist[e.to] != -1) {
                if (e.to != root && tag[e.to] != tag[head] && best > dist[head] + dist[e.to] + 1) {
                    best = dist[head] + dist[e.to] + 1;
                    cross = e;
                }
                continue;
            }
            dist[e.to] = dist[head] + 1;
            tag[e.to] = tag[head];
            prev[e.to] = head;
            dq.addLast(e.to);
        }
    }
    if (cross != null && (circle.size() == 0 || best < circle.size())) {
        circle.clear();
        collect(cross.to, circle);
        circle.pop();
        int size = circle.size();
        collect(cross.rev.to, circle);
        SequenceUtils.reverse(circle.getData(), size, circle.size() - 1);
        ans = true;
    }
    return ans;
}