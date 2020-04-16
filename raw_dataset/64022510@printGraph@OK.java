public void printGraph(ArrayList<Edge> edgeList) {
    for (int i = 0; i < edgeList.size(); i++) {
        Edge edge = edgeList.get(i);
        System.out.println("Edge-" + i + " source: " + edge.source + " destination: " + edge.destination + " weight: " + edge.weight);
    }
}