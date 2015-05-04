jQuery.adminCookBook = {
		dataTable:null,
		toSave:false,
		initSearchDataTable : function() {
			if (this.dataTable == null) {
				this.dataTable = $('#dt_table_view').dataTable({
					"sDom" : "<'row-fluid'<'span6'l>r>t<'row-fluid'<'span6'i><'span6'p>>",
					"sPaginationType" : "bootstrap",
					"oLanguage" : {
						"sLengthMenu" : "每页显示 _MENU_ 条记录",
						"sZeroRecords" : "抱歉， 暂时没有记录",
						"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
						"sSearch" : "",
						"sInfoEmpty" : "没有数据",
						"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
						"oPaginate" : {
							"sFirst" : "首页",
							"sPrevious" : "前一页",
							"sNext" : "后一页",
							"sLast" : "尾页"
						}
					},
					"bAutoWidth" : false,
					"iDisplayLength" : 10,
					"aLengthMenu" : [ 5, 10, 25, 50],
					"bServerSide" : true,
					"sServerMethod" : "POST",
					"bProcessing" : true,
					"bSort" : false,
					"sAjaxSource" : $.ace.getContextPath() + "/admin/cookbook/list",
					"fnDrawCallback" : function(oSettings) {
						$('[rel="popover"],[data-rel="popover"]').popover();
					},
					"fnServerData" : function(sSource, aoData, fnCallback) {
						var name = $("#name").val();
						if (!!name) {
							aoData.push({
								"name" : "name",
								"value" : name
							});
						}
						$.ajax({
							"dataType" : 'json',
							"type" : "POST",
							"url" : sSource,
							"data" : aoData,
							"success" : function(data){
								fnCallback(data.resultMap);
							}
						});
					},
					"aoColumns" : [ {
						"mDataProp" : "id"
					}, {
						"mDataProp" : "name"
					}, {
						"mDataProp" : "category.name"
					}, {
						"mDataProp" : "categorySub.name"
					}, {
						"mDataProp" : "remark"
					}, {
						"mDataProp" : "count"
					}, {
						"mDataProp" : "score"
					}, {
						"mDataProp" : "user.name"
					}, {
						"mDataProp" : "createDate"
					}
					, {
						"mDataProp" : ""
					}],
					"aoColumnDefs" : [
						{
							'aTargets' : [4],
							'fnRender' : function(oObj, sVal) {
								if(sVal.length>10)
									return sVal.substring(0,10)+".....";
								else 
									return sVal;
							}
						},
						{
							'aTargets' : [9],
							'fnRender' : function(oObj, sVal) {
								return "<button class=\"btn2 btn-info\" onclick=\"$.adminResource.showEdit("+oObj.aData.id+")\"><i class=\"icon-pencil\"></i>修改</button>"+
								 "  &nbsp;<button class=\"btn2 btn-info\" onclick=\"$.adminResource.deleteResource("+oObj.aData.id+")\"><i class=\"icon-trash\"></i> 删除</button>";
							}
						},
					 {
						'aTargets' : [ '_all' ],
						'bSortable' : false,
						'sClass' : 'center'
					}]

				});
			} else {
				var oSettings = this.dataTable.fnSettings();
				oSettings._iDisplayStart = 0;
				this.dataTable.fnDraw(oSettings);
			}

		},
		deleteResource :function(id){
			bootbox.confirm( "是否确认删除？", function (result) {
	            if(result){
	            	$.ajax({
	        			type : "get",
	        			url : $.ace.getContextPath() + "/admin/cookbook/delete?id="+id,
	        			dataType : "json",
	        			success : function(json) {
	        				if(json.resultMap.state=='success'){
	        					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"success","timeout":"2000"});
	        					$.adminCookBook.initSearchDataTable();
	        				}else{
	        					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"warning"});
	        				}
	        			}
	        		});
	            }
	        });
		},
		update : function (){
				$.ajax({
	    			type : "post",
	    			url : $.ace.getContextPath() + "/admin/cookbook/update",
	    			data:{
	    				"resource.id":$("#resourceId").val(),
	    				"resource.name":$("#resourceName").val(),
	    				"resource.remark":$("#resourceRemark").val(),
	    				"resource.category.id":$("#resourceCategoryId").val()
	    			},
	    			dataType : "json",
	    			success : function(json) {
	    				if(json.resultMap.state=='success'){
	    					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"success","timeout":"2000"});
	    					$.adminCookBook.initSearchDataTable();
	    					$("#resource_modal").modal('hide');
	    				}else{
	    					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"warning"});
	    				}
	    			}
	    		});
		},
		showEdit: function (id){
			$("#resourceId").val(id);
			$.ajax({
    			type : "get",
    			url : $.ace.getContextPath() + "/admin/cookbook/get?id="+id,
    			dataType : "json",
    			success : function(json) {
    				if(json.resultMap.state=='success'){
    					$("#resource_modal").modal('show');
    					$("#resourceCategoryId").val(json.resultMap.resource.category.id);
    					$("#resourceName").val(json.resultMap.resource.name);
    					$("#resourceRemark").val(json.resultMap.resource.remark);
    				}else{
    					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"warning"});
    				}
    			}
    		});
		}
};