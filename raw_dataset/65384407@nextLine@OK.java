String nextLine() {
    String str = "";
    try {
        str = bf.readLine();
    } catch (Exception e) {
        System.out.println(e);
    }
    return str;
}