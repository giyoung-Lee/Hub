def solution(strings, n):
    answer = sorted(strings, key=lambda strings : (strings[n], strings))

    return answer