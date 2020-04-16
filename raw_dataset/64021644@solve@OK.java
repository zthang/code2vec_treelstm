public List<String> solve() {
    PriorityQueue<Node> queue = new PriorityQueue<>();
    boolean[] connected = new boolean[n];
    for (int i = 0; i < n; i++) {
        queue.add(new Node(i, cs[i], Node.Type.POWER_STATION, -1));
    }
    int count = 0;
    long totalCost = 0;
    List<Integer> powerStations = new ArrayList<>();
    List<String> wires = new ArrayList<>();
    while (count < n) {
        Node node = queue.poll();
        int index = node.index;
        if (connected[index]) {
            continue;
        }
        connected[index] = true;
        totalCost += node.cost;
        if (node.type == Node.Type.POWER_STATION) {
            powerStations.add(index + 1);
        } else {
            wires.add(String.format("%d %d", node.index + 1, node.source + 1));
        }
        count++;
        for (int i = 0; i < n; i++) {
            if (connected[i]) {
                continue;
            }
            long wireCost = ks[index] + ks[i];
            int distance = Math.abs(xys[index][0] - xys[i][0]) + Math.abs(xys[index][1] - xys[i][1]);
            queue.add(new Node(i, wireCost * distance, Node.Type.WIRE, index));
        }
    }
    List<String> answers = new ArrayList<>();
    answers.add("" + totalCost);
    answers.add("" + powerStations.size());
    StringBuffer powerStationLineBuffer = new StringBuffer();
    powerStationLineBuffer.append(powerStations.get(0));
    for (int i = 1; i < powerStations.size(); i++) {
        powerStationLineBuffer.append(" ");
        powerStationLineBuffer.append(powerStations.get(i));
    }
    answers.add(powerStationLineBuffer.toString());
    answers.add("" + wires.size());
    answers.addAll(wires);
    return answers;
}