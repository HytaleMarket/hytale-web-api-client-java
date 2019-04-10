/*
 * Copyright 2019 Hytale Market
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package market.hytale.rest.api.web.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import market.hytale.rest.api.web.HytaleWebApiManager;
import market.hytale.rest.api.web.HytaleWebApiService;
import market.hytale.rest.api.web.job.Job;
import retrofit2.Response;

@TestInstance(Lifecycle.PER_CLASS)
public class JobTest {

    private HytaleWebApiService apiService;

    @BeforeAll
    public void initializeTest() {
        this.apiService = HytaleWebApiManager.createApiProvider();
    }

    @Test
    public void testGetJobListing() throws IOException {
        final Response<List<Job>> response = this.apiService.getJobListing().execute();

        TestUtils.testResponse(response);

        final List<Job> jobs = response.body();

        TestUtils.testListNotEmpty(jobs);

        for (Job job : jobs) {
            this.testJob(job);
        }
    }

    private void testJob(Job job) {
        assertNotNull(job.getIdentifier().getValue(), "Job identifier is null");
        assertNotNull(job.getTitle(), "Job title is null for " + job.getIdentifier().getValue());
        assertNotNull(job.getHiringOrganization(), "Hiring organization is null for " + job.getIdentifier().getValue());

        System.out.println(job.toString());
    }

}
