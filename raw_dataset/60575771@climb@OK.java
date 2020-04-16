public Node climb(int depth) {
    int diff = this.depth - depth;
    Node trace = this;
    for (int i = 0; diff >= (1 << i); i++) {
        int bit = (1 << i);
        if ((bit & diff) > 0) {
            trace = trace.bl[i];
        }
    }
    return trace;
}