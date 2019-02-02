/**
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
public abstract class AbstractBlogPost {
    
    private final boolean featured;
    private final List<String> tags;
    @Json(name = "_id")
    private final String id;
    private final String author;
    private final String title;
    private final Date publishedAt;
    private final CoverImage coverImage;
    private final Date createdAt;
    private final String slug;
    
}
