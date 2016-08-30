package com.chuangyejia.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.User;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.tools.StartupsTempShow;
import com.chuangyejia.tools.StartupsUtil;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component(value="getStartupsInId4ModifyAction")
@Scope("prototype")
public class GetStartupsInId4ModifyAction extends ActionSupport {

	private IStartupsService ss;
	public IStartupsService getSs() {
		return ss;
	}
	@Resource(name="ss")
	public void setSs(IStartupsService ss) {
		this.ss = ss;
	}
	
	
	private String item;
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(item != null && item.trim().hashCode() != 0) {
			User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
			StartupsTempShow sts = ss.getStartupsTempShowInId(item);
			if(sts != null && user != null && sts.getStartupsLeader().getUserId().equals(user.getUserId())) {
				for(int  i = 0; i < StartupsUtil.ServiceType.length; i++) {
					if(StartupsUtil.ServiceType[i].equals(sts.getStartupsServiceType()))
						sts.setStartupsServiceType(String.valueOf(i));
				}
				
				for(int i = 0; i < StartupsUtil.OperationStage.length; i++) {
					if(StartupsUtil.OperationStage[i].equals(sts.getStartupsOperationStage()))
						sts.setStartupsOperationStage(String.valueOf(i));
				}
				String[] require = sts.getStartupsCopartnerRequire().trim().split(" ");
				StringBuffer requireSb = new StringBuffer();

				for(int i = 0; i < require.length; i++) {
					for(int j = 0; j < StartupsUtil.CopartnerRequire.length; j++) {
						if((StartupsUtil.CopartnerRequire[j]).equals(require[i])) {
							requireSb.append(String.valueOf(j) + ",");
						}
					}
				}
				
				sts.setStartupsCopartnerRequire(requireSb.toString());
				ServletActionContext.getRequest().setAttribute("sts", sts);
				return SUCCESS;
			} else 
				return NONE;
			
		} else {
			return NONE;
		}
	}
}
