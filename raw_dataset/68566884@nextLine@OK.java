String nextLine() {
    String s = "";
    try {
        s = br.readLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return s;
}