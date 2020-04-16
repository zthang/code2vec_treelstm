public void load() {
    try {
        in = new FileInputStream(next());
    } catch (Exception e) {
        e.printStackTrace();
    }
}