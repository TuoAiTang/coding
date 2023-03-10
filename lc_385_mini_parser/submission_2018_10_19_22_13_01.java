

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

	public NestedInteger deserialize(String s) {
		int len = s.length();
		if (!s.startsWith("[")) {
			NestedInteger ni = new NestedInteger(Integer.parseInt(s));
			return ni;
		}
		NestedInteger root = new NestedInteger();
		Stack<NestedInteger> stack = new Stack<>();
		stack.push(root);
		for (int i = 1; i < len - 1; i++) {
			char c = s.charAt(i);
			if (c == '[') {
				NestedInteger ni = new NestedInteger();
				stack.peek().add(ni);
				stack.push(ni);
			} else if (c == ',') {
				continue;
			} else if (c == ']') {
				stack.pop();
			} else {
				int start = i;
				while (i < len - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
					i++;
				}
				int end = i;
				stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(start, end + 1))));
			}
		}
		return stack.pop();
	}

}