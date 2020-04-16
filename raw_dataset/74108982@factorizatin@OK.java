public static ArrayList factorizatin(int n) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    if (n == 1) {
        list.add(1);
        return list;
    } else if (n == 2) {
        list.add(2);
        return list;
    } else {
        if (isPrime(n)) {
            System.out.println(-1);
            return null;
        } else {
            Iterator ptr = sieve((int) Math.sqrt(n)).iterator();
            if (ptr.hasNext()) {
                int cur = (int) ptr.next();
                // System.out.println(cur);
                while (n != 1) {
                    System.out.println(n);
                    while (n % cur == 0) {
                        list.add(cur);
                        n /= cur;
                    }
                    if (ptr.hasNext()) {
                        cur = (int) ptr.next();
                    }
                // System.out.println(cur);
                }
            }
            if (n > 2) {
                list.add(n);
            }
        }
        return list;
    }
}