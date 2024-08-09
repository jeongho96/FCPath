package org.delivery.db.user.enums;



public enum UserStatus {

    REGISTERED("등록"),
    UNREGISTERED("해지"),
    ;

    private final String description;

    // 생성자
    UserStatus(String description) {
        this.description = description;
    }
}
