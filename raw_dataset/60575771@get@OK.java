public Node get(int i) {
    if (children[i] == null) {
        children[i] = new Node();
        children[i].c = i;
        children[i].prefix = (int) (((long) prefix * 10 + i) % mod);
        children[i].depth = depth + 1;
        children[i].bl[0] = this;
        for (int j = 0; j < 19 && children[i].bl[j] != null; j++) {
            children[i].bl[j + 1] = children[i].bl[j].bl[j];
        }
    }
    return children[i];
}