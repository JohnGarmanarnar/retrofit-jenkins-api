package com.teotas.jenkins;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JenkinsAPIConnection extends RetrofitFactory {
    private String jenkinsBaseURL;
    private String userName;
    private String userAuthToken;
}
