package com.soaint.prueba.venta.auth;

public class JwtConfig {

    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

    public static final String RSA_PRIVADA= "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpQIBAAKCAQEAw1qQppy5FVpS5hYuT497xNoud0ZQrg/Zc4ZHU0heAQCpSrJ3\n" +
            "4t6lPNVLiyDcu+eGt5OXy9xREh3yb+0j7l9DBoH6KS0Ttg3fDRxfb5dVTaO2safv\n" +
            "s8qM717/P7Y357n4iTV+pXWFcONKsmTpOGaWOqRbug/FciZ+41kQb7m+qxhBeRcn\n" +
            "v3t6MYICs7xgqNBq9iTmo0d+QljLKQ+vXdI3h6k6xNv4hcSzJFwR5K9cmeRDUwQ6\n" +
            "HhY9gKCE+Gc/pSZggkU0sww3vMfwk5UJT7Fn1j1BYA5pKDE/NFsLnzH+tRrukq9H\n" +
            "YboWZ9t8Kuh35eEOONkY3S28lIZAFjireCaYjwIDAQABAoIBAQCWDSNchrb3esiA\n" +
            "KPtraxezba8ROLZR7KSnQrXYd5aVCJAAazMA1Olw35jGBfjmcAEfUsPe95xh4RTN\n" +
            "+gWGXC+ceQvQwuoIBYGVjXyUt1Xza9Oxg//vRp6YYoyGwI0Sdds8cRWVO77CpiND\n" +
            "AZXOF6Y+5u357ZFIi98c+9VPLAoTWher/Xf6/DKmTThC4OBIyUDaKBNH/h679PXi\n" +
            "Hf85hvu9VV2pC7puAU9ns7evaSJtliCIv/p0VMGGqHK/kFitDnhdlshKquH0CaVw\n" +
            "xmxYZ1TnSVGmVvhbhDLx/483/kcuI7outEY0a46dF1ogjD5cSs1nH9XupFA45/fN\n" +
            "lbptYmCJAoGBAOBQqaJPa/4dEYMybte29YdkHKry78XwaxMnSQ8i8AdCfYlCJjlY\n" +
            "wAdRT86vYw6leUGlw6QawmSCF57KRw88sOFED1AA+bUIdKMZd0XYYtXcRncNKioh\n" +
            "Ox6+s3j4BC1mH2XMwW/0/hUXtWDE8yt53n+JdNA+YhV//Ea8t13kbZUbAoGBAN7y\n" +
            "pdFu9gsvEBQuBY28rZgUMkh5Nqz5TgYqeIfp2Y1O5MaeVR/jd7qfiodo0gTXdpsj\n" +
            "Vy4O7TEqODHomeJmMfbaqSRaldDHF89O5nPrUccSOdVDtUm9armqOzBsZJZ41jxE\n" +
            "/Qw0LfYXVBlvjspH3cplA8kftlMd/z9idT7Fw+WdAoGBAJoGqUR7drMJsMG+up/C\n" +
            "0LuEAa9cm0n2eP+w5RjQq7LAdETwuCB+kXU03zET+1fORgHO2hTwDvVG4wM08DBF\n" +
            "Q0ubGUydLtmhEb4AuYarO8qPs48B6ib9pIPK/J+e5fdqfTrAqz6+Ik3HdtMYycTb\n" +
            "rO00LJLlkyIiPM8xvFNri9drAoGBAKZ4WjYqe09YgdH/lygBNUGz+uPAloHL2WWj\n" +
            "OsKJa2cm/I4N1ZPs/g58aCy5qO/yjl5CoisC/DrUwocJnjW9hxtCpD8/4FO3BWFH\n" +
            "Ea6GjFZvln1WhDweUl117aI3nVf5vEXeYXBGWfdB7grcEKubw9EHYi9AHZysblW+\n" +
            "x7rqYl7FAoGAGxfCBIAEFEUSNxS/OiBGCZoE6jPuCS0WKRBiL3UuXJKBLId2EOFE\n" +
            "IcFTC5atrtNFVINwHy54IkoZoSfK8zFuxTIeDdVDIPH+NMMzIORJBNbtcVM8CiQT\n" +
            "swWjGSY35xxdv9JJulLzZKcYsjqH+0QGq5CfZcUTAwuwujpytQSYmNA=\n" +
            "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw1qQppy5FVpS5hYuT497\n" +
            "xNoud0ZQrg/Zc4ZHU0heAQCpSrJ34t6lPNVLiyDcu+eGt5OXy9xREh3yb+0j7l9D\n" +
            "BoH6KS0Ttg3fDRxfb5dVTaO2safvs8qM717/P7Y357n4iTV+pXWFcONKsmTpOGaW\n" +
            "OqRbug/FciZ+41kQb7m+qxhBeRcnv3t6MYICs7xgqNBq9iTmo0d+QljLKQ+vXdI3\n" +
            "h6k6xNv4hcSzJFwR5K9cmeRDUwQ6HhY9gKCE+Gc/pSZggkU0sww3vMfwk5UJT7Fn\n" +
            "1j1BYA5pKDE/NFsLnzH+tRrukq9HYboWZ9t8Kuh35eEOONkY3S28lIZAFjireCaY\n" +
            "jwIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
