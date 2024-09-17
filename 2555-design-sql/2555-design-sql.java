class SQL {
    Map<String, Table>tables;
    public SQL(List<String> names, List<Integer> columns) {
        tables = new HashMap<>();
        for(int i=0;i<names.size();i++){
            tables.put(names.get(i), new Table(columns.get(i)));
        }
        
    }
    
    public void insertRow(String name, List<String> row) {
        tables.get(name).insert(row);
    }
    
    public void deleteRow(String name, int rowId) {
        tables.get(name).delete(rowId);
    }
    
    public String selectCell(String name, int rowId, int columnId) {
        return tables.get(name).getCell(rowId, columnId);
    }
}
 class Table{
    private int id=0;
    Map<Integer, List<String>>rows;
    public Table(int columns){
        rows = new HashMap<>();
    }
    public void insert(List<String>row){
        rows.put(++id, row);
    }
    public void delete(int rowId){
        rows.remove(rowId);
    }
    public String getCell(int rowId, int columnId){
        return rows.get(rowId).get(columnId-1);
    }
}
/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * obj.insertRow(name,row);
 * obj.deleteRow(name,rowId);
 * String param_3 = obj.selectCell(name,rowId,columnId);
 */