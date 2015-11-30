package me.chanjar.weixin.mp.demo;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import org.testng.annotations.Test;

/**
 * Created by David Li on 2015/11/30.
 */
public class MessageSendTest {
    @Test
    public void testMessageSend() {
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wx2df5d7e4ce8a04ca"); // 设置微信公众号的appid
        config.setSecret("d348e89e0db5536d5c1dade129e9a5f8"); // 设置微信公众号的app corpSecret
        config.setToken("XF3E2FF34DFD4457FASAF34565FDA3562"); // 设置微信公众号的token
        //        config.setAesKey("..."); // 设置微信公众号的EncodingAESKey

        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);

        // 用户的openid在下面地址获得
        // https://mp.weixin.qq.com/debug/cgi-bin/apiinfo?t=index&type=用户管理&form=获取关注者列表接口%20/user/get
        String openid = "oC9AeszaRsNzRp6_iPPzBe9N3Byg";
        WxMpCustomMessage message = WxMpCustomMessage.TEXT().toUser(openid).content("Hello World").build();
        try {
            wxService.customMessageSend(message);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }
}
