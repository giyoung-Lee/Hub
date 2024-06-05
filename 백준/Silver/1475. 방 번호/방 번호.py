n = input()

dict_ = {"0": 0, "1": 0, "2": 0, "3": 0, "4": 0, "5": 0, "6": 0, "7": 0, "8": 0, "9": 0}

for i in n:
    dict_[i] = dict_.get(i, 0) + 1

temp = (dict_["9"] + dict_["6"] + 1) // 2

dict_["6"], dict_["9"] = temp, temp

max1 = 0
for i in dict_:
    if max1 < dict_.get(i):
        max1 = dict_[i]

print(max1)