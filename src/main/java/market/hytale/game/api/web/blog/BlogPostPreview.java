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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BlogPostPreview extends AbstractBlogPost {
    
    private final String bodyExcerpt;
    
    public BlogPostPreview(boolean featured, List<String> tags, String id,
                           String author,
                           String title,
                           Date publishedAt,
                           CoverImage coverImage,
                           Date createdAt,
                           String slug,
                           String bodyExcerpt) {
        super(featured, tags, id, author, title, publishedAt, coverImage, createdAt, slug);
        
        this.bodyExcerpt = bodyExcerpt;
    }
    
}
