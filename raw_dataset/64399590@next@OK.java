public int next() {
    int returned = next;
    consume();
    return returned;
}