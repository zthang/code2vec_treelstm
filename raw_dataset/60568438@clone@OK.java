public GraphLight clone() {
    int[][] adj = new int[this.V][];
    for (int i = 0; i < this.V; ++i) adj[i] = Arrays.copyOf(this.adj[i], this.adj[i].length);
    return new GraphLight(this.V, this.E, adj);
}