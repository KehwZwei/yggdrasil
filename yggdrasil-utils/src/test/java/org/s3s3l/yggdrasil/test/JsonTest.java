package org.s3s3l.yggdrasil.test;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.s3s3l.yggdrasil.bean.time.JsonTimestampDateDeserializer;
import org.s3s3l.yggdrasil.bean.time.JsonTimestampDateSerializer;
import org.s3s3l.yggdrasil.bean.time.JsonTimestampDateTimeDeserializer;
import org.s3s3l.yggdrasil.bean.time.JsonTimestampDateTimeSerializer;
import org.s3s3l.yggdrasil.bean.time.JsonTimestampTimeDeserializer;
import org.s3s3l.yggdrasil.bean.time.JsonTimestampTimeSerializer;
import org.s3s3l.yggdrasil.utils.json.IJacksonHelper;
import org.s3s3l.yggdrasil.utils.json.JacksonUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * <p>
 * </p>
 * ClassName:JsonTest <br>
 * Date: Jan 22, 2017 2:53:45 PM <br>
 * 
 * @author kehw_zwei
 * @version 1.0.0
 * @since JDK 1.8
 */
public class JsonTest {

    @Data
    private static class TestObject {
        @JsonDeserialize(using = JsonTimestampTimeDeserializer.class)
        @JsonSerialize(using = JsonTimestampTimeSerializer.class)
        private Timestamp time = new Timestamp(System.currentTimeMillis());
        @JsonDeserialize(using = JsonTimestampDateDeserializer.class)
        @JsonSerialize(using = JsonTimestampDateSerializer.class)
        private Timestamp date = new Timestamp(System.currentTimeMillis());
        @JsonDeserialize(using = JsonTimestampDateTimeDeserializer.class)
        @JsonSerialize(using = JsonTimestampDateTimeSerializer.class)
        private Timestamp dateTime = new Timestamp(System.currentTimeMillis());
        private Duration duration;
    }

    @Test
    public void jsonTimestampTest() throws JsonParseException, JsonMappingException, IOException {
        IJacksonHelper json = JacksonUtils.create();
        TestObject obj = new TestObject();
        String objJson = json.toJsonString(obj);
        TestObject test = json.toObject(objJson, TestObject.class);
        String testJson = json.toJsonString(test);
        Assert.assertEquals("时间序列化错误", objJson, testJson);
    }
}
