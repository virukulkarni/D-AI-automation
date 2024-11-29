package customerPortalApi.def_common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"mode",
"extension",
"did",
"lock",
"groupTimers",
"overflowPoint",
"voicemail",
"callRerouting"
})
public class RingGroup {

@JsonProperty("mode")
private String mode;
@JsonProperty("extension")
private String extension;
@JsonProperty("did")
private List<Object> did = null;
@JsonProperty("lock")
private Boolean lock;
@JsonProperty("groupTimers")
private GroupTimers groupTimers;
@JsonProperty("overflowPoint")
private OverflowPoint overflowPoint;
@JsonProperty("voicemail")
private Voicemail voicemail;
@JsonProperty("callRerouting")
private CallRerouting callRerouting;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("mode")
public String getMode() {
return mode;
}

@JsonProperty("mode")
public void setMode(String mode) {
this.mode = mode;
}

@JsonProperty("extension")
public String getExtension() {
return extension;
}

@JsonProperty("extension")
public void setExtension(String extension) {
this.extension = extension;
}

@JsonProperty("did")
public List<Object> getDid() {
return did;
}

@JsonProperty("did")
public void setDid(List<Object> did) {
this.did = did;
}

@JsonProperty("lock")
public Boolean getLock() {
return lock;
}

@JsonProperty("lock")
public void setLock(Boolean lock) {
this.lock = lock;
}

@JsonProperty("groupTimers")
public GroupTimers getGroupTimers() {
return groupTimers;
}

@JsonProperty("groupTimers")
public void setGroupTimers(GroupTimers groupTimers) {
this.groupTimers = groupTimers;
}

@JsonProperty("overflowPoint")
public OverflowPoint getOverflowPoint() {
return overflowPoint;
}

@JsonProperty("overflowPoint")
public void setOverflowPoint(OverflowPoint overflowPoint) {
this.overflowPoint = overflowPoint;
}

@JsonProperty("voicemail")
public Voicemail getVoicemail() {
return voicemail;
}

@JsonProperty("voicemail")
public void setVoicemail(Voicemail voicemail) {
this.voicemail = voicemail;
}

@JsonProperty("callRerouting")
public CallRerouting getCallRerouting() {
return callRerouting;
}

@JsonProperty("callRerouting")
public void setCallRerouting(CallRerouting callRerouting) {
this.callRerouting = callRerouting;
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
