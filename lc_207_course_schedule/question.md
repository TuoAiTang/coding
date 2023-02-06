「每日一题 207 - 课程表」
「难度」: Medium
「标签」: 深度优先搜索、广度优先搜索、图、拓扑排序
「题目」: 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。


	例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。


请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

 

示例 1：

输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。

示例 2：

输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。

 

提示：


	1 <= numCourses <= 105
	0 <= prerequisites.length <= 5000
	prerequisites[i].length == 2
	0 <= ai, bi < numCourses
	prerequisites[i] 中的所有课程对 互不相同


「提示1」This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
「提示2」<a href="https://class.coursera.org/algo-003/lecture/52" target="_blank">Topological Sort via DFS</a> - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
「提示3」Topological sort could also be done via <a href="http://en.wikipedia.org/wiki/Topological_sorting#Algorithms" target="_blank">BFS</a>.
「题解」: https://leetcode-cn.com/problems/course-schedule/solution/