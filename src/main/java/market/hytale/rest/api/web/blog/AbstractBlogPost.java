/*
 * Copyright 2019 Hytale Market
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package market.hytale.rest.api.web.blog;

import java.util.Date;
import java.util.List;

import com.squareup.moshi.Json;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Represents the base model of every blog post.
 * @since 1.0.0
 * @version 2019.04.01-RELEASE
 */
@SuperBuilder
@Getter
@ToString
@EqualsAndHashCode
public abstract class AbstractBlogPost {

    private boolean featured;
    private List<String> tags;
    @Json(name = "_id")
    private String id;
    private String author;
    private String title;
    private Date publishedAt;
    private CoverImage coverImage;
    private Date createdAt;
    private String slug;

}
