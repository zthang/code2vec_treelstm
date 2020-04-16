public String cost() {
    for (ArrayList<Integer> x : adjList) {
        if (x.size() > 2) {
            minCost = -1;
            break;
        }
    }
    if (minCost != -1) {
        int[] costColours = new int[numNodes];
        for (int i = 0; i < adjList.length; i++) {
            if (adjList[i].size() == 1) {
                // System.out.println("Root: " + i);
                costHelper(i, -1, null, null, costColours);
                break;
            }
        }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(minCost + "\n");
    if (minCost != -1) {
        for (int x : minCostColours) {
            sb.append((x + 1) + " ");
        }
    }
    return sb.toString();
}