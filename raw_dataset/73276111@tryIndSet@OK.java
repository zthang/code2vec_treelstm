static boolean tryIndSet(Node[] nodes) {
    ArrayList<Integer> order = new ArrayList<>();
    int n = nodes.length;
    for (int i = 0; i < n; i++) order.add(i);
    Collections.shuffle(order);
    for (Node nn : nodes) nn.hit = false;
    ArrayList<Integer> taken = new ArrayList<>();
    for (int toTakeI : order) {
        Node toTake = nodes[toTakeI];
        if (toTake.hit)
            continue;
        taken.add(toTakeI);
        for (Node nn : toTake.adj) nn.hit = true;
    }
    if (taken.size() >= sqrt) {
        PrintWriter out = new PrintWriter(System.out);
        out.println(1);
        for (int i = 0; i < sqrt; i++) out.print(taken.get(i) + 1 + " ");
        out.println();
        out.close();
        return true;
    }
    return false;
}