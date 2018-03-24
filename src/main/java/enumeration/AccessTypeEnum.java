package enumeration;

/**
 * Created by cong on 2018-01-08.
 * 访问类型枚举
 */
public enum AccessTypeEnum {

    HTTP_REQUEST("http请求",1),
    HTTP_RESPONSE("http响应",2),
    DATABASE_REQUEST("数据库请求",3),
    DATABASE_RESPONSE("数据库响应",4),
    EXCEPTION("异常",5);


    AccessTypeEnum(String desc, int code){
        this.desc=desc;
        this.code=code;
    }

    /**
     * 枚举值描述
     */
    private String desc;

    /**
     * 枚举值
     */
    private int code;

    public static boolean isError(int code){
        return EXCEPTION.code==code;
    }

    public static boolean isRequest(int code){
        return HTTP_REQUEST.code==code||DATABASE_REQUEST.code==code;
    }

    public static boolean isResponse(int code){
        return HTTP_RESPONSE.code==code||DATABASE_RESPONSE.code==code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
