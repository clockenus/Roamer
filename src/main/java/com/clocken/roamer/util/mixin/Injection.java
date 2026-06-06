package com.clocken.roamer.util.mixin;

public class Injection {
    public String mixinClassName;
    public String method;

    public Injection(String mixinClassName, String method) {
        this.mixinClassName = mixinClassName;
        this.method = method;
    }
}
