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
	"firstName",
	"lastName",
	"emailAddress",
	"homePhone",
	"mobilePhone",
	"language",
	"extension",
	"username",
	"passwordSettings"
})
public class Profile {

@JsonProperty("firstName")
private String firstName;
@JsonProperty("lastName")
private String lastName;
@JsonProperty("emailAddress")
private String emailAddress;
@JsonProperty("username")
private String username;
@JsonProperty("homePhone")
private String homePhone;
@JsonProperty("mobilePhone")
private String mobilePhone;
@JsonProperty("language")
private String language;
@JsonProperty("passwordSettings")
private PasswordSettings passwordSettings;
@JsonProperty("extension")
private String extension;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("firstName")
public String getFirstName() {
return firstName;
 }

@JsonProperty("firstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
 }

@JsonProperty("lastName")
public String getLastName() {
return lastName;
 }

@JsonProperty("lastName")
public void setLastName(String lastName) {
this.lastName = lastName;
 }

@JsonProperty("emailAddress")
public String getEmailAddress() {
return emailAddress;
 }

@JsonProperty("emailAddress")
public void setEmailAddress(String emailAddress) {
this.emailAddress = emailAddress;
 }

@JsonProperty("username")
public String getUsername() {
return username;
 }

@JsonProperty("username")
public void setUsername(String username) {
this.username = username;
 }

@JsonProperty("homePhone")
public String getHomePhone() {
return homePhone;
 }

@JsonProperty("homePhone")
public void setHomePhone(String homePhone) {
this.homePhone = homePhone;
 }

@JsonProperty("mobilePhone")
public String getMobilePhone() {
return mobilePhone;
 }

@JsonProperty("mobilePhone")
public void setMobilePhone(String mobilePhone) {
this.mobilePhone = mobilePhone;
 }

@JsonProperty("language")
public String getLanguage() {
return language;
 }

@JsonProperty("language")
public void setLanguage(String language) {
this.language = language;
 }

@JsonProperty("passwordSettings")
public PasswordSettings getPasswordSettings() {
return passwordSettings;
 }

@JsonProperty("passwordSettings")
public void setPasswordSettings(PasswordSettings passwordSettings) {
this.passwordSettings = passwordSettings;
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
