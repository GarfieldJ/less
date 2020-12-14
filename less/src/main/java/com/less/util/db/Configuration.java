package com.less.util.db;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Configuration {
    static Map<String, Mapper1> mapper1Map = new ConcurrentHashMap<>();
    public Map<String, Mapper1> getMappers() {

        return mapper1Map;
    }
}
