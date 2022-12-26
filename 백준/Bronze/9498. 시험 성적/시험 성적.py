n = int(input())

if 100 >= n >= 90:
    result = "A"
elif 89 >= n >= 80:
    result = "B"
elif 79 >= n >= 70:
    result = "C"
elif 69 >= n >= 60:
    result = "D"
else:
    result = "F"

print(result)
