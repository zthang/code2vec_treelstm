private boolean isAncestor(int parent, int son) {
    return timeIn[parent] <= timeIn[son] && timeOut[son] <= timeOut[parent];
}