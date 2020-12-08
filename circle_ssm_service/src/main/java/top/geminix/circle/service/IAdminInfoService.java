package top.geminix.circle.service;


import top.geminix.circle.domain.AdminInfo;




public interface IAdminInfoService {


    AdminInfo queryAdminInfoByNameAndPassword(String adminName, String adminPassword);

}
