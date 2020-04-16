String nextLine() {
    String str = "";
    try {
        str = br.readLine();
    } catch (IOException e) {
        return null;
    // e.printStackTrace();
    }
    return str;
}