String readNextLine() {
    String str = "";
    try {
        str = br.readLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return str;
}