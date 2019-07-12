package com.sure.mi.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101100659600";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCIxe8GB00iPBWpiAtQV4hmykIxY/MNHNiJofLe4ksRQUiGNet9xSiavF2bH1vtMseRbkbCa1U69qmbsZHHHusHy6+HfXTc4vnNh7aeJ6mqfiLp3cs0jzlp2gGZ226e+pRELJqKJB3D4yluAsPDmtiL788Sf0AO7N/xgFJ99WA28fUrvZ2tIMJPRW5i1nO9/06lfwrQBRQ3OQPBp92b2Sz3xYL7IisFpWiYv0m8ufY8e70eYY6sUQlsesvd5p80DBK/AnFLkDMSzeVQBImCuwnaFJCop6WM1DS+3Y1cRmUHuJj7txYFYUAmVRPDgnTujUjWCezD0+UAhRgOOMb3sGIFAgMBAAECggEABo8vimN5QIYPJ+U9XaoFAaD7kbDQbDWQ8PDSW/wQS5CM8NrPI2X8L4ePGaxkVTjVN1VJkXNiUASaV7wpWJpT/Ti4f0/19c3w2vmCOY1/ZozMEdkwMKIZx8jLwNw0Lu2nhKl689sNjmJrjzoUt2HKttNWY/W0VcLoboWP7ziAV8Iqy3DS0BHVGcgqh8ddRftxVgF6+CQp2o8ntmWDaKkwu0JR/p3vnDmXNGEV9kcpPhT+f7fpUYMxwNkDCsubP5ENcPzEQVsljCDSKlZJmuAoKzBf4+C+wneCD7yzyC+BP+GfhjFVYzp14phR5ZAmqUXA8JH42B2GPo4NDnEtPKMjAQKBgQDPlQMxvPmt5Cp96CaMKTA9hCnI5a9KU4TiRu/iOLr1GZMxxBsF78FvweO/6/EoiLW1CLFOWVtU3nGLOsdInlh4x91aUOXMqIyGX6m4sFPWiwykZO5f/9fB0kU594Hz3U8QdXNFCaZFtaYJ9iEX+nVSVwHCPuY5gxOp0m1OzT93xQKBgQCorNUd6rlu3Df97FHTG+CiZugyY5rHJImsOgc/34awDYPpC2A7zBRmeX3CuFbPt/1e70qt10aQd/tqMV08wDHEpHSQ5q1r7muJ2cGHqm4ewUMhmCLxZQ2saJUbXVT7WzYvrTXCcHY5eoXIu4noSAkfHSKalqeXxb9USsNE3e2lQQKBgBuY+xC8yBEXWZLdr2pI+5HiJVABQVnHWs5ekfvogOqfGNOv98vFQVljVK0qaCh0bHwCCNiaxqq03DGfgekkrCx6nfIo+TRJYE1pIH5eavcGC4s7o/l9YSjylKONRWivjpholQejrchsywNeBq5SbRCiYqh5hlA1HgMg58lnPj3lAoGAbVuwyLa4BtIsUyr2WgLG/0Ps406EuPxNbiYpMRZBAr+geGVxvRMxXscB7E8LqZzGXtiR+GeMTnobvNvIcWzCV5WwJYoJgeKQQk22Fbk/sBzo40z5yrwTw2YC1j0KrfSTCxInuqqjW9y+BEjivoCFuXBwUP3AJryEsafPNkUUoIECgYBp4OFNhV7PXDOhAxGuCOvQlEprQn/4kz/NyIIoZtU6EfIMplChf7FGeRoUtuoY20Ee57pgJTojb8WJsXV4YOM+jQIcHfoZ93VYfIfGbPmID4J8oPuFJuLpxbHfTlN0rjZB/EVrLL+Jw30oked0ZMrSK0sH5Avmdn5DkvRPFfPpfg==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnidUNwQoSNGOY2Cxdnb8QPEdY/GYJBsGOydaR4SqYLqLCmOp5A99NBQOeHmNO70Xlu8wGA0OovyzEpsZRe0tvEz4lUrg7nzKrPJxTTZvS+EPTWfepxT+CmZx6vBjsnw73DHJGsK8zaNBs4LvkQ1y6wmPVCr1W3urGJrSswkpR+1E9bQnUAxMWVshrMu2pHsMIaVDg7qc5SzzoUjbL9cnfVHLMPqc0ovU0oAcmqOCn0JK5gufJzBMo0hHpRAVws8y+i6EBv3rGJBefwxuOc4jXxbLXV2qWMEYQn+of8Ho7soLZzC2TSBAdz38NEtHU50wlm97siLa9SNTGMtcZb8a/wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8081/mi_war_exploded/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8081/mi_war_exploded/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
