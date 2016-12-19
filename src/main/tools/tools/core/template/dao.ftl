package ${ modelClassDesc.packgeName }.dao;

import com.blog.entity.${modelClassDesc.className};
import java.util.List;
import java.util.Map;


public interface ${modelClassDesc.className}DaoImpl {
	
	public ${modelClassDesc.className} getById(long id);
	
	public void save(${modelClassDesc.className} entity);
	
	public List<${modelClassDesc.className}> findListBy(Map<String, Object> map);
	
	public List<${modelClassDesc.className}> findPageBy(Map<String, Object> map);
	
	public void deleteByIds(long[] ids);
	
	public void update(${modelClassDesc.className} entity);
	
	public int getCountBy(Map<String, Object> map);

}
	
