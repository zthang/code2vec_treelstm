@Override
public void run() {
    try {
        reader = new StandardInput();
        writer = new PrintWriter(System.out);
        new Task().solve(reader, writer);
        reader.close();
        writer.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}