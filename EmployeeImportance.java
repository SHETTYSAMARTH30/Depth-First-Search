/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class EmployeeImportance {
    
    Map<Integer, Employee> emap;
    
    public int getImportance(List<Employee> employees, int id) {
        
        emap = new HashMap<>();
        
        //Save employee id -> emp data. So that we can fetch employee data faster
        for(Employee e : employees){
            
            emap.put(e.id, e);   
        }
        
        return dfs(id);
    }
    
    //We will perform DFS traversal using the map
    public int dfs(int empId){
        
        Employee emp = emap.get(empId);
        
        int ans = emp.importance;
        
        List<Integer> subList = emp.subordinates;
        
        for(Integer i : subList){
            
            ans += dfs(i);
        }
        
        return ans;
    }
}
