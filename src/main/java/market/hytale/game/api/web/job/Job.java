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
package market.hytale.game.api.web.job;

import java.util.Date;

import com.squareup.moshi.Json;

import lombok.Data;

@Data
public class Job {
    
    @Json(name = "@context")
    private final String context;
    @Json(name = "@type")
    private final String type;
    private final Date datePosted;
    private final String description;
    private final HiringOrganization hiringOrganization;
    private final Identifier identifier;
    private final String title;
    private final String url;
    private final String employmentType;
    
    @Data
    public static class Identifier {
        
        @Json(name = "@type")
        private final String type;
        private final String name;
        private final String value;
        
    }
    
}
