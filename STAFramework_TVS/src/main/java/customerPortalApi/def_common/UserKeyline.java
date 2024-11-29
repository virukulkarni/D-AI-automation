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
"user",
"extension",
"userName",
"keylines"
})
public class UserKeyline {

@JsonProperty("user")
private String user;
@JsonProperty("extension")
private String extension;
@JsonProperty("userName")
private String userName;
@JsonProperty("keylines")
private List<Keyline> keylines = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("user")
public String getUser() {
return user;
}

@JsonProperty("user")
public void setUser(String user) {
this.user = user;
}

@JsonProperty("extension")
public String getExtension() {
return extension;
}

@JsonProperty("extension")
public void setExtension(String extension) {
this.extension = extension;
}

@JsonProperty("userName")
public String getUserName() {
return userName;
}

@JsonProperty("userName")
public void setUserName(String userName) {
this.userName = userName;
}

@JsonProperty("keylines")
public List<Keyline> getKeylines() {
return keylines;
}

@JsonProperty("keylines")
public void setKeylines(List<Keyline> keylines) {
this.keylines = keylines;
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