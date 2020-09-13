package com.erik.winestock.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WineType {

    RED("Red"),
    WHITE("White"),
    ROSE("Rose");

    private final String  description;
}
