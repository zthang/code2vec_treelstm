private double[][] getWeightsMatrix() {
    double[][] weights = new double[vertices.size()][vertices.size()];
    for (int i = 0; i < weights.length; i++) {
        Arrays.fill(weights[i], INF);
    }
    for (int i = 0; i < vertices.size(); i++) {
        weights[i][i] = 0;
        AdjVertex<T> u = (AdjVertex<T>) vertices.get(i);
        for (Edge<T> e : u.getAdjList()) {
            AdjVertex<T> v = (AdjVertex<T>) e.getDestination();
            double weight = e.getWeight();
            weights[i][getIndexOf(v)] = weight;
        }
    }
    return weights;
}