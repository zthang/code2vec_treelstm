void bfsOut(Node[] nodes) {
    for (Node n : nodes) n.bfsNum = -1;
    bfsNum = 0;
    int counter = 1;
    for (Node n : adj) {
        if (n.bfsNum != -1)
            continue;
        ArrayDeque<Node> bfs = new ArrayDeque<>();
        bfs.add(n);
        n.bfsNum = counter;
        while (!bfs.isEmpty()) {
            Node next = bfs.remove();
            for (Node nn : next.adj) {
                if (nn.bfsNum == -1) {
                    nn.bfsNum = counter;
                    bfs.add(nn);
                }
            }
        }
        counter++;
    }
}