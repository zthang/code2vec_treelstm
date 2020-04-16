String nextLine() {
    try {
        return reader.readLine();
    } catch (IOException err) {
        return null;
    }
}