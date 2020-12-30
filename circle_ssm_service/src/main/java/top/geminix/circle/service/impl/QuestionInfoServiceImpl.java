package top.geminix.circle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.geminix.circle.dao.IQuestionInfoDao;
import top.geminix.circle.service.IQuestionInfoService;

/**
 * @version 1.0.0
 * @Author Zachary
 * @createTime 2020年12月15日 12:55:00
 */
@Service
public class QuestionInfoServiceImpl implements IQuestionInfoService {
    @Autowired
    private IQuestionInfoDao questionInfoDao;

    @Override
    public void getAllTest() {
//        questionInfoDao.getAllTest();

    }
}
