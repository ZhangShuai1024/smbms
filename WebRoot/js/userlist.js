	var data;
	var totalPageCount;
	//查询用户
	function search(){
		var dataForm = $("form[name=searchForm]").serialize();
		$.ajax({
			type:"GET",
			url:path+"/jsp/user.do",
			data:"method=search&"+dataForm,
			dataType:"json",
			success:function(result){
				data = result;
				$("#dataSize").text(result.length);
				totalPageCount = result.length%8==0?result.length/8:parseInt(result.length/8)+1;
				$("#totalPageCount").text(totalPageCount);
				showByPage(1);
			},
			error:function(data){
				//alert("对不起，删除失败");
				changeDLGContent("对不起，加载数据失败");
			}
		});
	}
	//显示数据
	function show(){
		$.ajax({
			type:"GET",
			url:path+"/jsp/user.do",
			data:{method:"showUser"},
			dataType:"json",
			success:function(result){
				data = result;
				$("#dataSize").text(result.length);
				totalPageCount = result.length%8==0?result.length/8:parseInt(result.length/8)+1;
				$("#totalPageCount").text(totalPageCount);
				showByPage(1);
			},
			error:function(data){
				//alert("对不起，删除失败");
				changeDLGContent("对不起，加载数据失败");
			}
		});
	}
	//分页显示数据
	function showByPage(pageIndex){
		$(".providerTable tr:not(:first)").remove();
		$("#pageIndex").text(pageIndex);
		if(pageIndex==totalPageCount){
			$(".up").show();
			$(".down").hide();
		}else if(pageIndex==1){
			$(".up").hide();
			$(".down").show();
		}else{
			$(".down").show();
			$(".up").show();
		}
		var index = (pageIndex-1)*8;
		$(eval(data)).each(function(){
			var gender = data[index].gender == 1 ?"男":"女";
			$(".providerTable").append("<tr>"+
					"<td><span>"+ data[index].userCode +"</span></td>"+
					"<td><span>"+ data[index].userName +"</span></td>"+
					"<td><span>"+ gender +"</span></td>"+
					"<td><span>"+ data[index].age +"</span></td>"+
					"<td><span>"+ data[index].phone +"</span></td>"+
					"<td><span>"+ data[index].role.roleName +"</span></td>"+
					"<td>"+
					"<span><a onclick=\"viewUser(this)\" class=\"viewUser\" href=\"javascript:;\" userid="+ data[index].id +" username="+ data[index].userName +"><img src=\"images/read.png\" alt=\"查看\" title=\"查看\"/></a></span>"+
					"<span><a onclick=\"modifyUser(this)\" class=\"modifyUser\" href=\"javascript:;\" userid="+ data[index].id +" username="+ data[index].userName +"><img src=\"images/xiugai.png\" alt=\"修改\" title=\"修改\"/></a></span>"+
					"<span><a onclick=\"delUser(this)\" class=\"deleteUser\" href=\"javascript:void(0);\" userid="+ data[index].id +" username="+ data[index].userName +"><img src=\"images/schu.png\" alt=\"删除\" title=\"删除\"/></a></span>"+
					"</td>"+
				"</tr>");
				index++;
			if(index == (pageIndex*8)||index>data.length) {
				return false;
			}
		});
	}
	//跳页
	function jump_to(pageIndex){
		showByPage(pageIndex);
	}
var userObj;

//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)
function deleteUser(obj){
	$.ajax({
		type:"GET",
		url:path+"/jsp/user.do",
		data:{method:"deluser",uid:obj.attr("userid")},
		dataType:"json",
		success:function(data){
			if(data== 1){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
				$("#dataSize").text($("#dataSize").text()-1);
			}else if(data == 0){//删除失败
				//alert("对不起，删除用户【"+obj.attr("username")+"】失败");
				changeDLGContent("对不起，删除用户【"+obj.attr("username")+"】失败");
			}else if(data == "notexist"){
				//alert("对不起，用户【"+obj.attr("username")+"】不存在");
				changeDLGContent("对不起，用户【"+obj.attr("username")+"】不存在");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}
	show();
	$(".up").hide();
//通过jquery的class选择器（数组）
//对每个class为viewUser的元素进行动作绑定（click）
/**
 * bind、live、delegate
 * on
 */
function viewUser(obj){
	//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
	var obj = $(obj);
	window.location.href=path+"/userdetail.html?uid="+ obj.attr("userid");
}

function modifyUser(obj){
	var obj = $(obj);
	window.location.href=path+"/usermodify.html?uid="+ obj.attr("userid");
}

function noDel() {
	cancleBtn();
}

function yesDel() {
	deleteUser(userObj);
}
function delUser(obj){
	userObj = $(obj);
	changeDLGContent("你确定要删除用户【"+userObj.attr("username")+"】吗？");
	openYesOrNoDLG();
}
