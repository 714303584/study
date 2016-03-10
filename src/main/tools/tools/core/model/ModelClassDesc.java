package tools.core.model;

import java.util.ArrayList;
import java.util.List;

public class ModelClassDesc {
	
	private String packgeName;
	
	private String className;
	
	private String tableName;
	
	private List<ModelFiledDesc>  fileds = new ArrayList<ModelFiledDesc>();
	
	private String classFieldString;
	
	private String tableFieldString;
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPackgeName() {
		return packgeName;
	}

	public void setPackgeName(String packgeName) {
		this.packgeName = packgeName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<ModelFiledDesc> getFileds() {
		return fileds;
	}

	public void setFileds(List<ModelFiledDesc> fileds) {
		this.fileds = fileds;
	}

	public String getClassFieldString() {
		return classFieldString;
	}

	public void setClassFieldString(String classFieldString) {
		this.classFieldString = classFieldString;
	}

	public String getTableFieldString() {
		return tableFieldString;
	}

	public void setTableFieldString(String tableFieldString) {
		this.tableFieldString = tableFieldString;
	}

	public void format(){
		StringBuilder sbClass = new StringBuilder();
		StringBuilder sbTable = new StringBuilder();
		int endPosition = fileds.size()-1;
		for (int i = 0; i < fileds.size(); i++) {
			ModelFiledDesc mfd = fileds.get(i);
			if(i < endPosition){
				sbClass.append(mfd.getFiledType()+" "+mfd.getFiledName()+", ");
				sbTable.append(mfd.getTableFiledName()+", ");
			}else{
				sbClass.append(mfd.getFiledType()+" "+mfd.getFiledName()+" ");
				sbTable.append(mfd.getTableFiledName()+" ");
			}
		}
		classFieldString = sbClass.toString();
		tableFieldString = sbTable.toString();
		System.out.println(classFieldString);
		System.out.println(tableFieldString);
	}
	
	@Override
	public String toString() {
		return "ModelClassDesc [packgeName=" + packgeName + ", className="
				+ className + ", fileds=" + fileds + "]";
	}

}
