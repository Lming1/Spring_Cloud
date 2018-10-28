package com.example.user.demo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest // JSON 직렬화/역직렬화 테스트 활성화
public class UserTests {
    private User user;

    @Autowired
    private JacksonTester<User> json;


    @Before
    public void setup() throws Exception {
        User user = new User("user", "ming", "Lee", "tester@test.com");
        user.setId(1L);
        user.setCreatedAt(12345L);
        user.setLastModified(12346L);
        this.user = user;
    }

    @Test
    public void deserializeJson() throws Exception {
        String content = "{\"username\": \"user\", \"firstName\": \"ming\", " + "\"lastName\": \"Lee\", \"email\": \"tester@test.com\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new User("user", "ming", "Lee", "tester@test.com"));
        assertThat(this.json.parseObject(content).getUsername())
                .isEqualTo("user");
    }

    @Test
    public void serializeJson() throws Exception {
        assertThat(this.json.write(user)).isEqualTo("/com/example/user/demo/user.json");
        assertThat(this.json.write(user)).isEqualToJson("/com/example/user/demo/user.json");
        assertThat(this.json.write(user)).hasJsonPathStringValue("@.username");
        assertJsonPropertyEquals("@.username", "user");
        assertJsonPropertyEquals("@.firstName", "ming");
        assertJsonPropertyEquals("@.lastName", "Lee");
        assertJsonPropertyEquals("@.email", "tester@test.com");
    }

    private void assertJsonPropertyEquals(String key, String value) throws IOException {
        assertThat(this.json.write(user)).extractingJsonPathStringValue(key)
                .isEqualTo(value);
    }
}
