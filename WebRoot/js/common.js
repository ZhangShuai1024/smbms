var path = $("#path").val();
var imgYes = "<img width='15px' src='"+path+"/images/y.png' />";
var imgNo = "<img width='15px' src='"+path+"/images/n.png' />";
/**
 * 提示信息显示
 * element:显示提示信息的元素（font）
 * css：提示样式
 * tipString:提示信息
 * status：true/false --验证是否通过
 */
function validateTip(element,css,tipString,status){
	element.css(css);
	element.html(tipString);
	
	element.prev().attr("validateStatus",status);
}
var referer = $("#referer").val();
$(".userName").text(getCookie("userName"));
function getCookie (name) {
  if (document.cookie.length > 0) {
    var begin = document.cookie.indexOf(name + '=');
    if (begin !== -1) {
      begin += name.length + 1; // cookie值的初始位置
      var end = document.cookie.indexOf(';', begin); // 结束位置
      if (end === -1) {
        end = document.cookie.length; // 没有;则end为字符串结束位置
      }
      return decodeURI(document.cookie.substring(begin, end));
    }
  }
  return null;
  // cookie不存在返回null
}

function add0(m){return m<10?'0'+m:m; }
function format(shijianchuo){
	//shijianchuo是整数，否则要parseInt转换
	var time = new Date(shijianchuo);
	var y = time.getFullYear();
	var m = time.getMonth()+1;
	var d = time.getDate();
	return y+'-'+add0(m)+'-'+add0(d);
}
$("a[href='jsp/pwdmodify.jsp']").attr('href','pwdmodify.html');
$("a[href='jsp/bill.do?method=query']").attr('href','billList.html');
$("a[href='jsp/provider.do?method=query']").attr('href','providerList.html');
$("a[href='jsp/user.do?method=query']").attr('href','userList.html');
$(".providerTable").attr({"cellpadding":"0","cellspacing":"0"});
$("a[href='jsp/logout.do']").attr('href','javascript:;').bind("click",function(){
	location.href="Login.html";
});