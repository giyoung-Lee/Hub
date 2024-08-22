arr = list(map(int, input().split()))

min_value = 10000

if abs((arr[0] + arr[2]) - (arr[1] + arr[3])) < min_value:
    min_value = abs((arr[0] + arr[2]) - (arr[1] + arr[3]))

if abs((arr[0] + arr[3]) - (arr[1] + arr[2])) < min_value:
    min_value = abs((arr[0] + arr[3]) - (arr[1] + arr[2]))

print(min_value)