package top.geminix.circle.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.geminix.circle.dao.ILabelInfoDao;
import top.geminix.circle.domain.LabelInfo;
import top.geminix.circle.service.ILabelInfoService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LabelInfoTest {

    @Autowired
    private ILabelInfoService labelInfoService;
    @Autowired
    ILabelInfoDao labelInfoDao;

    @Test
    public void getAll() {
        List<LabelInfo> all = labelInfoService.getLabelInfo();
        for (LabelInfo labelInfo : all) {
            System.out.println(labelInfo);
        }

    }



    @Test
    public void addTest2() {
        LabelInfo labelInfo = new LabelInfo();
        labelInfo.setLabelName("dao2分类");
        int sortId = 7;
        boolean b = labelInfoDao.addLabelInfo(sortId, labelInfo.getLabelName());
        System.out.println(b);
        getAll();

    }

    @Test
    public void getByIdTest() {
        LabelInfo byLabelId = labelInfoDao.getByLabelId(5);
        System.out.println(byLabelId);
    }

    @Test
    public void getSortLabel() {
        List<LabelInfo> labelCategory = labelInfoService.getLabelCategory();
        for (LabelInfo labelInfo : labelCategory) {
            System.out.println(labelInfo);
        }
    }

}
