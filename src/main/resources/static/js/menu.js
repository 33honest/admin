$(function () {
    //展开菜单
    $(".spreadSubm").click(function(){
    	var parentId = $(this).attr("data-id");
    	var text = $(this).find("font").text();
    	var el = $(this).parent().parent();
    	if("展开" == text){
    		$(this).find("font").text("折叠");
    		$.ajax({
				type:"POST",
		        url:"/category/getSubMenu",
		        data:{parent_id:parentId,time:new Date().getTime()},
		        dataType:"json",
		        cache:false,
		        success: function(data){
		       	 if("success" == data.status){
					showSubMeunList(data.data,el,parentId)
		       	 }else{
					alert(data.msg);
		       	 }
		        }
			})
    	}else{
    		$(this).find("font").text("展开");
    		$(".submenu"+parentId).remove();
    	}
    });
    
    $("#submitBtn").click(function(){
    	var menuId = $("input[name='menu_id']").val();
    	var actionUrl = $("input[name='actionurl']").val();
    	var parentId = $("#parent_id").val();
    	var menuName = $("input[name='menu_name']").val();
    	var menuUrl = $("input[name='menu_url']").val();
    	var sortNum = $("input[name='sort_num']").val();
    	$.ajax({
    		type:"POST",
    		url:actionUrl,
    		data:{menu_id:menuId,parent_id:parentId,menu_name:menuName,menu_url:menuUrl,sort_num:sortNum},
    		dataType:"json",
    		cache:false,
    		success:function(data){
    			if(data.status == 'success'){
    				window.location.href=window.location.href;
    			}else{
    				alert(data.data);
    			}
    		}
    	});
    	
    });
  })
  
  //添加子菜单
  function addMenu(parentId){
	  reloadMenuModel("添加菜单","",parentId,"","","2","","");
	  reloadActionBtn(_ctx+"/menu/add","添加");
	  $("#menuModal").modal("show");
  }
  
  //删除菜单
  function delMenu(menuId){
	  if(confirm("你确定要删除此菜单吗？")){
		  $.ajax({
			  type:"GET",		  
			  url:"/category/del/"+menuId,
			  data:{time:new Date()},
			  dataType:"json",
			  cache:false,
			  success:function(data){
				  if(data.status == "success"){
						window.location.href=window.location.href;
				  }else{
					  alert(data.data);
				  }
			  }
		  });
	  }
  }
  //编辑菜单
  function editMenu(menuId){
	  window.location.href = "/category/edit?menu_id=" + menuId;
  }
  
  /*
  	添加二级菜单
  */
  function showSubMeunList(data,el,parentId){
	  var subStr="";
	  for(var i=0;i<data.length;i++){
		  var submenu = data[i];
		  var subm = "<tr class='submenu"+parentId+"'>"
			+"<td align='right'><i class='fa fa-angle-double-right'></i></td>"
			+"<td>"+submenu.menu_ID+"</td>"
			+"<td>"+submenu.menu_NAME+"</td>"
			+"<td>"+submenu.menu_URL+"</td>"
			+"<td>"+submenu.menu_ORDER+"</td>"
			+"<td><span class='btn btn-xs btn-info' onclick='editMenu("+submenu.menu_ID+")'><i class='fa fa-edit'></i> 修改</span> <span class='btn btn-xs btn-danger' onclick='delMenu("+submenu.menu_ID+")'><i class='fa fa-trash-o'></i> 删除</span></td>"
			+"</tr>"
		  subStr += subm;
	  }
	  el.after(subStr);
  }
  
  //加载模态框的内容
  function reloadMenuModel(title,menu_id,parent_id,menu_name,menu_url,menu_type,menu_icon,sort_num){
	$("#menuModal #menumodelHead").text(title);
	$("#menuModal input[name='menu_id']").val(menu_id);
	$("#menuModal input[name='parent_id']").val(parent_id);
  	$("#menuModal input[name='menu_name']").val(menu_name);
  	$("#menuModal input[name='menu_url']").val(menu_url);
  	$("#menuModal input[name='menu_order']").val(sort_num);
  }
  function reloadActionBtn(actionUrl,btnText){
	  $("#menuModal input[name='actionurl']").val(actionUrl);
	  $("#submitBtn").text(btnText);
  }