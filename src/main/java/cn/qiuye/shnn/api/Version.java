package cn.qiuye.shnn.api;

import lombok.Getter;

@Getter
public enum Version {

    V5("v5", 256);

    final String id;
    final int multiplier;

    Version(String id, int multiplier) {
        this.id = id;
        this.multiplier = multiplier;
    }

    public static Version getVersion(String version) {
        return V5;
    }
}
