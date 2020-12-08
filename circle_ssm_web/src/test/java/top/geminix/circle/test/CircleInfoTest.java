package top.geminix.circle.test;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import top.geminix.circle.domain.UserInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.service.ICircleInfoService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CircleInfoTest {

    @Autowired
    private ICircleInfoService circleInfoService;

    @Test
    public void getBanned() {

        List<CircleInfo> bannedCircleInfo = circleInfoService.getBannedCircleInfo(-1);
        Gson gson = new Gson();
        String toJson = gson.toJson(bannedCircleInfo);
        System.out.println(toJson);
    }

    @Test
    public void unBanCircle() {
        boolean b = circleInfoService.modifyCircleStatusToNormal(2,0);
        System.out.println(b);
    }

    @Test
    public void banCircle() {
        boolean b = circleInfoService.modifyCircleStatusToBanned(4,0);
        System.out.println(b);
    }

    @Test
    public void getReported() {
        List<CircleInfo> reportedCircleInfo = circleInfoService.getReportedCircleInfo();
        for (CircleInfo circleInfo : reportedCircleInfo) {
            System.out.println(circleInfo);
        }
    }

    @Test
    public void getInvalid() {
        List<CircleInfo> invalidCircleInfo = circleInfoService.getInvalidCircleInfo(-1);
        for (CircleInfo circleInfo : invalidCircleInfo) {
            System.out.println(circleInfo);
        }
    }

    @Test
    public void getOne() {
        CircleInfo selectedCircle = circleInfoService.getSelectedCircle(1);
        System.out.println(selectedCircle);

    }




}
