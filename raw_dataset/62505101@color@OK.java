public static int[] color(Node[] nodes, Node start, int c1, int c2) {
    int n = nodes.length;
    int[] color = new int[n];
    for (int i = 0; i < n; i++) {
        color[i] = -1;
    }
    Node next = start.neigh.get(0);
    color[start.name] = c1;
    color[next.name] = c2;
    int l1 = c1;
    int l2 = c2;
    for (int i = 2; i < n; i++) {
        for (int k = 0; k < next.neigh.size(); k++) {
            if (color[next.neigh.get(k).name] == -1) {
                next = next.neigh.get(k);
                if (l1 == 0 && l2 == 1 || l1 == 1 && l2 == 0) {
                    color[next.name] = 2;
                    l1 = l2;
                    l2 = 2;
                } else if (l1 == 0 && l2 == 2 || l1 == 2 && l2 == 0) {
                    color[next.name] = 1;
                    l1 = l2;
                    l2 = 1;
                } else {
                    color[next.name] = 0;
                    l1 = l2;
                    l2 = 0;
                }
            }
        }
    }
    return color;
}