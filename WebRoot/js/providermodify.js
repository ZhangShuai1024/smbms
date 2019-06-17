var proContact = null;
var proPhone = null;
var saveBtn = null;
var backBtn = null;

$(function(){
	proContact = $("#proContact");
	proPhone = $("#proPhone");
	saveBtn = $("#save");
	backBtn = $("#back");
	
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	proContact.next().html("*");
	proPhone.next().html("*");
	
	/*
	 * 验证
	 * 失焦\获焦
	 * jquery的方法传递
	 */
	proContact.on("focus",function(){
		validateTip(proContact.next(),{"color":"#666666"},"* 请输入联系人",false);
	}).on("blur",function(){
		if(proContact.val() != null && proContact.val() != ""){
			validateTip(proContact.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proContact.next(),{"color":"red"},imgNo+" 联系人不能为空，请重新输入",false);
		}
		
	});
	
	proPhone.on("focus",function(){
		validateTip(proPhone.next(),{"color":"#666666"},"* 请输入手机号",false);
	}).on("blur",function(){
		var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(proPhone.val().match(patrn)){
			validateTip(proPhone.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proPhone.next(),{"color":"red"},imgNo + " 您输入的手机号格式不正确",false);
		}
	});
	
	saveBtn.on("click",function(){
		proContact.blur();
		proPhone.blur();
		if(proContact.attr("validateStatus") == "true" && 
				proPhone.attr("validateStatus") == "true"){
			if(confirm("是否确认提交数据")){
				submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		//alert("modify: "+referer);
		if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
	var pid = location.search.substring(5);
	$.ajax({
		type:"GET",//请求类型
		url:path+"/jsp/provider.do",//请求的url
		data:{method:"view",pid:pid},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			$("#proCode").val(data.proCode);
			$("#proName").val(data.proName);
			$("#proAddress").val(data.proAddress);
			$("#proContact").val(data.proContact);
			$("#proPhone").val(data.proPhone);
			$("#proFax").val(data.proFax);
			$("#proDesc").val(data.proDesc);
			$("#pid").val(data.id);
		}
	});
});
function submit(){
	var dataForm = $("form[name=providerForm]").serialize();
	$.ajax({
		type:"GET",
		url:path+"/jsp/provider.do",
		data:"method=modify&"+dataForm,
		dataType:"json",
		success:function(result){
			if(result==1){
				alert("修改成功！");
				location.href="providerList.html";
			}else {
				alert("修改失败！");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，加载数据失败");
		}
	});
}