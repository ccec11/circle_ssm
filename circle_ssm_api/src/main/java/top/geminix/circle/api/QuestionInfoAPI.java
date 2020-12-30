package top.geminix.circle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.geminix.circle.service.IQuestionInfoService;

/**
 * @version 1.0.0
 * @Author Zachary
 * @createTime 2020年12月15日 12:50:00
 */
@RestController
@RequestMapping("/api/question")
public class QuestionInfoAPI {
    @Autowired
    private IQuestionInfoService questionInfoService;


    public void getAllTest() {
        questionInfoService.getAllTest();
    }

}
