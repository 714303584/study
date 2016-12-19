package tools.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import tools.core.model.ModelClassDesc;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtils {

	private static Configuration config = new Configuration();

	static {
		String url = FreeMarkerUtils.class.getResource("/").getPath()
				+ "tools/core/template/";
		System.out.println(url);
		try {
			config.setDirectoryForTemplateLoading(new File(url));
			config.setObjectWrapper(new DefaultObjectWrapper());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void outModel(ModelClassDesc modelClassDesc)
			throws IOException, TemplateException {
		Template temp = config.getTemplate("model.ftl");
		String path = modelClassDesc.getPackgeName().replace(".", "/") + "/model/";

		File file = new File(FreeMarkerUtils.class.getResource("/").getPath()
				+ "/src/" + path);
		if (!file.exists()) {
			file.mkdirs();
		}
		File file2 = new File(FreeMarkerUtils.class.getResource("/").getPath()
				+ "src/" + path + modelClassDesc.getClassName() + ".java");
		if (file2.exists()) {
			file2.delete();
		}
		file2.createNewFile();
		FileWriter fw = new FileWriter(file2);
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("modelClassDesc", modelClassDesc);
		temp.process(root, fw);
		temp.process(root, new OutputStreamWriter(System.out));
		fw.flush();
		fw.close();
	}

	public static void outMapper(ModelClassDesc modelClassDesc)
			throws IOException, TemplateException {
		String mapperName = "mapper.ftl";
		String srcPath = FreeMarkerUtils.class.getResource("/").getPath().split("bin")[0]+"src/";
		System.out.println("srcPath:"+srcPath);
		String packagePath = srcPath + modelClassDesc.getPackgeName().replace(".", "/")+"/model/mapper/";
		System.out.println("packagePath:"+packagePath);
		File packageFile = new File(packagePath);
		if(!packageFile.exists()){
			packageFile.mkdirs();
		}
		String filePath = packagePath+modelClassDesc.getClassName()+"Mapper.xml";
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("modelClassDesc", modelClassDesc);
		outMapper(filePath,root, mapperName);
	}
	
	
	public static void outDao(ModelClassDesc modelClassDesc) throws IOException, TemplateException{
		String mapperName  = "dao.ftl";
		String srcPath = FreeMarkerUtils.class.getResource("/").getPath().split("bin")[0]+"src/";
		String packagePath = srcPath + modelClassDesc.getPackgeName().replace(".", "/")+"/dao/";
		File packagefile = new File(packagePath);
		if(!packagefile.exists()){
			packagefile.mkdir();
		}
		System.out.println("packagePath:"+packagePath);
		String filePath = packagePath + modelClassDesc.getClassName()+"Dao.java";
		Map<String,Object> root = new HashMap<String, Object>();
		root.put("modelClassDesc", modelClassDesc);
		outMapper(filePath,root,mapperName);
		
	}
	
	public static void outMapper(String filePath,Map<String, Object> root , String tempName) throws IOException, TemplateException{
		Template temp = config.getTemplate(tempName);
		File outFile = new File(filePath);
		if(outFile.exists()){
			outFile.delete();
		}
		outFile.createNewFile();
		FileWriter out = new FileWriter(outFile);
		temp.process(root, out);
		temp.process(root, new OutputStreamWriter(System.out));
		out.flush();
		out.close();
	}
	
	
	public static void outCode(ModelClassDesc modelClassDesc) throws IOException{
		Template mapperTemp = config.getTemplate("mapper.ftl");
		Template modelTemp = config.getTemplate("model.ftl");
		Template daoTemp = config.getTemplate("dao.ftl");
		String srcPath = FreeMarkerUtils.class.getResource("/").getPath().split("bin")[0]+"src/";
		System.out.println("srcPath:"+srcPath);
		String packagePath = srcPath + modelClassDesc.getPackgeName().replace(".", "/");
		System.out.println("packagePath:"+packagePath);
		File packagePathFile = new File(packagePath);
		if(packagePathFile.exists()){
			packagePathFile.mkdirs();
		}
		String modelName = modelClassDesc.getClassName()+".java";
		String mapperName = modelClassDesc.getClassName()+"mapper.xml";
		String daoName = modelClassDesc.getClassName()+"DaoImpl.java";
		File modelJava = new File(packagePath+"/model/"+modelName);
		File mapperFile = new File(packagePath+"/model/mapper/"+mapperName);
//		File
		
	}

	public static void outCode(String tempName,String outName,ModelClassDesc modelClassDesc) throws IOException{
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("modelClassDesc", modelClassDesc);
//		outMapper(filePath, root, tempName);
	}
	
	

	public static void main(String[] args) {
	}

	public static void outController(ModelClassDesc mcd) throws IOException, TemplateException {
		String mapperName  = "controller.ftl";
		String srcPath = FreeMarkerUtils.class.getResource("/").getPath().split("bin")[0]+"src/";
		String packagePath = srcPath + mcd.getPackgeName().replace(".", "/")+"/dao/";
		File packagefile = new File(packagePath);
		if(!packagefile.exists()){
			packagefile.mkdir();
		}
		System.out.println("packagePath:"+packagePath);
		String filePath = packagePath + mcd.getClassName()+"Controller.java";
		Map<String,Object> root = new HashMap<String, Object>();
		root.put("modelClassDesc", mcd);
		outMapper(filePath,root,mapperName);
		
	}

}
