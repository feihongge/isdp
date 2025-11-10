package edu.scau.mis_pos.service;

import edu.scau.mis.common.annotation.Lowercase;


public interface TestService {
     String ValidField = null; // 故意大写开头触发异常
    public void TestMethod();
}
