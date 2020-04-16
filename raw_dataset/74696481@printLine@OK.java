public void printLine(Object... objects) {
    print(objects);
    writer.println();
    writer.flush();
}