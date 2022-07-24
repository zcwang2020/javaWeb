/**
 * @(#)StringTest.java, 2021/12/22.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author Tmind
 * @Date 2021/12/22
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "[\n" +
                "    {\n" +
                "      \"id\": 2032,\n" +
                "      \"pageId\": 44,\n" +
                "      \"name\": \"签到页首焦\",\n" +
                "      \"componentType\": 59,\n" +
                "      \"slots\": [\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"slotNum\": 1,\n" +
                "          \"tasks\": [\n" +
                "            {\n" +
                "              \"id\": 13891190,\n" +
                "              \"type\": 1,\n" +
                "              \"resourcesId\": 1,\n" +
                "              \"priority\": 0,\n" +
                "              \"operator\": \"yubo1@corp.netease.com\",\n" +
                "              \"crmUserGroupId\": \"0\",\n" +
                "              \"crmUserGroupName\": \"无分组\",\n" +
                "              \"materials\": [\n" +
                "                {\n" +
                "                  \"id\": 13892006,\n" +
                "                  \"name\": \"签到页首焦素材1\",\n" +
                "                  \"type\": \"通用素材模板\",\n" +
                "                  \"typeNumber\": 40,\n" +
                "                  \"status\": -1,\n" +
                "                  \"belong\": -1,\n" +
                "                  \"beginTime\": 0,\n" +
                "                  \"endTime\": 0,\n" +
                "                  \"traffic\": 0,\n" +
                "                  \"process\": -1,\n" +
                "                  \"remark\": \"\",\n" +
                "                  \"deliveryType\": 1,\n" +
                "                  \"crmUserGroupId\": \"0\",\n" +
                "                  \"crmUserGroupName\": \"\",\n" +
                "                  \"weight\": 100,\n" +
                "                  \"advertisementBannerVO\": null,\n" +
                "                  \"itemId\": null,\n" +
                "                  \"newItemDesc\": null,\n" +
                "                  \"mediaVO\": null,\n" +
                "                  \"mailAdVO\": null,\n" +
                "                  \"personalCenterAdVO\": null,\n" +
                "                  \"materialDetail\": {\n" +
                "                    \"list\": [\n" +
                "                      {\n" +
                "                        \"platform\": 0,\n" +
                "                        \"materialConfig\": {\n" +
                "                          \"type\": 0,\n" +
                "                          \"picUrl\": \"https://yanxuan.nosdn.127.net/4f136906d2e642dcf8c6ee665b726679.png\",\n" +
                "                          \"videoUrl\": \"\",\n" +
                "                          \"title\": \"\",\n" +
                "                          \"subTitle\": \"\",\n" +
                "                          \"targetUrl\": \"https://act.you.163.com/act/pub/ssr/CcvALwzIW91G.html?appConfig=1_1_1\",\n" +
                "                          \"smartPicText\": null,\n" +
                "                          \"smartColor\": null,\n" +
                "                          \"extText1\": null,\n" +
                "                          \"extText2\": null,\n" +
                "                          \"textColor\": \"\",\n" +
                "                          \"logoUrl\": null,\n" +
                "                          \"marketingTitle\": 0,\n" +
                "                          \"marketingScene\": 0,\n" +
                "                          \"itemList\": null\n" +
                "                        }\n" +
                "                      }\n" +
                "                    ],\n" +
                "                    \"includeOn\": false,\n" +
                "                    \"includeConfig\": {\n" +
                "                      \"type\": 0,\n" +
                "                      \"dataList\": null,\n" +
                "                      \"itemIdList\": null,\n" +
                "                      \"itemList\": null\n" +
                "                    },\n" +
                "                    \"excludeOn\": false,\n" +
                "                    \"excludeConfig\": {\n" +
                "                      \"type\": 0,\n" +
                "                      \"dataList\": null,\n" +
                "                      \"itemIdList\": null,\n" +
                "                      \"itemList\": null\n" +
                "                    },\n" +
                "                    \"sortType\": 0,\n" +
                "                    \"componentId\": 2032\n" +
                "                  },\n" +
                "                  \"materialStr\": \"{\\\"includeOn\\\":false,\\\"componentId\\\":2032,\\\"sortType\\\":0,\\\"excludeConfig\\\":{\\\"type\\\":0},\\\"excludeOn\\\":false,\\\"list\\\":[{\\\"materialConfig\\\":{\\\"marketingScene\\\":0,\\\"title\\\":\\\"\\\",\\\"type\\\":0,\\\"marketingTitle\\\":0,\\\"textColor\\\":\\\"\\\",\\\"picUrl\\\":\\\"https://yanxuan.nosdn.127.net/4f136906d2e642dcf8c6ee665b726679.png\\\",\\\"subTitle\\\":\\\"\\\",\\\"videoUrl\\\":\\\"\\\",\\\"targetUrl\\\":\\\"https://act.you.163.com/act/pub/ssr/CcvALwzIW91G.html?appConfig=1_1_1\\\"},\\\"platform\\\":0}],\\\"includeConfig\\\":{\\\"type\\\":0}}\",\n" +
                "                  \"operator\": \"余波\",\n" +
                "                  \"canDelete\": false,\n" +
                "                  \"updateTime\": 1640316316609,\n" +
                "                  \"defaultMaterial\": 0,\n" +
                "                  \"abtPlanId\": 0,\n" +
                "                  \"choseStartegy\": null\n" +
                "                }\n" +
                "              ],\n" +
                "              \"taskStrategy\": {\n" +
                "                \"hasIcon\": 0,\n" +
                "                \"appointRule\": null,\n" +
                "                \"filterRule\": null,\n" +
                "                \"hidden\": 0,\n" +
                "                \"relatedPageIds\": null,\n" +
                "                \"algSort\": 0,\n" +
                "                \"type\": 0,\n" +
                "                \"subType\": 0,\n" +
                "                \"crcTaskWeightVOs\": [\n" +
                "                  {\n" +
                "                    \"materialId\": 13892006,\n" +
                "                    \"materialType\": 0,\n" +
                "                    \"weight\": 100,\n" +
                "                    \"defaultMaterial\": 0,\n" +
                "                    \"materialName\": null,\n" +
                "                    \"newItemDesc\": null,\n" +
                "                    \"materialInfo\": null\n" +
                "                  }\n" +
                "                ],\n" +
                "                \"materials\": null,\n" +
                "                \"refactor\": null,\n" +
                "                \"resortType\": 0,\n" +
                "                \"manualDesign\": 0,\n" +
                "                \"topItemIds\": null,\n" +
                "                \"resourceIds\": [\n" +
                "                  1\n" +
                "                ],\n" +
                "                \"type2\": 1,\n" +
                "                \"extConfig\": null\n" +
                "              },\n" +
                "              \"resourcesIds\": [\n" +
                "                1\n" +
                "              ],\n" +
                "              \"createTime\": 1640316546835,\n" +
                "              \"beginTime\": 1640316600000,\n" +
                "              \"endTime\": 1640921311000\n" +
                "            }\n" +
                "          ],\n" +
                "          \"alg_personalized\": null\n" +
                "        }\n" +
                "      ],\n" +
                "      \"frequencyConfig\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2031,\n" +
                "      \"pageId\": 44,\n" +
                "      \"name\": \"互动位\",\n" +
                "      \"componentType\": 59,\n" +
                "      \"slots\": [\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"slotNum\": 1,\n" +
                "          \"tasks\": [\n" +
                "            {\n" +
                "              \"id\": 13891189,\n" +
                "              \"type\": 1,\n" +
                "              \"resourcesId\": 1,\n" +
                "              \"priority\": 0,\n" +
                "              \"operator\": \"yubo1@corp.netease.com\",\n" +
                "              \"crmUserGroupId\": \"0\",\n" +
                "              \"crmUserGroupName\": \"无分组\",\n" +
                "              \"materials\": [\n" +
                "                {\n" +
                "                  \"id\": 13892007,\n" +
                "                  \"name\": \"签到页互动位素材1\",\n" +
                "                  \"type\": \"通用素材模板\",\n" +
                "                  \"typeNumber\": 40,\n" +
                "                  \"status\": -1,\n" +
                "                  \"belong\": -1,\n" +
                "                  \"beginTime\": 0,\n" +
                "                  \"endTime\": 0,\n" +
                "                  \"traffic\": 0,\n" +
                "                  \"process\": -1,\n" +
                "                  \"remark\": \"\",\n" +
                "                  \"deliveryType\": 1,\n" +
                "                  \"crmUserGroupId\": \"0\",\n" +
                "                  \"crmUserGroupName\": \"\",\n" +
                "                  \"weight\": 100,\n" +
                "                  \"advertisementBannerVO\": null,\n" +
                "                  \"itemId\": null,\n" +
                "                  \"newItemDesc\": null,\n" +
                "                  \"mediaVO\": null,\n" +
                "                  \"mailAdVO\": null,\n" +
                "                  \"personalCenterAdVO\": null,\n" +
                "                  \"materialDetail\": {\n" +
                "                    \"list\": [\n" +
                "                      {\n" +
                "                        \"platform\": 0,\n" +
                "                        \"materialConfig\": {\n" +
                "                          \"type\": 0,\n" +
                "                          \"picUrl\": \"https://yanxuan.nosdn.127.net/b844e5f22638d6937a00338548546491.png\",\n" +
                "                          \"videoUrl\": \"\",\n" +
                "                          \"title\": \"必买榜单\",\n" +
                "                          \"subTitle\": \"\",\n" +
                "                          \"targetUrl\": \"https://act.you.163.com/act/pub/ssr/ydchBwf6Itup.html\",\n" +
                "                          \"smartPicText\": null,\n" +
                "                          \"smartColor\": null,\n" +
                "                          \"extText1\": null,\n" +
                "                          \"extText2\": null,\n" +
                "                          \"textColor\": \"\",\n" +
                "                          \"logoUrl\": null,\n" +
                "                          \"marketingTitle\": 0,\n" +
                "                          \"marketingScene\": 0,\n" +
                "                          \"itemList\": null\n" +
                "                        }\n" +
                "                      }\n" +
                "                    ],\n" +
                "                    \"includeOn\": false,\n" +
                "                    \"includeConfig\": {\n" +
                "                      \"type\": 0,\n" +
                "                      \"dataList\": null,\n" +
                "                      \"itemIdList\": null,\n" +
                "                      \"itemList\": null\n" +
                "                    },\n" +
                "                    \"excludeOn\": false,\n" +
                "                    \"excludeConfig\": {\n" +
                "                      \"type\": 0,\n" +
                "                      \"dataList\": null,\n" +
                "                      \"itemIdList\": null,\n" +
                "                      \"itemList\": null\n" +
                "                    },\n" +
                "                    \"sortType\": 0,\n" +
                "                    \"componentId\": 2031\n" +
                "                  },\n" +
                "                  \"materialStr\": \"{\\\"includeOn\\\":false,\\\"componentId\\\":2031,\\\"sortType\\\":0,\\\"excludeConfig\\\":{\\\"type\\\":0},\\\"excludeOn\\\":false,\\\"list\\\":[{\\\"materialConfig\\\":{\\\"marketingScene\\\":0,\\\"title\\\":\\\"必买榜单\\\",\\\"type\\\":0,\\\"marketingTitle\\\":0,\\\"textColor\\\":\\\"\\\",\\\"picUrl\\\":\\\"https://yanxuan.nosdn.127.net/b844e5f22638d6937a00338548546491.png\\\",\\\"subTitle\\\":\\\"\\\",\\\"videoUrl\\\":\\\"\\\",\\\"targetUrl\\\":\\\"https://act.you.163.com/act/pub/ssr/ydchBwf6Itup.html\\\"},\\\"platform\\\":0}],\\\"includeConfig\\\":{\\\"type\\\":0}}\",\n" +
                "                  \"operator\": \"余波\",\n" +
                "                  \"canDelete\": false,\n" +
                "                  \"updateTime\": 1640316443069,\n" +
                "                  \"defaultMaterial\": 0,\n" +
                "                  \"abtPlanId\": 0,\n" +
                "                  \"choseStartegy\": null\n" +
                "                }\n" +
                "              ],\n" +
                "              \"taskStrategy\": {\n" +
                "                \"hasIcon\": 0,\n" +
                "                \"appointRule\": null,\n" +
                "                \"filterRule\": null,\n" +
                "                \"hidden\": 0,\n" +
                "                \"relatedPageIds\": null,\n" +
                "                \"algSort\": 0,\n" +
                "                \"type\": 0,\n" +
                "                \"subType\": 0,\n" +
                "                \"crcTaskWeightVOs\": [\n" +
                "                  {\n" +
                "                    \"materialId\": 13892007,\n" +
                "                    \"materialType\": 0,\n" +
                "                    \"weight\": 100,\n" +
                "                    \"defaultMaterial\": 0,\n" +
                "                    \"materialName\": null,\n" +
                "                    \"newItemDesc\": null,\n" +
                "                    \"materialInfo\": null\n" +
                "                  }\n" +
                "                ],\n" +
                "                \"materials\": null,\n" +
                "                \"refactor\": null,\n" +
                "                \"resortType\": 0,\n" +
                "                \"manualDesign\": 0,\n" +
                "                \"topItemIds\": null,\n" +
                "                \"resourceIds\": [\n" +
                "                  1\n" +
                "                ],\n" +
                "                \"type2\": 1,\n" +
                "                \"extConfig\": null\n" +
                "              },\n" +
                "              \"resourcesIds\": [\n" +
                "                1\n" +
                "              ],\n" +
                "              \"createTime\": 1640316508735,\n" +
                "              \"beginTime\": 1640316600000,\n" +
                "              \"endTime\": 1640921257000\n" +
                "            }\n" +
                "          ],\n" +
                "          \"alg_personalized\": null\n" +
                "        }\n" +
                "      ],\n" +
                "      \"frequencyConfig\": null\n" +
                "    }\n" +
                "  ]";
        JSONObject rpcResult = JSON.parseObject(a);
        int code = rpcResult.getIntValue("code");
        if (code == 200) {
            System.out.println(rpcResult.getString("data"));
        }
    }
}