class Solution:
    def reverseBits(self, n: int) -> int:
        ans = 0
        
        
        for _ in range(32):
            last_bit = n & 1
            ans = ans << 1
            ans = ans | last_bit
            n = n >> 1
        
        
        return ans