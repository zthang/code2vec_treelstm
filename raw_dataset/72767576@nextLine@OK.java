String nextLine() {
    String str = "";
    try {
        str = br.readLine();
    } catch (Exception addd) {
        addd.printStackTrace();
    }
    return str;
}