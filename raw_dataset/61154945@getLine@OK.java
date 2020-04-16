public String getLine() {
    try {
        st = null;
        return r.readLine();
    } catch (IOException ex) {
    }
    return null;
}