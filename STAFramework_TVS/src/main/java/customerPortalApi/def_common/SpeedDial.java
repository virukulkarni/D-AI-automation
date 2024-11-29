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
"name",
"numberToDial",
"numberToCall"
})
public class SpeedDial {

@JsonProperty("name")
private String name;
@JsonProperty("numberToDial")
private String numberToDial;
@JsonProperty("numberToCall")
private String numberToCall;
private String ObjectName;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonIgnore
public String getObjectName() {
return ObjectName;
 }

@JsonIgnore
public void setObjectName(String ObjectName) {
this.ObjectName = ObjectName;
 }


@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("numberToDial")
public String getNumberToDial() {
return numberToDial;
}

@JsonProperty("numberToDial")
public void setNumberToDial(String numberToDial) {
this.numberToDial = numberToDial;
}

@JsonProperty("numberToCall")
public String getNumberToCall() {
return numberToCall;
}

@JsonProperty("numberToCall")
public void setNumberToCall(String numberToCall) {
this.numberToCall = numberToCall;
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
