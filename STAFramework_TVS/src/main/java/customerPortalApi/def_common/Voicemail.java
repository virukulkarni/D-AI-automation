package customerPortalApi.def_common;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"forwardToEmail",
"operatorExtension0",
"mailboxType",
"voicemailMessages",
"embeddedUnifiedMessaging",
"featureCos"
})
public class Voicemail {

@JsonProperty("enabled")
private Boolean enabled;
@JsonProperty("forwardToEmail")
private ForwardToEmail forwardToEmail;
@JsonProperty("operatorExtension0")
private OperatorExtension0 operatorExtension0;
@JsonProperty("mailboxType")
private String mailboxType;
@JsonProperty("voicemailMessages")
private VoicemailMessages voicemailMessages;
@JsonProperty("embeddedUnifiedMessaging")
private EmbeddedUnifiedMessaging embeddedUnifiedMessaging;
@JsonProperty("featureCos")
private FeatureCos featureCos;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("enabled")
public Boolean getEnabled() {
return enabled;
}

@JsonProperty("enabled")
public void setEnabled(Boolean enabled) {
this.enabled = enabled;
}

@JsonProperty("forwardToEmail")
public ForwardToEmail getForwardToEmail() {
return forwardToEmail;
}

@JsonProperty("forwardToEmail")
public void setForwardToEmail(ForwardToEmail forwardToEmail) {
this.forwardToEmail = forwardToEmail;
}

@JsonProperty("operatorExtension0")
public OperatorExtension0 getOperatorExtension0() {
return operatorExtension0;
}

@JsonProperty("operatorExtension0")
public void setOperatorExtension0(OperatorExtension0 operatorExtension0) {
this.operatorExtension0 = operatorExtension0;
}

@JsonProperty("mailboxType")
public String getMailboxType() {
return mailboxType;
}

@JsonProperty("mailboxType")
public void setMailboxType(String mailboxType) {
this.mailboxType = mailboxType;
}

@JsonProperty("voicemailMessages")
public VoicemailMessages getVoicemailMessages() {
return voicemailMessages;
}

@JsonProperty("voicemailMessages")
public void setVoicemailMessages(VoicemailMessages voicemailMessages) {
this.voicemailMessages = voicemailMessages;
}

@JsonProperty("embeddedUnifiedMessaging")
public EmbeddedUnifiedMessaging getEmbeddedUnifiedMessaging() {
return embeddedUnifiedMessaging;
}

@JsonProperty("embeddedUnifiedMessaging")
public void setEmbeddedUnifiedMessaging(EmbeddedUnifiedMessaging embeddedUnifiedMessaging) {
this.embeddedUnifiedMessaging = embeddedUnifiedMessaging;
}

@JsonProperty("featureCos")
public FeatureCos getFeatureCos() {
return featureCos;
}

@JsonProperty("featureCos")
public void setFeatureCos(FeatureCos featureCos) {
this.featureCos = featureCos;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}