package com.sugar.manage.vo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FieldNameMaps {

    /*商机推进阶段字段*/
    public static Map<String,String> businessPhaseFieldsMap = new HashMap<>();

    /*采购阶段字段*/
    public static Map<String,String> purchasePhaseFieldsMap = new HashMap<>();

    /*产品阶段字段*/
    public static Map<String,String> productPhaseFieldsMap = new HashMap<>();

    /*研发阶段*/
    public static Map<String,String> developmentPhaseFieldsMap = new HashMap<>();

    static {

        Field[] businessAdvancePhaseFields = new BusinessAdvancePhaseVO().getClass().getDeclaredFields();

        Field[] purchasePhaseFields = new PurchasePhaseVO().getClass().getDeclaredFields();

        Field[] productPhaseFields = new ProductPhaseVO().getClass().getDeclaredFields();

        Field[] developmentPhaseFields = new DevelopmentPhaseVO().getClass().getDeclaredFields();

        for(Field field : businessAdvancePhaseFields){
            businessPhaseFieldsMap.put(field.getName(),null);
        }

        for(Field field : purchasePhaseFields){
            purchasePhaseFieldsMap.put(field.getName(),null);
        }

        for(Field field : productPhaseFields){
            productPhaseFieldsMap.put(field.getName(),null);
        }

        for(Field field : developmentPhaseFields){
            developmentPhaseFieldsMap.put(field.getName(),null);
        }

    }

}
