package ${ modelClassDesc.packgeName }.dao.impl;

import com.web.core.model.User;

public class ${modelClassDesc.className}DaoImpl extends BaseGenericDao<${modelClassDesc.className}, Long> {

	@Override
	public Class getEntityClass() {
		return ${modelClassDesc.className}DaoImpl.class;
	}

}
