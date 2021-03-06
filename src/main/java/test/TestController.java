package test;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Controller
@RequestMapping(path="/test")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Value("${uName}")
    private String uName;

    @Value("${bookTitle}")
    private String bookTitle;
    
    @Autowired
    Configuration configuration; //freeMarker configuration  
    
    @RequestMapping("/index")
    public String index(Map<String, Object> map) throws Exception {
        // 加入一个属性，用来在模板中读取
    	logger.info("sssssssssssssssssss");
        map.put("uName", uName);
        
        map.put("bookTitle", bookTitle);
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        Template t = configuration.getTemplate("index.ftl"); // freeMarker template  
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, map);  
      
        logger.debug("deugger"+content);
        return "index";
    }
}