from collections import deque

def solution(A, B):
    answer = -1
    tmp = deque(A)
    
    for i in range(len(A)):
        tmp2 = ''.join(tmp)
        if tmp2 == B:
            answer = i
            break
        tmp.rotate(1)
        
    return answer