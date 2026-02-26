class Solution:
     def areIsomorphic(self, s1, s2):
          # code here
          st1 = {}
          st2 = {}

          n = len(s1)
          for i in range(n):
               if s1[i] in st1 or s2[i] in st2:
                    if st1.get(s1[i]) != s2[i] or st2.get(s2[i]) != s1[i]:
                         return False
               else:
                    st1[s1[i]] = s2[i]
                    st2[s2[i]] = s1[i]
          return True