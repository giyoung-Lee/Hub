def solution(s):
    answer = 0
    while s:
        tmp1 = 1
        tmp2 = 0
        count = 1
        
        for i in range(1, len(s)):
            if tmp1 != tmp2:
                if s[0] == s[i]:
                    tmp1 += 1
                if s[0] != s[i]:
                    tmp2 += 1
                    
                count += 1
            else:
                answer += 1
                break
        s = s[count:]
    
    return answer+1