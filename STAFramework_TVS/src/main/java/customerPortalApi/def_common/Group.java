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
"id",
"type",
"huntGroup",
"pageGroup",
"pickGroup",
"ringGroup",
"acdGroup",
"name",
"site",
"numberOfKeylines",
"userKeylines",
"users"
})
public class Group {
private String ObjectName;
@JsonProperty("id")
private String id;
@JsonProperty("type")
private String type;
@JsonProperty("huntGroup")
private HuntGroup huntGroup;
@JsonProperty("pageGroup")
private PageGroup pageGroup;
@JsonProperty("pickupGroup")
private PickupGroup pickupGroup;
@JsonProperty("ringGroup")
private RingGroup ringGroup;
@JsonProperty("acdGroup")
private AcdGroup acdGroup;

@JsonProperty("numberOfKeylines")
private String numberOfKeylines;
@JsonProperty("userKeylines")
private List<UserKeyline> userKeylines = null;	

@JsonProperty("name")
private String name;
@JsonProperty("site")
private Site site;
@JsonProperty("users")
private List<Object> users = null;
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

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("huntGroup")
public HuntGroup getHuntGroup() {
return huntGroup;
}

@JsonProperty("huntGroup")
public void setHuntGroup(HuntGroup huntGroup) {
this.huntGroup = huntGroup;
}

@JsonProperty("pageGroup")
public PageGroup getpageGroup() {
return pageGroup;
}

@JsonProperty("pickupGroup")
public void setpickupGroup(PickupGroup pickupGroup) {
this.pickupGroup = pickupGroup;
}

@JsonProperty("pickupGroup")
public PickupGroup getpickupGroup() {
return pickupGroup;
}

@JsonProperty("pageGroup")
public void setpageGroup(PageGroup pageGroup) {
this.pageGroup = pageGroup;
}

@JsonProperty("ringGroup")
public RingGroup getRingGroup() {
return ringGroup;
}

@JsonProperty("ringGroup")
public void setRingGroup(RingGroup ringGroup) {
this.ringGroup = ringGroup;
}

@JsonProperty("acdGroup")
public AcdGroup getAcdGroup() {
return acdGroup;
}

@JsonProperty("acdGroup")
public void setAcdGroup(AcdGroup acdGroup) {
this.acdGroup = acdGroup;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("site")
public Site getSite() {
return site;
}

@JsonProperty("site")
public void setSite(Site site) {
this.site = site;
}

@JsonProperty("numberOfKeylines")
public String getNumberOfKeylines() {
return numberOfKeylines;
}

@JsonProperty("numberOfKeylines")
public void setNumberOfKeylines(String numberOfKeylines) {
this.numberOfKeylines = numberOfKeylines;
}

@JsonProperty("userKeylines")
public List<UserKeyline> getUserKeylines() {
return userKeylines;
}

@JsonProperty("userKeylines")
public void setUserKeylines(List<UserKeyline> userKeylines) {
this.userKeylines = userKeylines;
}


@JsonProperty("users")
public List<Object> getUsers() {
return users;
}

@JsonProperty("users")
public void setUsers(List<Object> users) {
this.users = users;
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