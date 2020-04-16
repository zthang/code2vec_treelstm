String nextLine() {
    String str = "";
    try {
        str = br.readLine();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return str;
}