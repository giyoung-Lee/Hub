list_ = ["ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"]

st = input().strip()

count = 0

for char in st:
    for i, group in enumerate(list_):
        if char in group:
            count += i + 3  # 각 그룹의 시작 시간이 2초 더하기 각 인덱스 (0부터 시작) + 1

print(count)