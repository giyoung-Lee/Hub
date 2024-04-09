def solution(park, routes):
    # 북N, 남S, 동E, 서W
    dx = [0, 0, 1, -1]
    dy = [-1, 1, 0, 0]

    position_x, position_y = 0, 0
    y_len = len(park) - 1
    x_len = 0
    for y, st in enumerate(park):
        x_len = len(st) - 1
        for x, start in enumerate(st):
            if start == 'S':
                position_x = x
                position_y = y
                break
    # print("len_x : " + str(x_len))
    # print("len_y : " + str(y_len))
    # print("position_x : " + str(position_x))
    # print("position_y : " + str(position_y))



    for rout in routes:
        direction, power = rout.split()
        if direction == "N":
            count = 0
        elif direction == "S":
            count = 1
        elif direction == "E":
            count = 2
        else:
            count = 3
        # print(direction, power)

        temp_x = position_x + (dx[count] * int(power))
        temp_y = position_y + (dy[count] * int(power))
        # print("x : " + str(temp_x) + " y : " + str(temp_y))

        if 0 > temp_x or temp_x > x_len or 0 > temp_y or temp_y > y_len:
            pass
            # print("in")

        else:
            flag = True
            temp2_x = position_x
            temp2_y = position_y
            for i in range(0, int(power)):
                temp2_x = temp2_x + dx[count]
                temp2_y = temp2_y + dy[count]
                if park[temp2_y][temp2_x] == 'X':
                    flag = False
                    break

            if flag:
                position_x = position_x + (dx[count] * int(power))
                position_y = position_y + (dy[count] * int(power))
        # print("now : " + "x : " + str(position_x) + " y : " + str(position_y))
    answer = [position_y, position_x]
    return answer