package com.nieyue.action;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.nieyue.bean.Account;
import com.nieyue.bean.Major;
import com.nieyue.bean.Positional;
import com.nieyue.bean.StudentClass;
import com.nieyue.service.AccountService;
import com.nieyue.service.MajorService;
import com.nieyue.service.PositionalService;
import com.nieyue.service.StudentClassService;
import com.nieyue.util.ActionContextUtil;
import com.nieyue.util.DateUtil;
import com.nieyue.util.MyDESutil;
import com.nieyue.util.MyJSON;
import com.nieyue.util.ResultUtil;


/**
 * 管理员登录、退出
 * @author yy
 *
 */
public class AccountAction extends BaseAction<Account,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AccountService accountService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private StudentClassService studentClassService;
	@Autowired
	private PositionalService positionalService;

	private String validate;	//验证码 
	private Account account=new Account();

	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	@Override
	public Account getModel() {
		return account;
	}
	/**
	 * 登陆
	 * @return
	 * @throws Exception
	 */
	public String login()  {
		Map<String,Object> session = ActionContextUtil.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		String shapwd = MyDESutil.getMD5(account.getPassword());
		Account a=accountService.accountLogin(account.getIdentifier(),shapwd);
		//Account a=accountService.accountLogin(account.getPhone(),shapwd);
		if(a==null){
			map.put("account", a);
			result=ResultUtil.getSlefSRList("40000", "账户或密码错误", MyJSON.getJSONObject(map));
			return ERROR;
		}else{
			session.put("account", a);
			map.put("account", a);
			result=ResultUtil.getSlefSRSuccessList(MyJSON.getJSONObject(map));
			return SUCCESS;
		}
	}
	/**
	 *退出
	 * @return
	 * @throws Exception
	 */
	   @SkipValidation
		public String loginout(){
			Map<String,Object>  session = ActionContextUtil.getSession();
			Account a = (Account) session.get("account");
			Map<String,Object> map=new HashMap<String,Object>();
			if(a!=null){
				session.remove("account");
				session.clear();
				result=ResultUtil.getSlefSRSuccessList(MyJSON.getJSONObject(map));
				return SUCCESS;
			}else{
				result=ResultUtil.getSlefSRFailList(MyJSON.getJSONObject(map));
				return ERROR;
			}
			
		}
	/**
	 * 验证码
	 */
	@SkipValidation
	public String valid(){
		Map<String,Object>  session = ActionContextUtil.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		if(session.get("random").equals(validate)) {
			result=ResultUtil.getSlefSRSuccessList(MyJSON.getJSONObject(map));
			return SUCCESS;
		}
		result=ResultUtil.getSlefSRFailList(MyJSON.getJSONObject(map));
		return ERROR;
	}
	/**
	 * 是否登录
	 */
	public String islogin(){
		Map<String,Object>  session = ActionContextUtil.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		if(session.get("account")!=null) {
			map.put("account", accountService.load(((Account)session.get("account")).getAccountId()));
			result=ResultUtil.getSlefSRSuccessList(MyJSON.getJSONObject(map));
			return SUCCESS;
		}
		result=ResultUtil.getSlefSRList("50000", "账户未登录", MyJSON.getJSONObject(map));
		return ERROR;
	}

	/**
	 * 数量
	 */
	public String countAll()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("roleId", account.getRoleId());
		eq.put("accountId", account.getAccountId());
		return super.countAll(eq, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("roleId", account.getRoleId());
		eq.put("accountId", account.getAccountId());
		eq.put("majorId", account.getMajorId());
		eq.put("studentClassId", account.getStudentClassId());
		eq.put("positionalId", account.getPositionalId());
		Map<String,List<Account> > map=new HashMap<>();
		try {
			List<Account> al=accountService.list(pageNum, pageSize, orderName, orderWay, eq, null, null, null, null, null, null, null);
			for (int i = 0; i < al.size(); i++) {
				Account a=al.get(i);
				if(a.getMajorId()!=null&&!a.getMajorId().equals("")){
					Major major=majorService.load(a.getMajorId());
					a.setMajor(major);					
				}
				if(a.getStudentClassId()!=null&&!a.getStudentClassId().equals("")){
					StudentClass studentClass=studentClassService.load(a.getStudentClassId());
					a.setStudentClass(studentClass);					
				}
				if(a.getPositionalId()!=null&&!a.getPositionalId().equals("")){
					Positional positional=positionalService.load(a.getPositionalId());
					a.setPositional(positional);					
				}
			}
			map.put("list", al);
			result=ResultUtil.getSlefSRSuccessList(
					MyJSON.getJSONObject(map));
			return SUCCESS;
		} catch (Exception e) {
			result=ResultUtil.getSlefSRFailList(
					MyJSON.getJSONObject(map));
			return ERROR;
		}
	}
	
	/**
	 * 增加
	 */
	public String add()  {
		Lock lock=new ReentrantLock();
		lock.lock();
		int number = accountService.countAll(null, null, null, null, null, null, null, null);
		account.setIdentifier(DateUtil.getImgDir()+(number+1));
		account.setCreateDate(new Date());
		account.setLoginDate(new Date());
		account.setPassword(MyDESutil.getMD5(account.getPassword()));
		String b = super.add(account);
		lock.unlock();
		return b;
	}
	/**
	* 更新
	*/
	public String update()  {
		Account a = accountService.load(account.getAccountId());
		account.setIdentifier(a.getIdentifier());
		if(!a.getPassword().equals(account.getPassword())){
			account.setPassword(MyDESutil.getMD5(account.getPassword()));			
		}
		return super.update(account);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(account.getAccountId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(account.getAccountId());
	}
	
}