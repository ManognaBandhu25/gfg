class Solution:
    def ExcelColumnNumber(self, s):
        res = 0
        for ch in s:
            digit = ord(ch) - 64
            res = res*26 + digit
        return res