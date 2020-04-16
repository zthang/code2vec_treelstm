String nextLine() {
    String string = "";
    try {
        string = br.readLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return string;
}