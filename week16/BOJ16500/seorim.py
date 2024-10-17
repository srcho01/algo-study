import sys

input = sys.stdin.readline

S = input().rstrip()
n = int(input())
A = [input().rstrip() for _ in range(n)]

dp = [0] * (len(S) + 1)  # 1번째 자리부터 i번째 자리까지 문자열을 만들 수 있는가
dp[0] = 1  # 0번째 자리는 시작 전을 나타내므로 1로 설정

for i in range(1, len(S)+1):
    for word in A:
        len_word = len(word)
        if len_word <= i:
            if dp[i-len_word] == 1 and S[i-len_word:i] == word:
                dp[i] = 1

print(dp[len(S)])