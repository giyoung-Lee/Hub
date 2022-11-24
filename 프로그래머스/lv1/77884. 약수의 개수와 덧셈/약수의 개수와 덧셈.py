def solve(num):
    count = 0
    for i in range(1, num+1):
        if num%i == 0:
            count +=1
    return count

def solution(left, right):
    answer = 0
    for i in range(left, right+1):
        if solve(i) % 2 == 0:
            answer += i
        else:
            answer -= i
            
    return answer