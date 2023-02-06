

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
    	//construct a hashtable as an index for easilier searching
        Map<Integer, Employee> hm = new HashMap<>();

        //no need to caring the duplication, for put() overriding the previous one map
        for(Employee e : employees)
        	hm.put(e.id, e);

        return bfs(id, hm);
    }

   private int bfs(int id, Map<Integer, Employee> hm){
    	int ans = 0;
       
        Queue<Integer> q = new LinkedList<>();
    	q.offer(id);
       
        while(!q.isEmpty()){
    		int e_id = q.remove();   		
    		Employee e = hm.get(e_id);

    		ans += e.importance;

    		for(Integer sub_id : e.subordinates)
    			q.offer(sub_id);
    	}
    	return ans;
    }
}