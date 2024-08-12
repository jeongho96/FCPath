package org.delivery.db.user.enums;



public enum UserStatus {

    REGISTERED("등록"),
    UNREGISTERED("해지")
    ;

    private String description;

    private UserStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}