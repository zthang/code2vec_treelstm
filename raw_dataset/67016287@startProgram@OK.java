void startProgram() {
    while (k.hasNext()) {
        nodes = k.nextInt();
        edges = k.nextInt();
        union = new UnionFind(nodes);
        startAlgo();
    }
    z.flush();
    System.exit(0);
}