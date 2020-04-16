String nextLine() throws Exception {
    String str = "";
    try {
        str = br.readLine();
    } catch (IOException e) {
        throw new Exception(e.toString());
    }
    return str;
}