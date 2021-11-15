package shop.j980108.task;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import shop.j980108.domain.SmsVo;

/**
 * @author 박인영
 * @date 2021-11-01
 * @name 문자발송
 */
public class CoolSms {
	
	static void sendSms(SmsVo sms) {
		
		CoolsmsKey key = new CoolsmsKey();
		Message coolsms = new Message(key.getApi_key(), key.getApi_secret());
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", sms.getTo());
		params.put("from", sms.getFrom());
		params.put("type", "SMS");
		params.put("text", sms.getContent());
		params.put("app_version", "test app 1.2");
		
		try {
			  JSONObject obj = (JSONObject) coolsms.send(params);
			  System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			  System.out.println(e.getMessage());
			  System.out.println(e.getCode());
		}
	}

	public static void main(String[] args) {
		SmsVo sms = new SmsVo();
		sms.setTo("01021270304");
		sms.setFrom("01021270304");
		sms.setContent("세번째 보내는 테스트 문자 메시지!");
		sendSms(sms);
	}
}
