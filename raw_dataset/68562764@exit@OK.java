private static void exit() {
    String end = "------------------" + System.lineSeparator() + time();
    switch(DEBUG) {
        case 1:
            print(end);
            break;
        case 2:
            err(end);
            break;
    }
    IOUtils.pw.close();
    System.out.flush();
    System.exit(0);
}