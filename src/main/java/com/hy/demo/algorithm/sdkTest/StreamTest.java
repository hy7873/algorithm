package com.hy.demo.algorithm.sdkTest;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: wanghai
 * @Date:2019/11/11 14:39
 * @Copyright:reach-life
 * @Description:
 */
public class StreamTest {

    @Test
    public void testMap() {
        List<Integer> list = Arrays.asList(2,3,5);
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    @Test
    public void testEnum() {
        List<UserInfoDto> userInfoDtos = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setUserName("xx" + i);
            userInfoDto.setId(i);
            userInfoDtos.add(userInfoDto);
        }
        final List<UserInfoDto> userInfoDtosFinal = userInfoDtos;
        userInfoDtos = userInfoDtos.stream().filter(userInfoDto -> userInfoDto.getId() % 2 == 0).collect(Collectors.toList());
        System.out.println(new Gson().toJson(userInfoDtos));
        System.out.println("-----------------------------------------");
        System.out.println(new Gson().toJson(userInfoDtosFinal));
    }

    @Test
    public void testEnum2() {
        List<UserInfoDto> userInfoDtos = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setUserName("xx" + i);
            userInfoDto.setId(i);
            userInfoDtos.add(userInfoDto);
        }
        Map<Integer,UserInfoDto> userInfoDtoMap = userInfoDtos.stream().collect(Collectors.toMap(UserInfoDto::getId, Function.identity()));
        Integer i = 5;
        UserInfoDto userInfoDto = userInfoDtoMap.get(i);
        userInfoDto.setUserName("ccc");
        System.out.println(new Gson().toJson(userInfoDtos));
    }

}
