package com.teotas.jenkins.api.models.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JenkinsProperty {
    @JsonProperty("mentionAll")
    private boolean shouldMentionAll;
    @JsonProperty("notifyAborted")
    private boolean shouldNotifyAborted;
    @JsonProperty("notifyBackToNormal")
    private boolean shouldNotifyBackToNormal;
    @JsonProperty("notifyFailure")
    private boolean shouldNotifyFailure;
    @JsonProperty("notifyNotBuilt")
    private boolean shouldNotifyNotBuilt;
    @JsonProperty("notifySuccess")
    private boolean shouldNotifySuccess;
    @JsonProperty("notifyUnstable")
    private boolean shouldNotifyUnstable;
    @JsonProperty("startNotification")
    private boolean shouldNotifyOnStart;

    private String assignedChatRoom;
    private ArrayList<JenkinsParameterDefinition> parameterDefinitions;

}
