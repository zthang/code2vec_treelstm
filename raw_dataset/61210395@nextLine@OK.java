public String nextLine() {
    st = null;
    try {
        return br.readLine();
    } catch (Exception e) {
        throw new RuntimeException();
    }
}