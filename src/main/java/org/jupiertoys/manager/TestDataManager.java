package org.jupiertoys.manager;

import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestDataManager {

    private final Logger logger = LoggerFactory.getLogger(TestDataManager.class);
    private final String filePath = System.getProperty("user.dir") + "/src/test/resources/Data/";

    private JSONObject jsonObject;

    private JSONObject getJsonData(String fileName) {

        try {
            final String fileInput = new String(Files.readAllBytes(Paths.get(filePath + fileName)));
            jsonObject = new JSONObject(fileInput);
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }
        return jsonObject;
    }

    private <T> T getJsonValue(String fileName, String key, Class<T> clazz) {

        final String jsonData = getJsonData(fileName).toString();
        return JsonPath.from(jsonData).getObject(key, clazz);
    }

    public <T> T getTestInputCommonData(String key, Class<T> clazz) {

        return getJsonValue("TestInputs/commonData", key, clazz);
    }

    public String getTestInputData(String key) {

        return getTestInputCommonData(key, String.class);
    }

    public String getAssertionData(String key) {

        return getData(key,String.class);
    }

    public <T> T getData(String key, Class<T> clazz) {

        return getJsonValue("AssertData/assertionInfo" , key, clazz);
    }

}
