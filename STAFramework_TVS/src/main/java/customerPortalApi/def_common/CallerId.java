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
"id",
"name",
"number",
"isCustomField",
"lastModified"
})
public class CallerId {

@JsonProperty("id")
private String id;
private String name;
@JsonProperty("number")
private String number;
@JsonProperty("isCustomField")
private Boolean isCustomField;
@JsonProperty("lastModified")
private String lastModified;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("id")
public String getId() {
return id;
 }

@JsonProperty("id")
public void setId(String id) {
this.id = id;
 }



@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("number")
public String getNumber() {
return number;
}

@JsonProperty("number")
public void setNumber(String number) {
this.number = number;
}

@JsonProperty("isCustomField")
public Boolean getIsCustomField() {
return isCustomField;
}

@JsonProperty("isCustomField")
public void setIsCustomField(Boolean isCustomField) {
this.isCustomField = isCustomField;
}

@JsonProperty("lastModified")
public String getLastModified() {
return lastModified;
}

@JsonProperty("lastModified")
public void setLastModified(String lastModified) {
this.lastModified = lastModified;
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


