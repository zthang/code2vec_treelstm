private static int getFirstUnusedVertex(int[] vertexesBySets) {
    for (int i = 1; i < vertexesBySets.length; i++) {
        if (vertexesBySets[i] == 0) {
            return i;
        }
    }
    return -1;
}