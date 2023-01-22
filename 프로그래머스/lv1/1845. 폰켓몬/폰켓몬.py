from collections import Counter

def solution(nums):
    tmp = Counter(nums)
    cnt1 = len(tmp)
    cnt2 = len(nums)/2
    
    answer = 0
    
    if cnt1 <= cnt2:
        answer = cnt1
    else:
        answer = cnt2
    
    return answer