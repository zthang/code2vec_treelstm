public void realMain() throws Exception {
    BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);
    String in = fin.readLine();
    String[] ar = in.split(" ");
    int n = Integer.parseInt(ar[0]);
    int m = Integer.parseInt(ar[1]);
    int[] color = new int[n];
    ArrayList<Node> nodes = new ArrayList<Node>();
    for (int i = 0; i < n; i++) {
        nodes.add(new Node(i));
    }
    for (int i = 0; i < m; i++) {
        int ret = 0;
        boolean dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        int ind1 = ret - 1;
        ret = 0;
        dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        int ind2 = ret - 1;
        nodes.get(ind1).child.add(ind2);
        nodes.get(ind2).child.add(ind1);
    }
    visited = new boolean[n];
    int curcolor = 0;
    // ArrayList<Integer> toVisit = new ArrayList<Integer>();
    Stack<Integer> toVisit = new Stack<Integer>();
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            color[i] = curcolor;
            visited[i] = true;
            // toVisit.clear();
            for (int j = 0; j < nodes.get(i).child.size(); j++) {
                if (!visited[nodes.get(i).child.get(j)]) {
                    toVisit.push(nodes.get(i).child.get(j));
                    visited[nodes.get(i).child.get(j)] = true;
                }
            }
            while (toVisit.size() > 0) {
                int curnode = toVisit.pop();
                color[curnode] = curcolor;
                for (int j = 0; j < nodes.get(curnode).child.size(); j++) {
                    if (!visited[nodes.get(curnode).child.get(j)]) {
                        toVisit.push(nodes.get(curnode).child.get(j));
                        visited[nodes.get(curnode).child.get(j)] = true;
                    }
                }
            }
            curcolor++;
        }
    }
    /*ArrayList<Array<Integer>> connected = new ArrayList<SAL<Integer>>();

		for(int i = 0; i < curcolor; i++) {
			connected.add(new SAL<Integer>());
		}

		for(int i = 0; i < n; i++) {
			connected.get(color[i]).add(i);
		}

		//for(int i = 0; i < curcolor; i++) {
		//	Collections.sort(connected.get(i));
		//}

		//System.out.println(connected);
*/
    int ret = 0;
    int[] colormin = new int[curcolor];
    int[] colormax = new int[curcolor];
    for (int i = 0; i < curcolor; i++) {
        colormin[i] = Integer.MAX_VALUE;
    }
    for (int i = 0; i < n; i++) {
        colormin[color[i]] = Math.min(i, colormin[color[i]]);
        colormax[color[i]] = Math.max(i, colormax[color[i]]);
    }
    /*for(int i = 0; i < curcolor; i++) {
			colormin[i] = connected.get(i).get(0);
			colormax[i] = connected.get(i).get( connected.get(i).size() - 1 );
		}*/
    int curmin = colormin[0];
    int curmax = colormax[0];
    for (int i = 1; i < curcolor; i++) {
        if (colormin[i] < curmax) {
            ret++;
            curmax = Math.max(curmax, colormax[i]);
        } else {
            curmin = colormin[i];
            curmax = colormax[i];
        }
    }
    System.out.println(ret);
}