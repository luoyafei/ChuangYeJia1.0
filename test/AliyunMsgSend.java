import org.junit.Test;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;

public class AliyunMsgSend {

	@Test
	public void sample() {        
        /*IClientProfile profile = DefaultProfile.getProfile("cn-xi'an", "<your accessKey>", "<your accessSecret>");*/
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAInje99sLxNroR", "Egytg16CY8qc2cm0Fz2ETaKBjkuFe3");
         try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms",  "sms.aliyuncs.com");
		} catch (ClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendSmsRequest request = new SingleSendSmsRequest();
        try {
//            request.setSignName("控制台创建的签名名称");
        	request.setSignName("");
        	request.setTemplateCode("");
//          request.setTemplateCode("控制台创建的模板CODE");
            request.setParamString("{}");
            
            request.setRecNum("18829346394");
            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
		} catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
