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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import market.hytale.game.api.web.HytaleWebAPIManager;
import market.hytale.game.api.web.HytaleWebAPIService;
import market.hytale.game.api.web.blog.AbstractBlogPost;
import market.hytale.game.api.web.blog.BlogPost;
import market.hytale.game.api.web.blog.BlogPostDetailedNavigable;
import market.hytale.game.api.web.blog.BlogPostPreview;
import retrofit2.Response;

@TestInstance(Lifecycle.PER_CLASS)
public class BlogTest {
    
    private HytaleWebAPIService apiService;
    
    @BeforeAll
    public void initializeTest() {
        this.apiService = HytaleWebAPIManager.createAPIProvider();
    }
    
    @Test
    public void testGetPublishedBlogPosts() throws IOException {
        final Response<List<BlogPostPreview>> response = this.apiService.getPublishedBlogPosts().execute();
        
        TestUtils.testResponse(response);
        
        final List<BlogPostPreview> publishedBlogPosts = response.body();
        
        TestUtils.testListNotEmpty(publishedBlogPosts);
        
        for (BlogPostPreview blogPostPreview : publishedBlogPosts) {
            this.testBlogPost(blogPostPreview);
        }
    }
    
    @Test
    public void testGetPublishedFeaturedBlogPosts() throws IOException {
        final Response<List<BlogPost>> response = this.apiService.getPublishedFeaturedBlogPosts().execute();
        
        TestUtils.testResponse(response);
        
        final List<BlogPost> publishedFeaturedBlogPosts = response.body();
        
        TestUtils.testListNotEmpty(publishedFeaturedBlogPosts);
        
        for (BlogPost blogPost : publishedFeaturedBlogPosts) {
            this.testBlogPost(blogPost);
        }
    }
    
    @Test
    public void testGetBlogPostArchive() throws IOException {
        final Response<List<BlogPostPreview>> response = this.apiService.getArchivedBlogPosts(2018, 12).execute();
        
        TestUtils.testResponse(response);
        
        final List<BlogPostPreview> archivedBlogPosts = response.body();
        
        TestUtils.testListNotEmpty(archivedBlogPosts);
        
        for (BlogPostPreview blogPostPreview : archivedBlogPosts) {
            this.testBlogPost(blogPostPreview);
        }
    }
    
    @Test
    public void testGetBlogPost() throws IOException {
        final Response<BlogPostDetailedNavigable> response = this.apiService.getBlogPost("hytale-faq").execute();
        
        TestUtils.testResponse(response);
        
        final BlogPostDetailedNavigable blogPostDetailedNavigable = response.body();
        
        this.testBlogPost(blogPostDetailedNavigable);
        
        if (blogPostDetailedNavigable.getNext() != null) {
            this.testBlogPost(blogPostDetailedNavigable.getNext());
        }
        
        if (blogPostDetailedNavigable.getPrevious() != null) {
            this.testBlogPost(blogPostDetailedNavigable);
        }
    }
    
    private void testBlogPost(AbstractBlogPost blogPost) {
        assertNotNull(blogPost.getId(), "Blog post id is null");
        assertNotNull(blogPost.getTitle(), "Blog post title is null for " + blogPost.getId());
        assertNotNull(blogPost.getSlug(), "Blog post slug is null for " + blogPost.getId());
        
        System.out.println(blogPost.toString());
    }
    
}
