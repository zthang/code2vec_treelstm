public static void split(Node x) {
    for (Node trace = x.p; trace != null; trace = trace.p) {
        trace.rank -= x.rank;
    }
    x.p = null;
}