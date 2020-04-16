public double[][] floydwarshall() {
    double[][] weights = getWeightsMatrix();
    for (int k = 0; k < vertices.size(); k++) {
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                weights[i][j] = Math.min(weights[i][j], weights[i][k] + weights[k][j]);
            }
        }
    }
    return weights;
}