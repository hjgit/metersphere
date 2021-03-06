package io.metersphere.api.dto.scenario;

import io.metersphere.api.dto.scenario.request.BodyFile;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Data
public class KeyValue {
    private String name;
    private String value;
    private String type;
    private List<BodyFile> files;
    private String description;
    private String contentType;
    private boolean enable;
    private boolean encode = true;
    private boolean required;

    public KeyValue() {
        this(null, null);
    }

    public KeyValue(String name, String value) {
        this(name, value, null);
    }

    public KeyValue(String name, String value, String description) {
        this(name, value, description, null);
    }

    public KeyValue(String name, String value, String description, String contentType) {
        this.name = name;
        this.value = value;
        this.description = description;
        this.contentType = contentType;
        this.enable = true;
        this.required = true;
    }

    public boolean isValid() {
        return (StringUtils.isNotBlank(name) || StringUtils.isNotBlank(value)) && !StringUtils.equalsIgnoreCase(type, "file");
    }

    public boolean isFile() {
        return (CollectionUtils.isNotEmpty(files)) && StringUtils.equalsIgnoreCase(type, "file");
    }
}
