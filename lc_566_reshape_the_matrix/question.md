「每日一题 566 - 重塑矩阵」
「难度」: Easy
「标签」: 数组、矩阵、模拟
「题目」: 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。

给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。

重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。

如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。

 

示例 1：

输入：mat = [[1,2],[3,4]], r = 1, c = 4
输出：[[1,2,3,4]]


示例 2：

输入：mat = [[1,2],[3,4]], r = 2, c = 4
输出：[[1,2],[3,4]]


 

提示：


	m == mat.length
	n == mat[i].length
	1 <= m, n <= 100
	-1000 <= mat[i][j] <= 1000
	1 <= r, c <= 300


「提示1」Do you know how 2d matrix is stored in 1d memory? Try to map 2-dimensions into one.
「提示2」M[i][j]=M[n*i+j] , where n is the number of cols. 
This is the one way of converting 2-d indices into one 1-d index.  
Now, how will you convert 1-d index into 2-d indices?
「提示3」Try to use division and modulus to convert 1-d index into 2-d indices.
「提示4」M[i] =>  M[i/n][i%n] Will it result in right mapping? Take some example and check this formula.
「题解」: https://leetcode-cn.com/problems/reshape-the-matrix/solution/