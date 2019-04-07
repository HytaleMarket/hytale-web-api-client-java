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

package market.hytale.game.api.web.job;

import com.squareup.moshi.Json;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Represents a job location.
 * @since 1.0.0
 * @version 2019.04.01-RELEASE
 */
@SuperBuilder
@Getter
@ToString
@EqualsAndHashCode
public class JobLocation {

    @Json(name = "@type")
    private String type;

    /**
     * Represents an address for a {@link JobLocation}.
     * @since 1.0.0
     * @version 2019.04.01-RELEASE
     */
    @SuperBuilder
    @Getter
    @ToString
    @EqualsAndHashCode
    public static class Address {

        @Json(name = "@type")
        private String type;
        private String addressCountry;

    }

}
