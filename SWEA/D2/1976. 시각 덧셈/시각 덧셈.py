T = int(input())

for test_case in range(1, T+1):
    h1, m1, h2, m2 = map(int, input().split())

    h3 = h1 + h2
    m3 = m1 + m2

    if m3 > 60:
        m3 -= 60
        h3 += 1

    if h3 > 12:
        h3 -= 12

    print(f"#{test_case} {h3} {m3}")
