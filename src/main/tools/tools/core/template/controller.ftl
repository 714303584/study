package com.blog.net.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.dao.NavigationDaoImpl;
import com.blog.entity.${modelClassDesc.className};
import com.blog.util.page.DefaultPage;

@Controller("admin${modelClassDesc.className}Controller ")
@RequestMapping("/admin/${modelClassDesc.className?lower_case}")
public class NavigationController {

	@Autowired(required = true)
	${modelClassDesc.className}DaoImpl ${modelClassDesc.className?lower_case}DaoImpl;

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public String save(${modelClassDesc.className} ${modelClassDesc.className?lower_case}, ModelMap model) {
		${modelClassDesc.className?lower_case}DaoImpl.save(${modelClassDesc.className?lower_case});
		return "redirect:/admin/${modelClassDesc.className?lower_case}/list.html";
	}

	@RequestMapping(value = "/edit", method = { RequestMethod.POST })
	public String edit(${modelClassDesc.className} ${modelClassDesc.className?lower_case}, ModelMap model) {
		${modelClassDesc.className?lower_case}DaoImpl.update(${modelClassDesc.className?lower_case});
		return "redirect:/admin/${modelClassDesc.className?lower_case}/list.html";
	}

	@RequestMapping(value = "/deleteByIds", method = { RequestMethod.POST })
	public String deleteByIds(long[] ids, ModelMap model) {
		if (ids != null) {
			${modelClassDesc.className?lower_case}DaoImpl.deleteByIds(ids);
		}
		return "redirect:/admin/${modelClassDesc.className?lower_case}/list.html";
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String list(@RequestParam Map<String, Object> filter, ModelMap model) {
		DefaultPage<${modelClassDesc.className}> pages = new DefaultPage<${modelClassDesc.className}>();
		
		Object pageVal =  filter.get("page");
		if(pageVal != null){
		 int page = Integer.parseInt(pageVal.toString()) - 1;
			filter.remove("page");
			pages.setPageNo(page);
		}
		
		Object pageSizeVal = filter.get("pageSize");
		if(pageSizeVal != null){
		  int pageSize = Integer.parseInt(pageSizeVal.toString());
			filter.remove("pageSize");
			pages.setPageSize(pageSize);
		}
		
		int total = ${modelClassDesc.className?lower_case}DaoImpl.getCountBy(filter);
		
		pages.setTotalCount(total);
		
		filter.put("page", pages.pageSql());
		List<${modelClassDesc.className}> elements = ${modelClassDesc.className?lower_case}DaoImpl.findPageBy(filter);
		pages.setElements(elements);
		model.put("pages", pages);
		return "${modelClassDesc.className?lower_case}/list";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET })
	public String add(ModelMap model) {
		return "${modelClassDesc.className?lower_case}/add";
	}

	@RequestMapping(value = "/show/{id}", method = { RequestMethod.GET })
	public String add(long id, ModelMap model) {
		${modelClassDesc.className} entity = ${modelClassDesc.className?lower_case}DaoImpl.getById(id);
		model.put("entity", entity);
		return "${modelClassDesc.className?lower_case}/edit";
	}

	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET })
	public String deleteById(@PathVariable long id, ModelMap model) {
		long[] ids = new long[1];
		ids[0] = id;
		${modelClassDesc.className?lower_case}DaoImpl.deleteByIds(ids);
		return "redirect:/admin/${modelClassDesc.className?lower_case}/list.html";
	}

}
