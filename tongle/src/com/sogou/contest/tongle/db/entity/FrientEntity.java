package com.sogou.contest.tongle.db.entity;

/**
 * Created by rxread on 5/31/15.
 */
public class FrientEntity extends BaseEntity{
    private String name;
    private int sex;
    private int distance;
    private boolean isFollowed;
    private String positionTag;
    private String interestTag;
    private String avatar;
    private boolean isPopular;
    private int grade;
    private String tangmaoAccount;
    private String parentName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(boolean isFollowed) {
        this.isFollowed = isFollowed;
    }

    public String getPositionTag() {
        return positionTag;
    }

    public void setPositionTag(String positionTag) {
        this.positionTag = positionTag;
    }

    public String getInterestTag() {
        return interestTag;
    }

    public void setInterestTag(String interestTag) {
        this.interestTag = interestTag;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isPopular() {
        return isPopular;
    }

    public void setIsPopular(boolean isPopular) {
        this.isPopular = isPopular;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getTangmaoAccount() {
        return tangmaoAccount;
    }

    public void setTangmaoAccount(String tangmaoAccount) {
        this.tangmaoAccount = tangmaoAccount;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
