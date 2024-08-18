for _ in range(3):
    sh, sm, ss, eh, em, es = map(int, input().split())
    result_h = eh-sh
    result_m = em-sm
    result_s = es-ss

    if result_s < 0:
        result_s = 60 + result_s
        result_m -= 1

    if result_m < 0:
        result_m = 60 + result_m
        result_h -= 1

    print(f"{result_h} {result_m} {result_s}")