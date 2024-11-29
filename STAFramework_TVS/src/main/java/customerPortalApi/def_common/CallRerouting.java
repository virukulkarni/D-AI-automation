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
"day",
"night2",
"night",
"busy",
"dayIndex",
"nightIndex",
"night2Index",
"busyIndex",
"dayCustomField",
"nightCustomField",
"night2CustomField",
"busyCustomField"
})
public class CallRerouting {

@JsonProperty("day")
private String day;
@JsonProperty("night")
private String night;
@JsonProperty("night2")
private String night2;
@JsonProperty("busy")
private String busy;
@JsonProperty("dayIndex")
private String dayIndex;
@JsonProperty("nightIndex")
private String nightIndex;
@JsonProperty("night2Index")
private String night2Index;
@JsonProperty("busyIndex")
private String busyIndex;
@JsonProperty("dayCustomField")
private Boolean dayCustomField;
@JsonProperty("nightCustomField")
private Boolean nightCustomField;
@JsonProperty("night2CustomField")
private Boolean night2CustomField;
@JsonProperty("busyCustomField")
private Boolean busyCustomField;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("day")
public String getDay() {
return day;
 }

@JsonProperty("day")
public void setDay(String day) {
this.day = day;
 }

@JsonProperty("night")
public String getNight() {
return night;
 }

@JsonProperty("night")
public void setNight(String night) {
this.night = night;
 }

@JsonProperty("night2")
public String getNight2() {
return night2;
 }

@JsonProperty("night2")
public void setNight2(String night2) {
this.night2 = night2;
 }

@JsonProperty("busy")
public String getBusy() {
return busy;
 }

@JsonProperty("busy")
public void setBusy(String busy) {
this.busy = busy;
 }


@JsonProperty("dayIndex")
public String getDayIndex() {
return dayIndex;
}

@JsonProperty("dayIndex")
public void setDayIndex(String dayIndex) {
this.dayIndex = dayIndex;
}

@JsonProperty("nightIndex")
public String getNightIndex() {
return nightIndex;
}

@JsonProperty("nightIndex")
public void setNightIndex(String nightIndex) {
this.nightIndex = nightIndex;
}

@JsonProperty("night2Index")
public String getNight2Index() {
return night2Index;
}

@JsonProperty("night2Index")
public void setNight2Index(String night2Index) {
this.night2Index = night2Index;
}

@JsonProperty("busyIndex")
public String getBusyIndex() {
return busyIndex;
}

@JsonProperty("busyIndex")
public void setBusyIndex(String busyIndex) {
this.busyIndex = busyIndex;
}

@JsonProperty("dayCustomField")
public Boolean getDayCustomField() {
return dayCustomField;
}

@JsonProperty("dayCustomField")
public void setDayCustomField(Boolean dayCustomField) {
this.dayCustomField = dayCustomField;
}

@JsonProperty("nightCustomField")
public Boolean getNightCustomField() {
return nightCustomField;
}

@JsonProperty("nightCustomField")
public void setNightCustomField(Boolean nightCustomField) {
this.nightCustomField = nightCustomField;
}

@JsonProperty("night2CustomField")
public Boolean getNight2CustomField() {
return night2CustomField;
}

@JsonProperty("night2CustomField")
public void setNight2CustomField(Boolean night2CustomField) {
this.night2CustomField = night2CustomField;
}

@JsonProperty("busyCustomField")
public Boolean getBusyCustomField() {
return busyCustomField;
}

@JsonProperty("busyCustomField")
public void setBusyCustomField(Boolean busyCustomField) {
this.busyCustomField = busyCustomField;
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