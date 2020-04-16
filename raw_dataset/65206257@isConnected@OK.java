public boolean isConnected(int a, int b) {
    return father(a) == father(b);
}