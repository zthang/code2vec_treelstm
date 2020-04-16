@Override
public void run() {
    try {
        reader = new StandardInput();
        writer = new PrintWriter(System.out);
        solve();
        reader.close();
        writer.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}