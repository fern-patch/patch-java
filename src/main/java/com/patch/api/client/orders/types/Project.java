package com.patch.api.client.orders.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = Project.Builder.class
)
public final class Project {
  private final ProjectId id;

  private final String name;

  private int _cachedHashCode;

  Project(ProjectId id, String name) {
    this.id = id;
    this.name = name;
  }

  @JsonProperty("id")
  public ProjectId getId() {
    return id;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Project && equalTo((Project) other);
  }

  private boolean equalTo(Project other) {
    return id.equals(other.id) && name.equals(other.name);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.name);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Project{" + "id: " + id + ", name: " + name + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    NameStage id(ProjectId id);

    Builder from(Project other);
  }

  public interface NameStage {
    _FinalStage name(String name);
  }

  public interface _FinalStage {
    Project build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, NameStage, _FinalStage {
    private ProjectId id;

    private String name;

    private Builder() {
    }

    @Override
    public Builder from(Project other) {
      id(other.getId());
      name(other.getName());
      return this;
    }

    @Override
    @JsonSetter("id")
    public NameStage id(ProjectId id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("name")
    public _FinalStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    public Project build() {
      return new Project(id, name);
    }
  }
}
