import com.teotas.jenkins.JenkinsAPI;
import com.teotas.jenkins.JenkinsAPIConnection;
import com.teotas.jenkins.api.models.objects.JenkinsJob;
import com.teotas.jenkins.api.models.objects.JenkinsView;
import static org.assertj.core.api.Assertions.assertThat;

import com.teotas.jenkins.api.models.responses.JenkinsJobResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class JenkinsAPITest {

    private static JenkinsAPI jenkins;

    @BeforeAll
    private static void beforeClass(){
        JenkinsAPIConnection connection = JenkinsAPIConnection.builder()
                .jenkinsBaseURL("http://myjenkinsurl.com")
                .userName("Add.Me")
                .userAuthToken("addme")
                .build();
        jenkins = new JenkinsAPI(connection);
    }

    @Test
    private void getViews(){
        ArrayList<JenkinsView> views = jenkins.viewAPI().getViews();
        assertThat(views.isEmpty()).isFalse();
    }

    @Test
    private void getJobs(){
        ArrayList<JenkinsJob> jobs = jenkins.viewAPI().getJobs("All");
        assertThat(jobs.isEmpty()).isFalse();
    }

    @Test
    private void getJobInfo(){
        JenkinsJobResponse job = jenkins.jobAPI().getJob("my-job-name");
        assertThat(job.getDisplayName()).isNotEmpty();
    }

}
