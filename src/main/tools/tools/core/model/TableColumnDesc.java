package tools.core.model;

public class TableColumnDesc {
	
	private String field;
	
	private String type;
	
	private String isNull;

	private String isKey;
	
	private String default_;
	
	private String extra;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public String getIsKey() {
		return isKey;
	}

	public void setIsKey(String isKey) {
		this.isKey = isKey;
	}

	public String getDefault_() {
		return default_;
	}

	public void setDefault_(String default_) {
		this.default_ = default_;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "TableColumnDesc [field=" + field + ", type=" + type
				+ ", isNull=" + isNull + ", isKey=" + isKey + ", default_="
				+ default_ + ", extra=" + extra + "]";
	}
	
	
	
}
