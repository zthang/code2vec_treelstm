private static boolean isParent(Vertex v1, Vertex v2) {
    return v1.timeIn < v2.timeIn && v2.tineOut < v1.tineOut;
}