    private static void solve(int q, FastScanner in, PrintWriter out) {
        for (int qq = 0; qq < q; qq++) {
            int n = in.nextInt(), m = in.nextInt();
            long[][] debt = new long[m][3];
            for(int i = 0; i < m; i++) {
                debt[i][0] = in.nextLong();
                debt[i][1] = in.nextLong();
                debt[i][2] = in.nextLong();
            }

            Arrays.sort(debt, (a1, a2) -> {
                if(a1[0] != a2[0]) {
                    return (int)(a1[0] - a2[0]);
                }
                return (int)(a1[1] - a2[1]);
            });

            Map<Long, Map<Long, Integer>> borrower = new HashMap<>(); //key: borrower id, value: map from lender to debt entry index
            Map<Long, Map<Long, Integer>> lender = new HashMap<>();   //key: lender id, value: map from borrower to debt entry index
            for(long i = 1; i <= n; i++) {
                borrower.put(i, new HashMap<>());
                lender.put(i, new HashMap<>());
            }
            List<long[]> uniqueDebts = new ArrayList<>();
            long[] prev = debt[0];
            int i = 1;
            while(i < debt.length) {
                while(i < debt.length && debt[i][0] == debt[i - 1][0] && debt[i][1] == debt[i - 1][1]) {
                    prev[2] += debt[i][2];
                    i++;
                }
                if(i == debt.length) {
                    break;
                }
                uniqueDebts.add(prev);
                borrower.get(prev[0]).put(prev[1], uniqueDebts.size() - 1);
                lender.get(prev[1]).put(prev[0], uniqueDebts.size() - 1);
                prev = debt[i];
                i++;
            }
            uniqueDebts.add(prev);
            borrower.get(prev[0]).put(prev[1], uniqueDebts.size() - 1);
            lender.get(prev[1]).put(prev[0], uniqueDebts.size() - 1);

            for(int j = 0; j < uniqueDebts.size(); j++) {
                long[] currDebt = uniqueDebts.get(j);   // a, b -> (currDebt[0], currDebt[1])
                Map<Long, Integer> currLenderMap = lender.get(currDebt[0]);   //find other debts with lender a

                //each entry: key: borrower, value: idx in uniqueDebts
                for(Map.Entry<Long, Integer> entry : currLenderMap.entrySet()) {
                    long[] relateDebt = uniqueDebts.get(entry.getValue());
                    //decrease (a, b) and (c, a)
                    long amount = Math.min(currDebt[2], relateDebt[2]);
                    currDebt[2] -= amount;
                    relateDebt[2] -= amount;

                    //if c != b, we generated a new debt from c to b
                    if(relateDebt[0] != currDebt[1]) {
                        long newBorrower = relateDebt[0];
                        long newLender = currDebt[1];
                        //add new debt to borrower/lender map
                        Map<Long, Integer> bm = borrower.get(newBorrower);
                        if(!bm.containsKey(newLender)) {
                            //add new debt if not existing already
                            uniqueDebts.add(new long[]{newBorrower, newLender, amount});
                            bm.put(newLender, uniqueDebts.size() - 1);
                            Map<Long, Integer> lm = lender.get(newLender);
                            lm.put(newBorrower, uniqueDebts.size() - 1);
                        }
                        else {
                            //update existing debt
                            long[] db = uniqueDebts.get(bm.get(newLender));
                            db[2] += amount;
                        }
                    }

                    if(currDebt[2] == 0) {
                        borrower.get(currDebt[0]).remove(currDebt[1]);
                        lender.get(currDebt[1]).remove(currDebt[0]);
                    }
                    if(relateDebt[2] == 0) {
                        borrower.get(relateDebt[0]).remove(relateDebt[1]);
                        lender.get(relateDebt[1]).remove(relateDebt[0]);
                    }
                    //if the debt from a to b is already 0, exit
                    if(currDebt[2] == 0) {
                        break;
                    }
                }
                //if a to b not 0, then try to consolidate with debts that have b as borrower
                if(currDebt[2] != 0) {
                    Map<Long, Integer> currBorrowerMap = borrower.get(currDebt[1]);   //find other debts with borrower b
                    for(Map.Entry<Long, Integer> entry : currBorrowerMap.entrySet()) {
                        long[] relateDebt = uniqueDebts.get(entry.getValue());
                        //decrease (a, b) and (b, d)
                        long amount = Math.min(currDebt[2], relateDebt[2]);
                        currDebt[2] -= amount;
                        relateDebt[2] -= amount;

                        //if a != d, we generated a new debt from a to d
                        if(relateDebt[1] != currDebt[0]) {
                            long newLender = relateDebt[1];
                            long newBorrower = currDebt[0];
                            //add new debt to borrower/lender map
                            Map<Long, Integer> bm = borrower.get(newBorrower);
                            if(!bm.containsKey(newLender)) {
                                //add new debt if not existing already
                                uniqueDebts.add(new long[]{newBorrower, newLender, amount});
                                bm.put(newLender, uniqueDebts.size() - 1);
                                Map<Long, Integer> lm = lender.get(newLender);
                                lm.put(newBorrower, uniqueDebts.size() - 1);
                            }
                            else {
                                //update existing debt
                                long[] db = uniqueDebts.get(bm.get(newLender));
                                db[2] += amount;
                            }
                        }

                        if(currDebt[2] == 0) {
                            borrower.get(currDebt[0]).remove(currDebt[1]);
                            lender.get(currDebt[1]).remove(currDebt[0]);
                        }
                        if(relateDebt[2] == 0) {
                            borrower.get(relateDebt[0]).remove(relateDebt[1]);
                            lender.get(relateDebt[1]).remove(relateDebt[0]);
                        }

                        //if the debt from a to b is already 0, exit
                        if(currDebt[2] == 0) {
                            break;
                        }
                    }
                }
            }

            int cnt = 0;
            for(long[] db : uniqueDebts) {
                if(db[2] != 0) {
                    cnt++;
                }
            }
            out.println(cnt);
            for(long[] db : uniqueDebts) {
                if(db[2] != 0) {
                    out.println(db[0] + " " + db[1] + " " + db[2]);
                }
            }
        }
        out.close();
    }