String nextLine() {
    try {
        return br.readLine();
    } catch (IOException e) {
        return null;
    }
}