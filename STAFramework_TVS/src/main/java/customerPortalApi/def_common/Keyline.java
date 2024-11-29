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
"lineNumber",
"phoneKey",
"monitorLine",
"ringType"
})
public class Keyline {

@JsonProperty("lineNumber")
private Integer lineNumber;
@JsonProperty("phoneKey")
private Integer phoneKey;
@JsonProperty("monitorLine")
private Boolean monitorLine;
@JsonProperty("ringType")
private String ringType;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("lineNumber")
public Integer getLineNumber() {
return lineNumber;
}

@JsonProperty("lineNumber")
public void setLineNumber(Integer lineNumber) {
this.lineNumber = lineNumber;
}

@JsonProperty("phoneKey")
public Integer getPhoneKey() {
return phoneKey;
}

@JsonProperty("phoneKey")
public void setPhoneKey(Integer phoneKey) {
this.phoneKey = phoneKey;
}

@JsonProperty("monitorLine")
public Boolean getMonitorLine() {
return monitorLine;
}

@JsonProperty("monitorLine")
public void setMonitorLine(Boolean monitorLine) {
this.monitorLine = monitorLine;
}

@JsonProperty("ringType")
public String getRingType() {
return ringType;
}

@JsonProperty("ringType")
public void setRingType(String ringType) {
this.ringType = ringType;
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