private void reallocate() {
    int k = edgeDst.length;
    edgeDst = Arrays.copyOf(edgeDst, 3 * k / 2);
    edgeNxt = Arrays.copyOf(edgeNxt, 3 * k / 2);
}