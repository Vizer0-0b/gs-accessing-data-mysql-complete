package hello;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
@RequestMapping(path="/web")
public class WebContrpller {  
    @Value("${application.message:1234556677}")  
    private String message = "hi,hello world......";  
  
    // 请求
    @RequestMapping("/wb")
    public String web(Map<String,Object> model){  
        model.put("time",new Date(0));  
        model.put("message",this.message);
        return "web";//返回的内容就是templetes下面文件的名称  
    }  
}  