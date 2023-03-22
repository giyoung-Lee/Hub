from collections import deque


def solution(cards1, cards2, goal):
    answer = ''
    cards1 = deque(cards1)
    cards2 = deque(cards2)
    count = 0

    for i in range(len(goal)):
        if len(cards1) != 0 and cards1[0] == goal[i]:
            cards1.popleft()
            count += 1
        elif len(cards2) != 0 and cards2[0] == goal[i]:
            cards2.popleft()
            count += 1
        else:
            pass

    if count == len(goal):
        answer = "Yes"
    else:
        answer = "No"

    return answer