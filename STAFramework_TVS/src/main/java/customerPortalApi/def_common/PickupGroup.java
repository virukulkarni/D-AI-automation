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
"autoPickup",
"lock",
"extension"
})
public class PickupGroup {

@JsonProperty("autoPickup")
private Boolean autoPickup;
@JsonProperty("lock")
private Boolean lock;
@JsonProperty("extension")
private String extension;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("autoPickup")
public Boolean getAutoPickup() {
return autoPickup;
}

@JsonProperty("autoPickup")
public void setAutoPickup(Boolean autoPickup) {
this.autoPickup = autoPickup;
}

@JsonProperty("lock")
public Boolean getLock() {
return lock;
}

@JsonProperty("lock")
public void setLock(Boolean lock) {
this.lock = lock;
}

@JsonProperty("extension")
public String getExtension() {
return extension;
}

@JsonProperty("extension")
public void setExtension(String extension) {
this.extension = extension;
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