def print_stars(n):
    for i in range(n):
        stars = 2 * (n - i) - 1
        spaces = i
        print(' ' * spaces + '*' * stars)


n = int(input())
print_stars(n)