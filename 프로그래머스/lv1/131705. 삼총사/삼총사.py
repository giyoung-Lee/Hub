import itertools

def solution(number):
    answer = 0
    
    for case in list(itertools.combinations(number, 3)):
        if sum(case) == 0:
            answer += 1
    
    return answer