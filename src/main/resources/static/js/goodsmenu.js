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
		        url:"/goodscategory/getSubMenu",
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
    	var categoryId = $("input[name='category_id']").val();
    	var actionUrl = $("input[name='actionurl']").val();
    	var parentId = $("#parent_id").val();
    	var categoryName = $("input[name='category_name']").val();
    	var simpleDescribe = $("#simple_describe").val();
    	$.ajax({
    		type:"POST",
    		url:actionUrl,
    		data:{category_id:categoryId,parent_id:parentId,category_name:categoryName,simple_describe:simpleDescribe},
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
			  url:"/goodscategory/del/"+menuId,
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
	  window.location.href = "/goodscategory/edit?menu_id=" + menuId;
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
			+"<td>"+submenu.categoryId+"</td>"
			+"<td>"+submenu.categoryName+"</td>"
			+"<td><span class='btn btn-xs btn-info' onclick='editMenu("+submenu.categoryId+")'><i class='fa fa-edit'></i> 修改</span> <span class='btn btn-xs btn-danger' onclick='delMenu("+submenu.categoryId+")'><i class='fa fa-trash-o'></i> 删除</span></td>"
			+"</tr>"
		  subStr += subm;
	  }
	  el.after(subStr);
  }
  
