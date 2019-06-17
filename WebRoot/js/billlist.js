var billObj;
var data;
var totalPageCount;
//查询订单
function search(){
	var dataForm = $("form[name=searchForm]").serialize();
	$.ajax({
		type:"GET",
		url:path+"/jsp/bill.do",
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
//订单管理页面上点击删除按钮弹出删除框(billlist.jsp)
function deleteBill(obj){
	$.ajax({
		type:"GET",
		url:path+"/jsp/bill.do",
		data:{method:"delbill",billid:obj.attr("billid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
				$("#dataSize").text($("#dataSize").text()-1);
			}else if(data.delResult == "false"){//删除失败
				//alert("对不起，删除订单【"+obj.attr("billcc")+"】失败");
				changeDLGContent("对不起，删除订单【"+obj.attr("billcc")+"】失败");
			}else if(data.delResult == "notexist"){
				//alert("对不起，订单【"+obj.attr("billcc")+"】不存在");
				changeDLGContent("对不起，订单【"+obj.attr("billcc")+"】不存在");
			}
		},
		error:function(data){
			alert("对不起，删除失败");
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
	var index = (pageIndex-1)*7;
	$(eval(data)).each(function(){
		var isPayment = data[index].isPayment == 1 ?"未付款":"已付款";
		$(".providerTable").append("<tr>"+
				"<td><span>"+ data[index].billCode +"</span></td>"+
				"<td><span>"+ data [index].productName +"</span></td>"+
				"<td><span>"+ data[index].providerName +"</span></td>"+
				"<td><span>"+ data[index].totalPrice +"</span></td>"+
				"<td><span>"+ isPayment +"</span></td>"+
				"<td><span>"+ format(data[index].creationDate) +"</span></td>"+
				"<td>"+
				"<span><a onclick=\"viewBill(this)\" class=\"viewBill\" href=\"javascript:;\" billid="+ data[index].id +" billcc="+ data[index].billCode +"><img src=\"images/read.png\" alt=\"查看\" title=\"查看\"/></a></span>"+
				"<span><a onclick=\"modifyBill(this)\" class=\"modifyBill\" href=\"javascript:;\" billid="+ data[index].id +" billcc="+ data[index].billCode +"><img src=\"images/xiugai.png\" alt=\"修改\" title=\"修改\"/></a></span>"+
				"<span><a onclick=\"delBill(this)\" class=\"deleteBill\" href=\"javascript:void(0);\" billid="+ data[index].id +" billcc="+ data[index].billCode +"><img src=\"images/schu.png\" alt=\"删除\" title=\"删除\"/></a></span>"+
				"</td>"+
			"</tr>");
		index++;
		if(index == (pageIndex*7 )||index>data.length) {
			return false;
		}
	});
}
function showBill(){
	$.ajax({
		type:"GET",
		url:path+"/jsp/bill.do",
		data:{method:"showBill"},
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
showBill();
showProvider();
function showProvider(){//显示供应商名称列表
	$.ajax({
		type:"GET",
		url:path+"/jsp/provider.do",
		data:{method:"showProviderName"},
		dataType:"json",
		success:function(data){
			$(data).each(function(i){
				$("#provider").append("<option value="+ (i+1) +">"+ data[i].proName +"</option>");
			});
		},
		error:function(data){
			alert("对不起，加载数据失败");
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
function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeBi').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeBi').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

	function viewBill(obj){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(obj);
		window.location.href=path+"/billdetail.html?bid="+ obj.attr("billid");
	}

	function modifyBill(obj){
		var obj = $(obj);
		window.location.href=path+"/billmodify.html?bid="+ obj.attr("billid");
	}

	function noDel() {
		cancleBtn();
	}

	function yesDel() {
		deleteBill(billObj);
	}
	function delBill(obj){
		billObj = $(obj);
		changeDLGContent("你确定要删除订单【"+billObj.attr("billcc")+"】吗？");
		openYesOrNoDLG();
	}
	/*$(".deleteBill").on("click",function(){
		var obj = $(this);
		if(confirm("你确定要删除订单【"+obj.attr("billcc")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/bill.do",
				data:{method:"delbill",billid:obj.attr("billid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){//删除成功：移除删除行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){//删除失败
						alert("对不起，删除订单【"+obj.attr("billcc")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，订单【"+obj.attr("billcc")+"】不存在");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
			});
		}
	});*/
