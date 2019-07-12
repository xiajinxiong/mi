package com.sure.mi.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.sure.mi.config.AlipayConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.alipay.api.AlipayConstants.CHARSET;
import static com.alipay.api.AlipayConstants.CHARSET_GBK;

public class AlipayUtil {

    public static void pay(HttpServletResponse response, String no, double price, String subject,
                             String body) throws AlipayApiException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,
                AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json",
                AlipayConfig.charset, AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);
        AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayTradePagePayRequest.setNotifyUrl(AlipayConfig.notify_url);

        alipayTradePagePayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" +
                no +
                "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":\"" +
                price +
                "\"," +
                "    \"subject\":\""
                + subject +
                "\"," +
                "    \"body\":\"" +
                body + "\"," +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "  }");
        System.out.println(alipayTradePagePayRequest.getBizContent());
        String form = null;
        try {
            form = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + CHARSET_GBK);
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }
}
