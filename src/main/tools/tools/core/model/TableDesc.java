package tools.core.model;

import java.util.List;

public class TableDesc {
	
	/**
	 * Table Name
	 */
	private String tableName;
	
	/**
	 * Column 
	 */
	private List<TableColumnDesc> table;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<TableColumnDesc> getTable() {
		return table;
	}

	public void setTable(List<TableColumnDesc> table) {
		this.table = table;
	}
	
	 

}
