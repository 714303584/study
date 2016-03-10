package ${ modelClassDesc.packgeName }.model;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author zhuss
 */
@SuppressWarnings("serial")
public class ${modelClassDesc.className} implements Serializable {

		
		<#list modelClassDesc.fileds as filed> 
			private  ${filed.filedType} ${filed.filedName};
		</#list> 
		
		public ${modelClassDesc.className}() {

		}
		
		
		public ${modelClassDesc.className}(${modelClassDesc.classFieldString} ) {
				super();
			<#list modelClassDesc.fileds as filed> 
			 this.${filed.filedName} = ${filed.filedName};
			</#list>
		}
		
		
		<#list modelClassDesc.fileds as filed> 
				public  ${filed.filedType}  get${filed.filedName}() {
					return ${filed.filedName};
				}
			
				public void set${filed.filedName}(${filed.filedType}  ${filed.filedName}) {
					this.${filed.filedName} =  ${filed.filedName};
				}
		</#list> 
	@Override
	public String toString() {
		return "${modelClassDesc.className} ["+
		<#list modelClassDesc.fileds as filed> 
			" ${filed.filedName}:"+ ${filed.filedName}+
		</#list> 
		"]";
	}
}