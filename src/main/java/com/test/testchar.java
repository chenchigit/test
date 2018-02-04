package com.test;

/**
 * Created by wb-chenchi on 2018/1/15.
 */
public class testchar {

    public static void main(String[] args){
        char char1 ='a';
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb.toString().endsWith("c"));

        String str="{\"code\":{\"smid\":0,\"level\":0,\"success\":true,\"pattern\":\"\",\"mid\":0,\"message\":\"成功\",\"seq\":0},\"data\":{\"amountLimit\":1000,\"code\":\"A\",\"isServicePurchase\":null,\"publishInternalAt\":null,\"purchaseTypes\":\"6|0\",\"parentNodeId\":null,\"remark\":\"\",\"releaseAt\":null,\"orgId\":null,\"functionService\":null,\"vehicleCategory\":null,\"bottomNodeFlag\":false,\"isDisable\":false,\"relaNodeId\":null,\"createdAt\":\"2017-09-21 19:15:04\",\"id\":394407062882484224,\"updatedAt\":\"2017-09-21 19:15:04\",\"isQuantityLimit\":null,\"publicService\":null,\"isDeprecated\":false,\"orgName\":null,\"level\":\"1\",\"publishAt\":null,\"version\":null,\"isHide\":true,\"labelList\":null,\"unit\":null,\"governOperation\":null,\"gpCatalogId\":1000000000000012180,\"isVehicle\":null,\"deprecatedAt\":null,\"quantityLimit\":0,\"isBCPurchase\":null,\"name\":\"货物类xxxaxxx\",\"isImportantCategory\":null,\"isCarOnly\":null,\"isComputeOnly\":null,\"deprecatedInternalAt\":null,\"nodeId\":388487319392616448},\"success\":true}";
        if(str.indexOf("amountLimit\":1000,\"code\":\"A\",\"isServicePurchase\":null,\"publishInternalAt")!=-1){
            System.out.println("包含");
        }else{
            System.out.println("不包含");
        }
        //{"code":{"smid":0,"level":0,"success":true,"pattern":"","mid":0,"message":"成功","seq":0},"data":{"amountLimit":1000,"code":"A","isServicePurchase":null,"publishInternalAt":null,"purchaseTypes":"6|0","parentNodeId":null,"remark":"","releaseAt":null,"orgId":null,"
        // functionService":null,"vehicleCategory":null,"bottomNodeFlag":false,"isDisable":false,"relaNodeId":null,"createdAt":"2017-09-21 19:15:04","id":394407062882484224,"updatedAt":"2017-09-21 19:15:04","isQuantityLimit":null,"publicService":null,"isDeprecated":false,"orgName":null,"level":"1","publishAt":null,"version":null,"isHide":true,"labelList":null,"unit":null,"governOperation":null,"gpCatalogId":1000000000000012180,"isVehicle":null,"deprecatedAt":null,"quantityLimit":0,"isBCPurchase":null,"name":"货物类xxxaxxx","isImportantCategory":null,"isCarOnly":null,"isComputeOnly":null,"deprecatedInternalAt":null,"nodeId":388487319392616448},"success":true}
    }
}
