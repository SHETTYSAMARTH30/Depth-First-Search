class MergeAccounts {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        //Creating an adjacency list
        Map<String, Set<String>> graph = new HashMap<>();
        
        //We map email to name. We use this map to enter name at the beginning of resultant list
        Map<String, String> emailToName = new HashMap<>();
        
        //Create an adjacency list
        buildGraph(accounts, graph, emailToName);
        
        //We will perform DFS on graph and add all the linked emails to a list, then fetch the name from emailToName list and add at beginning of resultant list
        //To check whether we dont visit same node/email twice
        Set<String> visited = new HashSet<>();
        
        //Stores result
        List<List<String>> result = new ArrayList<>();
        
        //We can even write graph.keySet()
        for(String email : emailToName.keySet()){
            
            List<String> list = new ArrayList();
            
            if(!visited.contains(email)){
                
                visited.add(email);
                list.add(email);
                dfs(graph, email, visited, list);
                
                //Sorting all emails in list
                Collections.sort(list);
                
                //Add the name at top of result list
                list.add(0, emailToName.get(email));
                
                //Add list to final result
                result.add(list);
            }
            
        }
        
        return result;
        
        
    }
    
    public void buildGraph(List<List<String>> accounts, Map<String, Set<String>> graph, Map<String, String> emailToName){
        
        for(List<String> acc : accounts){
            
            String name = acc.get(0);
            
            //We will iterate all the emails in the accounts
            //Skip i=0 as it will be always name
            for(int i = 1; i < acc.size(); i++){
               
                String email = acc.get(i);
                graph.putIfAbsent(email, new HashSet());
                
                //Map email to name
                emailToName.put(email, name);
                
                //It means it has no prev so we cant add an edge
                if(i == 1)
                    continue;
                
                //Get prev email to current email
                String prev = acc.get(i - 1);
                
                //Create a edge between 2 emails
                graph.get(email).add(prev);
                graph.get(prev).add(email);
                
            }
        }
    }
    
    //We perform dfs and add all connected emails to result list
    public void dfs(Map<String, Set<String>> graph, String mail, Set<String> visited, List<String> list){
        
            //The mail doesnt have edges/neighbors
            if(graph.get(mail) == null || graph.get(mail).size() == 0)
                return;
        
            //Visit all the neighboring emails connected to mail
            for(String nei : graph.get(mail)){
                
                //If you have not visited a email then perform dfs on it
                if(!visited.contains(nei)){
                    
                    visited.add(nei);
                    
                    list.add(nei);
                    
                    dfs(graph, nei, visited, list);
                }
                
            }
    }
              
}
