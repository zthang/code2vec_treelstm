void print() {
    for (int i = 0; i < numNodes; i++) {
        System.out.print(i + ": ");
        for (int neighbour : adjList[i]) {
            System.out.print(neighbour + ",");
        }
        System.out.println();
    }
}