public boolean hasNext() {
    int t = skip();
    if (t == -1) {
        return false;
    }
    ptrbuf--;
    return true;
}