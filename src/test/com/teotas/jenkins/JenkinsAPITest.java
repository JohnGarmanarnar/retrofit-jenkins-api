package com.teotas.jenkins;

import com.teotas.jenkins.api.models.objects.JenkinsJob;
import com.teotas.jenkins.api.models.objects.JenkinsView;
import static org.assertj.core.api.Assertions.assertThat;

import com.teotas.jenkins.api.models.responses.JenkinsJobResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class JenkinsAPITest {

    private static JenkinsAPI jenkins;

    @BeforeClass
    public static void beforeClass(){
        JenkinsAPIConnection connection = JenkinsAPIConnection.builder()
                .jenkinsBaseURL("http://myjenkinsurl.com")
                .userName("Add.Me")
                .userAuthToken("addme")
                .build();
        jenkins = new JenkinsAPI(connection);
    }

    @Test
    public void getViews(){
        ArrayList<JenkinsView> views = jenkins.viewAPI().getViews();
        assertThat(views.isEmpty()).isFalse();
    }

    @Test
    public void getJobs(){
        ArrayList<JenkinsJob> jobs = jenkins.viewAPI().getJobs("All");
        assertThat(jobs.isEmpty()).isFalse();
    }

    @Test
    public void getJobInfo(){
        JenkinsJobResponse job = jenkins.jobAPI().getJob("my-job-name");
        assertThat(job.getDisplayName()).isNotEmpty();
    }

}
