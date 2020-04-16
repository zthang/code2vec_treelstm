static int calc(ArrayList<Node> edgeList, int[] marks, HashSet<Node> hs) {
    int ans = 0;
    for (Node nd : edgeList) {
        int mx = marks[nd.x];
        int my = marks[nd.y];
        Node can1 = new Node(mx, my);
        Node can2 = new Node(my, mx);
        if (hs.contains(can1)) {
            ans++;
            hs.remove(can1);
        } else if (hs.contains(can2)) {
            ans++;
            hs.remove(can2);
        }
    }
    return ans;
}