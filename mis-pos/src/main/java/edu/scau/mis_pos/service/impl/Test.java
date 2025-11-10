package edu.scau.mis_pos.service.impl;

import edu.scau.mis.common.annotation.Lowercase;
import edu.scau.mis.common.validator.LowercaseValidate;
import edu.scau.mis_pos.service.TestService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.lang.annotation.Annotation;
@Lowercase
@Service
public class Test implements TestService {

    private String ValidField = null;
    // 故意大写开头触发异常

    public void TestMethod() {}
   @PostConstruct
    public void init() {
       LowercaseValidate.validate(this.getClass());// 触发检查
    }
}
