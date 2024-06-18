package com.datatable.framework.plugin.jooq.generate.builder;

import java.util.EnumSet;
import java.util.Set;

/**
 * BuildOptions
 * @author xhz
 */
public class BuildOptions {

    public enum BuildFlag {
        GENERATE_DATA_OBJECT_ANNOTATION
    }

    private ConverterInstantiationMethod converterInstantiationMethod;
    private Set<BuildFlag> buildFlags;

    public BuildOptions() {
        this(ConverterInstantiationMethod.SINGLETON, EnumSet.noneOf(BuildFlag.class));
    }

    public BuildOptions(ConverterInstantiationMethod converterInstantiationMethod,Set<BuildFlag> buildFlags) {
        this.converterInstantiationMethod = converterInstantiationMethod;
        this.buildFlags = buildFlags;
    }

    public ConverterInstantiationMethod getConverterInstantiationMethod() {
        return converterInstantiationMethod;
    }

    public Set<BuildFlag> getBuildFlags() {
        return buildFlags;
    }

    public BuildOptions withConverterInstantiationMethod(ConverterInstantiationMethod converterInstantiationMethod) {
        this.converterInstantiationMethod = converterInstantiationMethod;
        return this;
    }

    public BuildOptions withBuildFlags(Set<BuildFlag> buildFlags) {
        this.buildFlags = buildFlags;
        return this;
    }

    public BuildOptions addBuildFlags(BuildFlag buildFlag) {
        this.buildFlags.add(buildFlag);
        return this;
    }

    boolean isEnabled(BuildFlag flag){
        return buildFlags.contains(flag);
    }

}
