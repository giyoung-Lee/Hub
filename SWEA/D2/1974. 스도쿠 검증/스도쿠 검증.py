def check_sudoku(puzzle):
    # 가로, 세로, 작은 격자에 사용된 숫자들을 체크하기 위한 set
    row_set = [set() for _ in range(9)]
    col_set = [set() for _ in range(9)]
    box_set = [set() for _ in range(9)]

    for i in range(9):
        for j in range(9):
            num = puzzle[i][j]
            box_index = (i // 3) * 3 + (j // 3)
            if num in row_set[i] or num in col_set[j] or num in box_set[box_index]:
                # 숫자가 이미 사용되었다면 스도쿠가 성립하지 않으므로 0을 리턴
                return 0
            else:
                row_set[i].add(num)
                col_set[j].add(num)
                box_set[box_index].add(num)

    # 모든 숫자가 사용되지 않았다면 스도쿠가 성립하지 않으므로 0을 리턴
    return 1


# 입력 받기
T = int(input())
puzzles = []
for _ in range(T):
    puzzle = [list(map(int, input().split())) for _ in range(9)]
    puzzles.append(puzzle)

# 스도쿠 체크하기
for t in range(T):
    puzzle = puzzles[t]
    ans = check_sudoku(puzzle)
    print(f"#{t+1} {ans}")
