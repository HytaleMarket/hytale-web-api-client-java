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
package market.hytale.game.api.web.blog;

import java.util.Date;
import java.util.List;

import com.squareup.moshi.Json;

import lombok.Data;

@Data
public class CoverImage {
    
    private final List<String> variants;
    @Json(name = "_id")
    private final String id;
    private final String s3Key;
    private final String mimeType;
    private final boolean attached;
    private final String contentType;
    private final String contentId;
    private final Date createdAt;
    @Json(name = "__v")
    private final int version;
    
}
