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
"deleteAfter",
"maximumNumber"
})
public class VoicemailMessages {

@JsonProperty("deleteAfter")
private String deleteAfter;
@JsonProperty("maximumNumber")
private String maximumNumber;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("deleteAfter")
public String getDeleteAfter() {
return deleteAfter;
}

@JsonProperty("deleteAfter")
public void setDeleteAfter(String deleteAfter) {
this.deleteAfter = deleteAfter;
}

@JsonProperty("maximumNumber")
public String getMaximumNumber() {
return maximumNumber;
}

@JsonProperty("maximumNumber")
public void setMaximumNumber(String maximumNumber) {
this.maximumNumber = maximumNumber;
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