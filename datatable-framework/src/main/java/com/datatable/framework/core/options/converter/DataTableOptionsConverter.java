package com.datatable.framework.core.options.converter;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;

/**
 * DataTableOptionsConverter
 * @author xhz
 */
public final class DataTableOptionsConverter {

    private DataTableOptionsConverter() {
    }

    public static void fromJson(final JsonObject json, final com.datatable.framework.core.options.DataTableOptions obj) {
        if (json.getValue("path") != null && json.getValue("path") instanceof String) {
            obj.setPath(json.getString("path"));
        }

        if (json.getValue("tokenHeaderKey") != null && json.getValue("tokenHeaderKey") instanceof String) {
            obj.setTokenHeaderKey(json.getString("tokenHeaderKey"));
        }

        if (json.getValue("sm2PublicKey") != null && json.getValue("sm2PublicKey") instanceof String) {
            obj.setSm2PublicKey(json.getString("sm2PublicKey"));
        }

        if (json.getValue("sm2PrivateKey") != null && json.getValue("sm2PrivateKey") instanceof String) {
            obj.setSm2PrivateKey(json.getString("sm2PrivateKey"));
        }
        if (json.getValue("serverDomain") != null && json.getValue("serverDomain") instanceof String) {
            obj.setServerDomain(json.getString("serverDomain"));
        }

        if (json.getValue("serverRunPath") != null && json.getValue("serverRunPath") instanceof String) {
            obj.setServerRunPath(json.getString("serverRunPath"));
        }

        if (json.getValue("tenantCode") != null && json.getValue("tenantCode") instanceof String) {
            obj.setTenantCode(json.getString("tenantCode"));
        }

        if (json.getValue("serverAppUserToken") != null && json.getValue("serverAppUserToken") instanceof String) {
            obj.setServerAppUserToken(json.getString("serverAppUserToken"));
        }
        if (json.getValue("serverAppAccessKey") != null && json.getValue("serverAppAccessKey") instanceof String) {
            obj.setServerAppAccessKey(json.getString("serverAppAccessKey"));
        }
        if (json.getValue("serverAppSecretKey") != null && json.getValue("serverAppSecretKey") instanceof String) {
            obj.setServerAppSecretKey(json.getString("serverAppSecretKey"));
        }
        if (json.getValue("serverRedisKey") != null && json.getValue("serverRedisKey") instanceof String) {
            obj.setServerRedisKey(json.getString("serverRedisKey"));
        }
        if (json.getValue("sessionName") != null && json.getValue("sessionName") instanceof String) {
            obj.setSessionName(json.getString("sessionName"));
        }
        if (json.getValue("serverRunUri") != null && json.getValue("serverRunUri") instanceof String) {
            obj.setServerRunUri(json.getString("serverRunUri"));
        }
        if (json.getValue("license") != null && json.getValue("license") instanceof String) {
            obj.setLicense(json.getString("license"));
        }
        if (json.getValue("dataCubeTenantCode") != null && json.getValue("dataCubeTenantCode") instanceof Number) {
            obj.setDataTableTenantCode(json.getNumber("dataCubeTenantCode").longValue());
        }
        if (json.getValue("wsPort") != null && json.getValue("wsPort") instanceof Number) {
            obj.setWsPort(json.getInteger("wsPort"));
        }
        if (json.getValue("captcha") != null && json.getValue("captcha") instanceof Boolean) {
            obj.setCaptcha(json.getBoolean("captcha"));
        }
        if (json.getValue("clusteredSession") != null && json.getValue("clusteredSession") instanceof Boolean) {
            obj.setClusteredSession(json.getBoolean("clusteredSession"));
        }
        if (json.getValue("excludeAuthPath") != null && json.getValue("excludeAuthPath") instanceof JsonArray) {
            ArrayList<String> excludePath = new ArrayList<>();
            JsonArray jsonArray = json.getJsonArray("excludeAuthPath");
            for (Object o : jsonArray) {
                excludePath.add((String) o);
            }
            obj.setExcludeAuthPath(excludePath);
        }
    }

}
