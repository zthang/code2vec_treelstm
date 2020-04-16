public void initGraph(int numberOfNodes, String[] labels) {
    nodes = new GraphUtils.Node[numberOfNodes];
    for (int i = 0; i < numberOfNodes; i++) {
        nodes[i] = new GraphUtils.Node();
        nodes[i].edges = new ArrayList<>();
        nodes[i].index = i;
        if (labels[i] != null) {
            nodes[i].name = labels[i];
        }
    }
}