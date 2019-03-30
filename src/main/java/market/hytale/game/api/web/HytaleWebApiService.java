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

package market.hytale.game.api.web;

import market.hytale.game.api.web.blog.BlogPost;
import market.hytale.game.api.web.blog.BlogPostDetailedNavigable;
import market.hytale.game.api.web.blog.BlogPostPreview;
import market.hytale.game.api.web.job.Job;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface HytaleWebApiService {

  @GET("job/listing")
  Call<List<Job>> getJobListing();

  @GET("blog/post/published")
  Call<List<BlogPostPreview>> getPublishedBlogPosts();

  @GET("blog/post/published?featuredOnly=1")
  Call<List<BlogPost>> getPublishedFeaturedBlogPosts();

  @GET("blog/post/archive/{year}/{month}")
  Call<List<BlogPostPreview>> getArchivedBlogPosts(@Path("year") int year,
      @Path("month") int month);

  @GET("blog/post/slug/{slug}")
  Call<BlogPostDetailedNavigable> getBlogPost(@Path("slug") String slug);

}
