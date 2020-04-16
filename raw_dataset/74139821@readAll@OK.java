public ArrayList<String> readAll() {
    ArrayList<String> a = new ArrayList<String>();
    try {
        while (true) {
            a.add(nextLine());
        }
    } catch (Exception e) {
    }
    return a;
}