n = int(input())

max_name = ""
max_age = 0
min_name = ""
min_age = 20111231

for _ in range(n):
    name, day, month, year = input().split()

    if len(day) == 1:
        day = "0" + day
    if len(month) == 1:
        month = "0" + month

    now = int(year+month+day)
    if now > max_age:
        max_age = now
        max_name = name

    if now < min_age:
        min_age = now
        min_name = name


print(max_name)
print(min_name)