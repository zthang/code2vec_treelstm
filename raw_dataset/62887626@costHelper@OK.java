private void costHelper(int node, int parent, Integer parentColour, Integer grandParentColour, int[] costColours) {
    if (parentColour == null) {
        for (int i = 0; i < 3; i++) {
            costColours[node] = i;
            for (int neighbour : adjList[node]) {
                if (neighbour != parent) {
                    costHelper(neighbour, node, i, grandParentColour, costColours);
                }
            }
        }
        return;
    }
    if (grandParentColour == null) {
        for (int i = 2; i >= 0; i--) {
            if (i != parentColour) {
                costColours[node] = i;
                for (int neighbour : adjList[node]) {
                    if (neighbour != parent) {
                        costHelper(neighbour, node, i, parentColour, costColours);
                        long tempCost = computeCost(costColours);
                        if (tempCost < this.minCost) {
                            minCost = tempCost;
                            minCostColours = costColours.clone();
                        }
                    }
                }
            }
        }
        return;
    }
    costColours[node] = 3 - parentColour - grandParentColour;
    for (int neighbour : adjList[node]) {
        if (neighbour != parent) {
            costHelper(neighbour, node, costColours[node], parentColour, costColours);
        }
    }
}