n = int(input("Enter number of frames: "))
arr = []

for i in range(n):
    word = input()
    arr.append(word)
    length = len(word)
    len_str = str(length)
    arr[i] = len_str + arr[i]
print(''.join(arr))
