package cn.ccrm.admin.web;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ccrm.admin.common.ueditor.ActionEnter;

@Controller
@RequestMapping("/ueditor")
public class UeditorController {

	private Logger logger = LoggerFactory.getLogger(UeditorController.class);

	private String rootPath;

	private String projectPath = null;

	@Autowired
	private Environment environment;

	private final static String staticPath = "/public";

	public UeditorController() {
		String path = UeditorController.class.getClassLoader().getResource("config.json").getPath();
		File file = new File(path);
		if (file.getParentFile().isDirectory()) {
			rootPath = new File(path).getParent() + "/";
		} else {
			rootPath = new File(path).getParentFile().getParent() + "/";
			rootPath = rootPath.replace("file:", "");
		}
	}

	private String getProjectPath() {
		if (null == projectPath) {
			String val = environment.getProperty("server.context-path", "");
			if ("".equals(val)) {
				val = environment.getProperty("server.contextPath", "");
				if ("".equals(val)) {
					projectPath = "";
					return projectPath;
				}
			}
			projectPath = val.replace("/", "") + "/";
		}
		return projectPath;
	}

	@RequestMapping("exec")
	public void exec(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		response.setHeader("Content-Type", "text/html");
		logger.info("rootPath->" + rootPath + ",staticPath->" + staticPath + ",projectPath->" + getProjectPath());
		out.write(new ActionEnter(request, rootPath, staticPath, getProjectPath()).exec());
	}
}
