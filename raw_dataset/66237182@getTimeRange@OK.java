public int[][] getTimeRange() {
    if (dump) {
        for (int i = 0; i < V; i++) {
            System.out.println(i + ": " + timeRange[i][0] + " - " + timeRange[i][1]);
        }
    }
    return timeRange;
}