private void DFSHelper(int node) {
    clock++;
    startTime[node] = clock;
    for (Edge e : adjList[node]) {
        int neighbour = e.end;
        if (endTime[neighbour] == 0) {
            if (startTime[neighbour] != 0) {
                if (startTime[neighbour] < startTime[node]) {
                    e.incrementColour();
                    flag = true;
                }
            } else {
                DFSHelper(neighbour);
            }
        }
    }
    clock++;
    endTime[node] = clock;
}