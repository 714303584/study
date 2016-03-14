package ${ modelClassDesc.packgeName }.dao.impl;

import com.web.core.model.User;

public class ${modelClassDesc.className}DaoImpl<${modelClassDesc.className},Long> extends BaseGenericDao<${modelClassDesc.className}, Long> {

	@Override
	public Class getEntityClass() {
		return ${modelClassDesc.className}DaoImpl.class;
	}

}
