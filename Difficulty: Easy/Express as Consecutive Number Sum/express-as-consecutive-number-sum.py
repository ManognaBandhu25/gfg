class Solution:
    def isSumOfConsecutive(self, n: int) -> bool:
        # code here
        sum = 1
        terms = 2
        while n>sum:
            #print(sum)
            if (n-sum) %terms == 0:
                return True
            terms+=1
            sum = (terms*(terms-1))//2
        return False