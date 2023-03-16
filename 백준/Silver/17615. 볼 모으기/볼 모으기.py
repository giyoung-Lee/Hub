n = int(input())
balls = input().strip()

cnt_list = []

# 왼쪽으로 R을 옮기는 경우
parse_ball = balls.lstrip('R')
cnt_list.append(parse_ball.count('R'))

# 왼쪽으로 B를 옮기는 경우
parse_ball = balls.lstrip('B')
cnt_list.append(parse_ball.count('B'))

# 오른쪽으로 R을 옮기는 경우
parse_ball = balls.rstrip('R')
cnt_list.append(parse_ball.count('R'))

# 오른쪽으로 R을 옮기는 경우
parse_ball = balls.rstrip('B')
cnt_list.append(parse_ball.count('B'))

print(min(cnt_list))