class Solution {
    int floorSqrt(int n) {
        // code here
        int low=1, high = n, mid, res=0;
        while(low<=high)
        {
            mid= (low+high)/2;
            if((mid*mid) == n)
            {
                res = mid;
                break;
            }else if ((mid*mid) < n)
            {
                res = mid;
                low = mid+1;
            }else
            {
                high = mid-1;
            }
        }
        return res;
    }
}