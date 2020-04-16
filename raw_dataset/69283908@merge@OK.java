public Node merge(Node a, Node b) {
    Node merged = new Node();
    for (int i = limit - 1; i >= 0; i--) {
        if (a.status[i] == b.status[i]) {
            merged.status[i] = a.status[i];
        } else {
            if (a.status[i] > b.status[i]) {
                Node tmp = a;
                a = b;
                b = tmp;
            }
            merged.status[i] = a.status[i];
            int distToA = 0;
            int distToB = b.status[i] - a.status[i];
            for (int j = 0; j < i; j++) {
                distToA += a.status[j];
                distToB += b.status[j];
            }
            if (distToA > 0) {
                addEdge(merged, a, distToA);
                addEdge(merged, b, distToB);
                return merged;
            } else {
                addEdge(a, b, distToB);
                return a;
            }
        }
    }
    throw new RuntimeException();
}