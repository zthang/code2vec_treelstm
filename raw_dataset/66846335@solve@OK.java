public static void solve(FastScanner fs) {
    // TODO: stack trick!
    int T = fs.nextInt();
    PrintWriter out = new PrintWriter(System.out);
    for (int tt = 0; tt < T; tt++) {
        int nNodes = fs.nextInt(), nEdges = fs.nextInt();
        int fair1 = fs.nextInt() - 1, fair2 = fs.nextInt() - 1;
        Node[] nodes = new Node[nNodes];
        MagicComponents magic = new MagicComponents(nNodes);
        for (int i = 0; i < nNodes; i++) nodes[i] = new Node();
        for (int i = 0; i < nEdges; i++) {
            int a = fs.nextInt() - 1, b = fs.nextInt() - 1;
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
            magic.addEdge(a, b);
        }
        magic.run();
        for (int i : magic.cuts) nodes[i].articulation = true;
        if (!nodes[fair1].articulation || !nodes[fair2].articulation) {
            out.println(0);
            continue;
        }
        nodes[fair1].bfsOut(nodes);
        long aCount = 0, bCount = 0;
        for (Node nn : nodes) {
            // System.out.println("Node bfsNum: "+nn.bfsNum);
            if (nn.bfsNum != nodes[fair1].bfsNum && nn.bfsNum != nodes[fair2].bfsNum) {
                aCount++;
            }
        }
        nodes[fair2].bfsOut(nodes);
        for (Node nn : nodes) {
            if (nn.bfsNum != nodes[fair1].bfsNum && nn.bfsNum != nodes[fair2].bfsNum) {
                bCount++;
            }
        }
        // System.out.println(aCount+" "+bCount);
        out.println(aCount * bCount);
    }
    out.close();
}