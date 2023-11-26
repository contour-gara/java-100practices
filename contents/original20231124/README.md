# 共有会 2023/11/24
## 問題
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

以下の例のように、ある整数nに対して0~nまでの各整数を２進数で表した際に、その数に含まれる1の数を表示せよ。



Example 1:
```
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
```


Example 2:
```
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
```

https://leetcode.com/problems/counting-bits/
