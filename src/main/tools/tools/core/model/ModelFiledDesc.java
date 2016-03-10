package tools.core.model;

public class ModelFiledDesc {
	
	private String filedName;
	
	private String filedType;
	
	private String tableFiledName;


	public String getTableFiledName() {
		return tableFiledName;
	}

	public void setTableFiledName(String tableFiledName) {
		this.tableFiledName = tableFiledName;
	}

	public String getFiledName() {
		return filedName;
	}

	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}

	public String getFiledType() {
		return filedType;
	}

	public void setFiledType(String filedType) {
		this.filedType = filedType;
	}

	@Override
	public String toString() {
		return "ModelFiledDesc [filedName=" + filedName + ", filedType="
				+ filedType + ", tableFiledName=" + tableFiledName + "]";
	}

}
