String nextLine() {
    try {
        return br.readLine();
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException();
    }
}