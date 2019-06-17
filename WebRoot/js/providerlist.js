var providerObj;
var data;
var totalPageCount;
//查询供应商
function search(){
	var dataForm = $("form[name=searchForm]").serialize();
	$.ajax({
		type:"GET",
		url:path+"/jsp/provider.do",
		data:"method=showProvider&"+dataForm,
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
		$(".providerTable").append("<tr>"+
				"<td><span>"+ data[index].proCode +"</span></td>"+
				"<td><span>"+ data[index].proName +"</span></td>"+
				"<td><span>"+ data[index].proContact +"</span></td>"+
				"<td><span>"+ data[index].proPhone +"</span></td>"+
				"<td><span>"+ data[index].proFax +"</span></td>"+
				"<td><span>"+ format(data[index].creationDate) +"</span></td>"+
				"<td>"+
				"<span><a onclick=\"viewPro(this)\" class=\"viewProvider\" href=\"javascript:;\" proid="+ data[index].id +" proname="+ data[index].proName +"><img src=\"images/read.png\" alt=\"查看\" title=\"查看\"/></a></span>"+
				"<span><a onclick=\"modifyPro(this)\" class=\"modifyProvider\" href=\"javascript:;\" proid="+ data[index].id +" proname="+ data[index].proName +"><img src=\"images/xiugai.png\" alt=\"修改\" title=\"修改\"/></a></span>"+
				"<span><a onclick=\"delPro(this)\" class=\"deleteProvider\" href=\"javascript:void(0);\" proid="+ data[index].id +" proname="+ data[index].proName +"><img src=\"images/schu.png\" alt=\"删除\" title=\"删除\"/></a></span>"+
				"</td>"+
			"</tr>");
		index++;
		if(index == (pageIndex*8 )||index>data.length) {
			return false;
		}
	});
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
showProvider();
function showProvider(){
	$.ajax({
		type:"GET",
		url:path+"/jsp/provider.do",
		data:{method:"showProvider"},
		dataType:"json",
		success:function(result){
			data = result;
			$("#dataSize").text(result.length);
			totalPageCount = result.length%8==0?result.length/8:parseInt(result.length/8)+1;
			$("#totalPageCount").text(totalPageCount);
			showByPage(1);
		},
		error:function(data){
			alert("对不起，加载数据失败");
		}
	});
}
//供应商管理页面上点击删除按钮弹出删除框(providerlist.jsp)
function deletePro(obj){
	$.ajax({
		type:"GET",
		url:path+"/jsp/provider.do",
		data:{method:"delprovider",proid:obj.attr("proid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
				$("#dataSize").text($("#dataSize").text()-1);
			}else if(data.delResult == "false"){//删除失败
				//alert("对不起，删除供应商【"+obj.attr("proname")+"】失败");
				changeDLGContent("对不起，删除供应商【"+obj.attr("proname")+"】失败");
			}else if(data.delResult == "notexist"){
				//alert("对不起，供应商【"+obj.attr("proname")+"】不存在");
				changeDLGContent("对不起，供应商【"+obj.attr("proname")+"】不存在");
			}else{
				//alert("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
				changeDLGContent("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
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
	$('#removeProv').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeProv').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}
	function viewPro(obj){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(obj);
		window.location.href=path+"/providerdetail.html?pid="+ obj.attr("proid");
	}

	function modifyPro(obj){
		var obj = $(obj);
		window.location.href=path+"/providermodify.html?pid="+ obj.attr("proid");
	}

	function noDel() {
		cancleBtn();
	}

	function yesDel() {
		deletePro(providerObj);
	}
	function delPro(obj){
		providerObj = $(obj);
		changeDLGContent("你确定要删除供应商【"+providerObj.attr("proname")+"】吗？");
		openYesOrNoDLG();
	}
	
/*	$(".deleteProvider").on("click",function(){
		var obj = $(this);
		if(confirm("你确定要删除供应商【"+obj.attr("proname")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/jsp/provider.do",
				data:{method:"delprovider",proid:obj.attr("proid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){//删除成功：移除删除行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){//删除失败
						alert("对不起，删除供应商【"+obj.attr("proname")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，供应商【"+obj.attr("proname")+"】不存在");
					}else{
						alert("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
			});
		}
	});*/
