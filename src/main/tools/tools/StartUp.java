package tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tools.core.FreeMarkerUtils;
import tools.core.MySQLConnect;
import tools.core.MySQLUtils;
import tools.core.model.ModelClassDesc;
import tools.core.model.TableDesc;

public class StartUp {

	public static ModelClassDesc getClassDesc(TableDesc tableDesc,
			String packageName) {
		return MySQLUtils.tableParseToMode(tableDesc);
	}

	public static void main(String[] args) {
		try {
			List<String> list = MySQLConnect.getAllTables("show tables",
					"blog");

			String packeName = "com.blog";

			Iterator<String> it = list.iterator();
			List<ModelClassDesc> mcds = new ArrayList<ModelClassDesc>();
			while (it.hasNext()) {
				String tableName = it.next();
				TableDesc td = new TableDesc();
				td.setTableName(tableName);
				td.setTable(MySQLConnect.getColumns("DESC " + tableName));
				ModelClassDesc mcd = MySQLUtils.tableParseToMode(td);
				System.err.println(mcd.getTableName());
				mcd.setTableName(tableName);
				mcds.add(mcd);
				mcd.setPackgeName(packeName);
				mcd.format();
				FreeMarkerUtils.outModel(mcd);
				FreeMarkerUtils.outMapper(mcd);
				FreeMarkerUtils.outDao(mcd);;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
