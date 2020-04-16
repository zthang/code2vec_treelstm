private String readLine() {
    try {
        return r.readLine();
    } catch (Exception e) {
        throw new Error(e);
    }
}