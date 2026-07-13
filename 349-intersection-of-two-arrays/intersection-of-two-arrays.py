class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        flag = [False] * 1001

        for num in nums1:
            flag[num] = True

        ans = []
        for num in nums2:
            if flag[num]:
                ans.append(num)
                flag[num] = False

        return ans