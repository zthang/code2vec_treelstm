void startProgram() {
    while (k.hasNext()) {
        n = k.nextInt();
        y = k.getInputIntegerArrayOneBasedIndex(n);
        oddGraph = new ArrayList[n + 1];
        evenGraph = new ArrayList[n + 1];
        oddQueue = new ArrayDeque<Integer>();
        evenQueue = new ArrayDeque<Integer>();
        oddD = new int[n + 1];
        evenD = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            oddGraph[i] = new ArrayList<Integer>();
            evenGraph[i] = new ArrayList<Integer>();
        }
        startAlgo();
    }
    z.flush();
    System.exit(0);
}