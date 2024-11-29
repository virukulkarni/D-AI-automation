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
"extension",
"reportingNumber"
})
public class AcdGroup {

@JsonProperty("extension")
private String extension;
@JsonProperty("reportingNumber")
private String reportingNumber;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("extension")
public String getExtension() {
return extension;
}

@JsonProperty("extension")
public void setExtension(String extension) {
this.extension = extension;
}

@JsonProperty("reportingNumber")
public String getReportingNumber() {
return reportingNumber;
}

@JsonProperty("reportingNumber")
public void setReportingNumber(String reportingNumber) {
this.reportingNumber = reportingNumber;
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
