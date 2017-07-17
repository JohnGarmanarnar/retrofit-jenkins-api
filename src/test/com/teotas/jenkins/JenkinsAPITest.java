package com.teotas.jenkins;

import com.teotas.jenkins.api.models.objects.View;
import static org.assertj.core.api.Assertions.assertThat;

import com.teotas.jenkins.api.models.objects.Job;
import com.teotas.jenkins.api.models.responses.JenkinsJob;
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
        ArrayList<View> views = jenkins.viewAPI().getViews();
        assertThat(views.isEmpty()).isFalse();
    }

    @Test
    public void getJobs(){
        ArrayList<Job> jobs = jenkins.viewAPI().getJobs("All");
        assertThat(jobs.isEmpty()).isFalse();
    }

    @Test
    public void getJobInfo(){
        JenkinsJob job = jenkins.jobAPI().getJob("my-job-name");
        assertThat(job.getDisplayName()).isNotEmpty();
    }

}
