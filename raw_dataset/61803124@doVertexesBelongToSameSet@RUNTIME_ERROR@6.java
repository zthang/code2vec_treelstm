    private static boolean doVertexesBelongToSameSet(Set<Integer> possibleSet,
                                                     Map<Integer, List<Integer>> graph,
                                                     Set<Integer> mainVertexNeighbors) {
        for (int currVertex : possibleSet) {
            List<Integer> neighbors = graph.get(currVertex);
            if(neighbors.size() != mainVertexNeighbors.size()) {
                return false;
            }
            for (int neighbor : neighbors) {
                if (!mainVertexNeighbors.contains(neighbor)) {
                    return false;
                }
            }
        }
        return true;
    }