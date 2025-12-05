class Solution {
    public int minCost(int[][] costs) {
        if (costs == null) return 0;
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        if (k == 0) return -1;
        if (k == 1 && n > 1) return -1;

        long prevMin1Val = 0L;    
        long prevMin2Val = 0L;   
        int prevMin1Idx = -1;     

        for (int i = 0; i < n; i++) {
            long currMin1 = Long.MAX_VALUE;
            long currMin2 = Long.MAX_VALUE;
            int currMin1Idx = -1;

            for (int j = 0; j < k; j++) {
                long add = (prevMin1Idx == j) ? prevMin2Val : prevMin1Val;
                long val = costs[i][j] + add;

                if (val < currMin1) {
                    currMin2 = currMin1;
                    currMin1 = val;
                    currMin1Idx = j;
                } else if (val < currMin2) {
                    currMin2 = val;
                }
            }

            prevMin1Val = currMin1;
            prevMin2Val = currMin2;
            prevMin1Idx = currMin1Idx;
        }

      
        return (int) prevMin1Val;
    }

    
}