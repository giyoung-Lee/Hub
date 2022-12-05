import string

tmp = string.digits+string.ascii_lowercase

def cal(num, base):
    q, r = divmod(num, base)
    if q == 0 :
        return tmp[r] 
    else :
        return cal(q, base) + tmp[r]

def solution(n):
    answer = ''
    n = cal(n, 3)
    for i in n[::-1]:
        answer += i
        
    answer = int(answer, 3)
    
    return answer