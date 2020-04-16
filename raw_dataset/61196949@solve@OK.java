public void solve() {
    int n = io.readInt();
    int m = io.readInt();
    Node[] nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes[i] = new Node();
        nodes[i].id = i;
    }
    for (int i = 0; i < m; i++) {
        Node a = nodes[io.readInt()];
        Node b = nodes[io.readInt()];
        if (a.id < b.id) {
            Node tmp = a;
            a = b;
            b = tmp;
        }
        a.outDegree++;
        b.in.add(a);
    }
    long maintain = 0;
    for (int i = 1; i <= n; i++) {
        maintain += nodes[i].contribute();
    }
    io.cache.append(maintain).append('\n');
    int q = io.readInt();
    for (int i = 0; i < q; i++) {
        Node which = nodes[io.readInt()];
        maintain -= which.contribute();
        for (Node x : which.in) {
            maintain -= x.contribute();
            x.outDegree--;
            x.in.add(which);
            maintain += x.contribute();
            which.outDegree++;
        }
        which.in.clear();
        maintain += which.contribute();
        io.cache.append(maintain).append('\n');
    }
}