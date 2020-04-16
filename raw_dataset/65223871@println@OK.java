public void println(Object... objects) {
    for (int i = 0; i < objects.length; i++) {
        if (i != 0) {
            writer.print(' ');
        }
        writer.print(objects[i]);
    }
    writer.print('\n');
}