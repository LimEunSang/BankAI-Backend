package com.hana.bankai.global.common.enumtype;

import lombok.Getter;

@Getter
public enum BankCode {
    C88("신한"),
    C20("우리"),
    C92("토스"),
    C81("하나"),
    C90("카카오"),
    C06("국민"),
    C11("농협"),
    C04("뱅크시");

    private final String desc;

    BankCode(String desc) {
        this.desc = desc;
    }
}
