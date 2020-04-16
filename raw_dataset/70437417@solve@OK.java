static int solve(int x) {
    int num_x = x + 1;
    System.out.print("? ");
    System.out.print(num_x);
    System.out.print("\n");
    String str = cin.next();
    char[] s = str.toCharArray();
    if (s[0] == 'Y')
        return 1;
    else
        return 0;
}