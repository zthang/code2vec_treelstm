void DFS() {
    for (int i = 0; i < numNodes; i++) {
        if (startTime[i] == 0) {
            DFSHelper(i);
        }
    }
}