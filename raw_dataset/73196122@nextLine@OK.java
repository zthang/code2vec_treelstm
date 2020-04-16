private String nextLine() {
    String str = "";
    try {
        str = bufferedReader.readLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return str;
}