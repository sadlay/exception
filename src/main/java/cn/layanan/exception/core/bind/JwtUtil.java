package cn.layanan.exception.core.bind;

import io.jsonwebtoken.Jwts;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:12 2019/8/7
 * @Modified By:IntelliJ IDEA
 */

public class JwtUtil {

    public static String get(String token, String key) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }
}
