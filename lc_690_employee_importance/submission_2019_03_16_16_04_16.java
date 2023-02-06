

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
    public Map<Integer, Employee> m;
    public int getImportance(List<Employee> employees, int id) {
        //<id, employee>
        m = new HashMap<>();
        for(Employee e : employees)
            m.put(e.id, e);
        
        Employee p = m.get(id);
        return dfs(p);
    }
    
    public int dfs(Employee p){
        int ipt = p.importance;
        for(int i : p.subordinates){
            Employee e = m.get(i);
            ipt += dfs(e);
        }
        return ipt;
    }
}