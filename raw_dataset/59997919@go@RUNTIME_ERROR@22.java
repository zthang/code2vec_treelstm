    public void go() throws IOException
    {
        ntok();
        int n = ipar();
        ntok();
        int[] arr = iapar(n);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            list.add(new ArrayList<Integer>());
            list.get(i).add(i*2);
        }
        for (int i = 0; i < n; i++)
        {
            int offset = arr[i]-1;
            if (i + offset < n)
            {
                list.get(i+offset).add(i*2+1);
            }
            else
            {
                list.get(i-offset).add(i*2+1);
            }
        }
        for (int i = 0; i < n-1; i++)
        {
            out.print(list.get(i).get(0)+1);
            out.print(" ");
            out.println(list.get(i+1).get(0)+1);
        }
        for (int i = 0; i < n; i++)
        {
            for (int e = 1; e < list.get(i).size(); e++)
            {
                out.print(list.get(i).get(0)+1);
                out.print(" ");
                out.println(list.get(i).get(e)+1);
            }
        }

        out.flush();
        in.close();
    }