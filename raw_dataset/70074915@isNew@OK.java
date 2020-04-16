boolean isNew(int ind, InputReader sc) {
    System.out.println("? " + (ind + 1));
    System.out.flush();
    char ans = sc.next().charAt(0);
    if (ans == 'Y')
        return false;
    return true;
}