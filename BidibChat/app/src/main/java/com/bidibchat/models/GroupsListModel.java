package com.bidibchat.models;

/**
 * Created by Inderdeep on 17-09-2015.
 */
public class GroupsListModel {

    private String groupName;
    private String numberOfGroupMembers;
    private String groupImageName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String _groupName) {
        this.groupName = _groupName;
    }

    public String geNumberOfGroupMembers() {
        return numberOfGroupMembers;
    }

    public void setNumberOfGroupMembers(String _numberOfGroupMembers) {
        this.numberOfGroupMembers = _numberOfGroupMembers;
    }

    public String getGroupImageName() {
        return groupImageName;
    }

    public void setGroupImageName(String _groupImageName) {
        this.groupImageName = _groupImageName;
    }

}
