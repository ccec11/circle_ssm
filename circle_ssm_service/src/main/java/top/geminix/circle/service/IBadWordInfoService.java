package top.geminix.circle.service;

import top.geminix.circle.domain.BadWordInfo;

import java.util.List;

public interface IBadWordInfoService {

    List<BadWordInfo> getAllBadWord();

    boolean addBadWordInfo(String badWordContent);

    boolean removeBadWordInfo(Integer badWordId);
}
