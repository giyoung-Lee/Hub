N = int(input())
M = int(input())

recommendations = list(map(int, input().split()))
frames = []
counts = {}

for student in recommendations:
    if student in counts:
        counts[student] += 1
    else:
        if len(frames) < N:
            frames.append(student)
            counts[student] = 1
        else:
            # 가장 적은 추천 횟수를 가진 학생을 찾기
            min_recommendation = min(counts[stu] for stu in frames)
            candidates = [stu for stu in frames if counts[stu] == min_recommendation]
            # 가장 오래된 학생을 제거
            to_remove = candidates[0]
            frames.remove(to_remove)
            del counts[to_remove]

            frames.append(student)
            counts[student] = 1

for i in sorted(frames): print(i, end=" ")