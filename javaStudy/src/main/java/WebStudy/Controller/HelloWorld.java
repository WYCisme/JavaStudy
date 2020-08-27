package WebStudy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static cn.hutool.core.lang.Console.log;

/**
 * @projectName: JavaStudy
 * @className: HelloWorld
 * @author: WenYichong
 * @date: 2020/8/20-9:49
 * @description: 连我自己都不知道在写什么......
 */

@Controller
@ResponseBody
@RequestMapping("/api")
public class HelloWorld {

    @RequestMapping("/hellworld/{name}")
    public String sayHello(@PathVariable String name){
        log("当前线程id：{}",Thread.currentThread().getId());
        return "Hello,"+name;
    }
}
