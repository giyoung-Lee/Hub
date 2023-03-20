def solution(wallpaper):
    answer = []
    arr = []
    arr2 = []
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                arr.append((i, j))
                arr2.append((i+1, j+1))
                
    x_1, y_1, x_2, y_2 = 50, 50, 0, 0
        
    for x1, y1 in arr:
        x_1 = min(x1, x_1)
        y_1 = min(y1, y_1)
        
    for x2, y2 in arr2:
        x_2 = max(x2, x_2)
        y_2 = max(y2, y_2)
        
    answer.append(x_1)
    answer.append(y_1)
    answer.append(x_2)
    answer.append(y_2)
        
    
    return answer