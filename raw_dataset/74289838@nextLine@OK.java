public String nextLine() {
    String s = "";
    try {
        s = reader.readLine();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return s;
}