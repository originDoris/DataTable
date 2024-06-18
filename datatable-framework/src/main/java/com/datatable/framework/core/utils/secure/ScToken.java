package com.datatable.framework.core.utils.secure;



import com.datatable.framework.core.auth.JWTAuthProvider;
import com.datatable.framework.core.constants.MessageConstant;
import com.datatable.framework.core.options.ScConfigOptions;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;

import java.util.Date;

class ScToken {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScToken.class);
    private static final ScConfigOptions CONFIG = com.datatable.framework.core.runtime.DataTableConfig.getScConfig();

    static JsonObject jwtToken(final JsonObject data) {
        final JsonObject tokenData = data.copy();
        tokenData.remove("role");
        tokenData.remove("group");

        Sc.infoAuth(LOGGER, MessageConstant.TOKEN_JWT, tokenData.encode());
        final String token = JWTAuthProvider.makeJwtToken(tokenData);

        final JsonObject response = new JsonObject();
        response.put("access_token", token);

        final String refreshToken = JWTAuthProvider.makeJwtToken(response.copy());
        response.put("refresh_token", refreshToken);

        final Long iat = new Date().getTime() + CONFIG.getTokenExpired();
        response.put("iat", iat);
        return response;
    }
}
