package tools.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tools.core.model.ModelClassDesc;
import tools.core.model.ModelFiledDesc;
import tools.core.model.TableColumnDesc;
import tools.core.model.TableDesc;

public class MySQLUtils {

	public static Map<String, String> map = new HashMap<String, String>();

	static {
		map.put("int", "int");
		map.put("tinny", "int");
		map.put("tinyint", "int");
		map.put("bigint", "long");
		map.put("varchar", "String");
		map.put("char", "String");
		map.put("bit", "int");
		map.put("float", "double");
		map.put("double", "double");
		map.put("decimal", "double"); // DECIMAL
		map.put("text", "String");
		map.put("datetime", "Date");
		map.put("longtext", "String");
	}

	public static ModelClassDesc tableParseToMode(TableDesc tableDesc) {
		ModelClassDesc modelClassDesc = new ModelClassDesc();
		modelClassDesc.setClassName(getClassName(tableDesc.getTableName()));
		modelClassDesc.setFileds(getModelFiledByTableColumn(tableDesc));
		return modelClassDesc;

	}
	
	
	public static List<ModelFiledDesc> getModelFiledByTableColumn(TableDesc tableDesc){
		List<ModelFiledDesc> result = new ArrayList<ModelFiledDesc>();
		Iterator<TableColumnDesc> it = tableDesc.getTable().iterator();
		while (it.hasNext()) {
			ModelFiledDesc mfd  = new ModelFiledDesc();
			TableColumnDesc tcd =  it.next();
			mfd.setFiledName(getFiledName(tcd.getField()));
			mfd.setTableFiledName(tcd.getField());
			 String type[] = tcd.getType().split("\\(");
			 mfd.setFiledType(map.get(type[0]));
			 result.add(mfd);
		}
		return result;
	}
	
	public static String getClassName(String value){
		String fileds[] = value.split("_");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < fileds.length; i++) {
			String string = fileds[i];
			String next =  string.substring(1);
			String first = string.substring(0, 1);
			String pinjie =  first.toUpperCase()+next;
			sb.append(pinjie);
		}
		return sb.toString();
	}
	
	public static String getFiledName(String value){
		String fileds[] = value.split("_");
		StringBuffer sb = new StringBuffer();
		sb.append(fileds[0]);
		for (int i = 1; i < fileds.length; i++) {
			String string = fileds[i];
			String next =  string.substring(1);
			String first = string.substring(0, 1);
			String pinjie =  first.toUpperCase()+next;
			sb.append(pinjie);
		}
		return sb.toString();
	}

}
