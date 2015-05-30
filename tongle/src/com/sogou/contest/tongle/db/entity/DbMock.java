package com.sogou.contest.tongle.db.entity;

import android.content.Context;
import android.os.SystemClock;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rxread on 5/31/15.
 */
public class DbMock {
    private static String []POSITION_TAGS="五道口#天通苑#回龙观#西单#鸟巢#北京西站#国贸#苹果园#五棵松#宛城#大望路#圆明园西#香山#周口店#慕田峪#白河峡谷#天安门".split("#");
    private static String []INTEREST_TAGS="游泳#读书#乒乓球#滑冰#画画#下棋#搞毛线".split("#");

    public static void mockDbData(Context context) {
        DbUtils dbUtils = DbUtils.create(context);
        dbUtils.configAllowTransaction(true);
        Random random = new Random(SystemClock.elapsedRealtime());
        try {
            for (int i = 0; i < 1000; i++) {

                dbUtils.save(getRandomFriend(random));
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

//    public int

    public static FrientEntity getRandomFriend(Random random) {
        FrientEntity friendEntity = new FrientEntity();
        friendEntity.setSex(random.nextInt(100) % 2 == 0 ? 1 : 0);
        friendEntity.setDistance(random.nextInt(2999 * 1000));
        friendEntity.setIsFollowed(random.nextInt(200) % 2 == 0 ? true : false);
        friendEntity.setInterestTag(getRandomInterestTag(random));
        friendEntity.setPositionTag(getRandomPositionsTag(random));
        friendEntity.setAvatar("");
        friendEntity.setIsPopular(random.nextInt(300) % 2 == 0 ? true : false);
        friendEntity.setGrade(random.nextInt(7)+3);//3-9[3,10)
        friendEntity.setTangmaoAccount(getRandomTangMaoAccount(random));
        friendEntity.setParentName(getRandomParentName(random));
        return friendEntity;
    }

    public static String getRandomInterestTag(Random random){
        int count=random.nextInt(6);
        StringBuilder stringBuilder=new StringBuilder();
        ArrayList<String> list=new ArrayList<>(5);
        String item="";
        for (int i=0;i<count;i++){
            while (list.contains(item=INTEREST_TAGS[random.nextInt(INTEREST_TAGS.length)])){
                //loop
            }
            list.add(item);
            stringBuilder.append(item);
            if(i!=count-1){
                stringBuilder.append("#");
            }
        }
        return stringBuilder.toString();
    }

    public static String getRandomPositionsTag(Random random){
        int count=random.nextInt(6);
        StringBuilder stringBuilder=new StringBuilder();
        ArrayList<String> list=new ArrayList<>(5);
        String item="";
        for (int i=0;i<count;i++){
            while (list.contains(item=POSITION_TAGS[random.nextInt(POSITION_TAGS.length)])){
                //loop
            }
            list.add(item);
            stringBuilder.append(item);
            if(i!=count-1){
                stringBuilder.append("#");
            }
        }
        return stringBuilder.toString();
    }

    public static String getRandomTangMaoAccount(Random random){
        if(random.nextInt(5)==1){
            return "tm15"+System.currentTimeMillis()+random.nextInt(10000);
        }else{
            return "";
        }
    }

    public static String getRandomParentName(Random random){
        if(random.nextInt(4)==1){
            return RandomValue.getChineseName();
        }else{
            return "";
        }
    }



}
