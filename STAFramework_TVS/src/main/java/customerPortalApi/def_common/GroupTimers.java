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
"ringing",
"cascade",
"queued"
})
public class GroupTimers {

@JsonProperty("ringing")
private Integer ringing;
@JsonProperty("cascade")
private Integer cascade;
@JsonProperty("queued")
private Integer queued;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("ringing")
public Integer getRinging() {
return ringing;
}

@JsonProperty("ringing")
public void setRinging(Integer ringing) {
this.ringing = ringing;
}

@JsonProperty("cascade")
public Integer getCascade() {
return cascade;
}

@JsonProperty("cascade")
public void setCascade(Integer cascade) {
this.cascade = cascade;
}

@JsonProperty("queued")
public Integer getQueued() {
return queued;
}

@JsonProperty("queued")
public void setQueued(Integer queued) {
this.queued = queued;
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