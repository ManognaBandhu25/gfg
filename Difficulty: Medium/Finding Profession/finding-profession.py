class Solution:
    def profession(self, level, pos):
        c = 1
        pos -= 1
        while pos:
            c += pos % 2
            pos //= 2
        return ('Doctor', 'Engineer')[c % 2]