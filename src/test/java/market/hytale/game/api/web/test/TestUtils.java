/*
 * Copyright 2019 Hytale Market
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package market.hytale.game.api.web.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

import retrofit2.Response;

public class TestUtils {
    
    public static void testResponse(Response<?> response) {
        assertEquals(response.isSuccessful(), true, "Request failed: " + response.message());
    }
    
    public static void testListNotEmpty(List<?> list) {
        assertNotEquals(list.size(), 0, "List is empty");
    }
    
    public static void testAllFieldsNotNull(Field[] fields, Object instance) {
        Stream.of(fields).forEach(field -> {
            field.setAccessible(true);
            
            try {
                assertNotNull(field.get(instance));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                fail(e);
            }
        });
    }
    
}
