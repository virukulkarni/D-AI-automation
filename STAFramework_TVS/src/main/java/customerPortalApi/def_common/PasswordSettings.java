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
"changePassword",
"oldPassword",
"password",
"confirmPassword"
})
public class PasswordSettings {

@JsonProperty("changePassword")
private Boolean changePassword;
@JsonProperty("oldPassword")
private String oldPassword;
@JsonProperty("password")
private String password;
@JsonProperty("confirmPassword")
private String confirmPassword;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("changePassword")
public Boolean getChangePassword() {
return changePassword;
 }

@JsonProperty("changePassword")
public void setChangePassword(Boolean changePassword) {
this.changePassword = changePassword;
 }

@JsonProperty("oldPassword")
public String getOldPassword() {
return oldPassword;
 }

@JsonProperty("oldPassword")
public void setOldPassword(String oldPassword) {
this.oldPassword = oldPassword;
 }

@JsonProperty("password")
public String getPassword() {
return password;
 }

@JsonProperty("password")
public void setPassword(String password) {
this.password = password;
 }

@JsonProperty("confirmPassword")
public String getConfirmPassword() {
return confirmPassword;
 }

@JsonProperty("confirmPassword")
public void setConfirmPassword(String confirmPassword) {
this.confirmPassword = confirmPassword;
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
