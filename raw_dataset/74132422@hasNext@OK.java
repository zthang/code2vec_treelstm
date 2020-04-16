boolean hasNext() {
    String next = null;
    try {
        next = br.readLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
    if (next == null) {
        return false;
    }
    st = new StringTokenizer(next);
    return true;
}