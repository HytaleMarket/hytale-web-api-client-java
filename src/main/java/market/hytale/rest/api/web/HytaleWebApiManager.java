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

package market.hytale.rest.api.web;

import java.util.Date;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Main class used for creating an api provider instance of {@link HytaleWebApiService}.
 * @since 1.0.0
 * @version 2019.04.01-RELEASE
 */
public final class HytaleWebApiManager {

    private HytaleWebApiManager() { }

    public static final String API_BASE_URL = "https://hytale.com/api/";

    /**
     * Creates an instance of {@link HytaleWebApiService}.
     * @return The created instance of {@link HytaleWebApiService}
     */
    public static HytaleWebApiService createApiProvider() {
        OkHttpClient httpClient = new OkHttpClient.Builder().build();

        return HytaleWebApiManager.createApiProvider(httpClient);
    }

    /**
     * Creates an instance of {@link HytaleWebApiService} with a custom {@link OkHttpClient}.
     * @param  httpClient An instance of {@link OkHttpClient}
     * @return The created instance of {@link HytaleWebApiService}
     */
    public static HytaleWebApiService createApiProvider(final OkHttpClient httpClient) {
        Moshi moshi =
                new Moshi.Builder().add(Date.class, new Rfc3339DateJsonAdapter().nullSafe()).build();

        MoshiConverterFactory moshiConverterFactory = MoshiConverterFactory.create(moshi);

        Retrofit retrofit = new Retrofit.Builder().client(httpClient).baseUrl(API_BASE_URL)
               .addConverterFactory(moshiConverterFactory).build();

        return retrofit.create(HytaleWebApiService.class);
    }

}
