String nextLine() {
    String str = "";
    try {
        str = br.readLine();
    } catch (Exception r) {
        r.printStackTrace();
    }
    return str;
}