
function backlog() {
	$('#tb_backlog').bootstrapTable({
		url: WEB_ROOT + "/TUserTaskController/getUndoTask",
		//data: data,                         //直接从本地数据初始化表格
		method: 'get',                      //请求方式（*）
		// toolbar: '#toolbar',                //工具按钮用哪个容器
		striped: true,                      //是否显示行间隔色
		cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true,                   //是否显示分页（*）
		sortable: true,                     //是否启用排序
		sortOrder: "asc",                   //排序方式
		queryParams: function (params) {
			var temp = {                    //如果是在服务器端实现分页，limit、offset这两个参数是必须的
				limit: params.limit,       // 每页显示数量
				offset: params.offset,     // SQL语句起始索引
				page: (params.offset / params.limit) + 1, //当前页码
			};
			return temp;
		},                                  //传递参数（*）
		sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1,                      //初始化加载第一页，默认第一页
		pageSize: 10,                       //每页的记录行数（*）
		pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
		search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		//strictSearch: true,
		//showColumns: true,                  //是否显示所有的列 // 开启自定义列显示功能

		// showRefresh: true,                  //是否显示刷新按钮
		// minimumCountColumns: 2,             //最少允许的列数
		// clickToSelect: true,                //是否启用点击选中行
		uniqueId: "id",                     //每一行的唯一标识，一般为主键列
		// showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
		// cardView: false,                    //是否显示详细视图
		// detailView: false,                   //是否显示父子表
		// fixedColumns: true,//是否固定列
		// fixedNumber: 4,//固定多少列，总左边开始数


		//selectItemName: 'parentItem',

		columns: [{
			align: "center",
			halign: "center",
			title: '序号',
			field: 'id',
			switchable: false,
			formatter: function (value, row, index) {
				var html = "<div style='height:20px'>" + (index + 1) + "</div>";
				return html;
			}
		}, {
			align: "center",
			halign: "center",
			field: 'productType',
			switchable: false,
			title: '产品类型'
		}, {
			align: "center",
			halign: "center",
			field: 'platformName',
			switchable: false,
			title: '平台名称'
		}, {
			align: "center",
			halign: "center",
			field: 'groupName',
			switchable: false,
			title: '集团'
		},{
			align: "center",
			halign: "center",
			field: 'principal',
			switchable: false,
			title: '负责人'
		},{
			align: "center",
			halign: "center",
			field: 'taskPrincipal',
			switchable: false,
			title: '任务责任人'
		},{
			align: "center",
			halign: "center",
			field: 'taskStatus',
			switchable: false,
			title: '任务状态',
			formatter: function (value, row, index) {
				if(value=='0'){
					return '待进行';
				}
				if(value=='1'){
					return '进行中';
				}
				if(value=='2'){
					return '已完成';
				}
			}
		}, {
			align: "center",
			halign: "center",
			field: 'taskName',
			switchable: false,
			title: '任务名称',
			formatter: function (value, row, index) {
				if(value=='1'){
					return '商机推进阶段';
				}
				if(value=='2'){
					return '采购阶段';
				}
				if(value=='3'){
					return '产品阶段';
				}if(value=='4'){
					return '研发阶段';
				}
				if(value=='5'){
					return '运营阶段';
				}
				if(value=='6'){
					return '运维阶段';
				}
			}
		},{
			align: "center",
			halign: "center",
			field: 'taskSubName',
			switchable: false,
			title: '任务子名称',
			formatter: function (value, row, index) {
				var taskSubName = getTaskSubName(value);
				return taskSubName;
			}
		},{
			align: "center",
			halign: "center",
			field: 'startTime',
			switchable: false,
			title: '开始时间'
		},{
			align: "center",
			halign: "center",
			field: 'endTime',
			switchable: false,
			title: '完成时间'
		},
			{
				align: "center",
				halign: "center",
				field: 'estimatedTime',
				switchable: false,
				title: '整体预计完成时间'
			},{
			align: "center",
			halign: "center",
			field: 'taskInfo',
			switchable: false,
			title: '任务内容',
			editable: {
				type: 'textarea',
				rows:"3",
				title: '任务内容',
				validate: function (v) {
					if (!v) return '不能为空';

				}
			}
		},
            {
				align: "center",
				halign: "center",
				field: "option",
                title: '操作',
				switchable: false,
                formatter: function (value, row, index) {//这里的三个参数：value表示当前行当前列的值；row表示当前行的数据；index表示当前行的索引（从0开始）。
                    var html = '';
					if(row.delay && row.appoint){
						html = '<div style=\'width:100%;\'>' +
							'<button type="button" onclick="updateUserTask(' + row.id + ')" class="btn btn-primary"  style="font-weight:150;font-size:12px;padding:3px 3px"><span class="glyphicon glyphicon-pencil" aria- hidden="true" ></span >确认完成</button >&nbsp;&nbsp;'+
							'<button type="button" onclick="delayModel(' + row.projectId + ')" class="btn btn-danger"  style="font-weight:150;font-size:12px;padding:3px 8px;margin-left: 10px"><span class="glyphicon glyphicon-remove" aria- hidden="true" ></span >申请延期</button >'+
							'<button type="button" onclick="examine (' + row.projectId +','+row.taskName+ ')" class="btn btn-primary"  style="font-weight:150;font-size:12px;padding:3px 8px;margin-left: 5px"><span class="glyphicon glyphicon-pencil" aria- hidden="true" ></span >延期审核</button >'+
							'</div>';
					} else if(row.delay){
						html = '<div style=\'width:100%;\'>' +
		                '<button type="button" onclick="updateUserTask(' + row.id + ')" class="btn btn-primary"  style="font-weight:150;font-size:12px;padding:3px 3px"><span class="glyphicon glyphicon-pencil" aria- hidden="true" ></span >确认完成</button >&nbsp;&nbsp;'+
		                '<button type="button" onclick="delayModel(' + row.projectId + ')" class="btn btn-danger"  style="font-weight:150;font-size:12px;padding:3px 8px;margin-left: 10px"><span class="glyphicon glyphicon-remove" aria- hidden="true" ></span >申请延期</button >'+
		                '</div>';
	                }else if (row.appoint) {
		                html = '<div style=\'width:100%;\'>' +
			                '<button type="button" onclick="examine (' + row.projectId +','+row.taskName+ ')" class="btn btn-primary"  style="font-weight:150;font-size:12px;padding:3px 8px;margin-left: 5px"><span class="glyphicon glyphicon-pencil" aria- hidden="true" ></span >延期审核</button >'+
			                '</div>';
	                }
                    return html;
                }
            }],
		onEditableSave: function (field, row, oldValue, $el) {
			// alert("更新保存事件，原始值为" + oldValue);
			$.ajax({
				type: "POST",
				url: WEB_ROOT + "/TUserTaskController/updateUserTaskToProgressing",
				data: row,
				dataType: 'JSON',
				success: function (result) {
                    window.location.reload();
				},
				error: function () {
					msgInfoModal('提示', "编辑失败");
				}

			});
		}

	});
}
function finished() {
	$('#tb_finished').bootstrapTable({
		url: WEB_ROOT + "/TUserTaskController/getDoneTask",
		//data: data,                         //直接从本地数据初始化表格
		method: 'get',                      //请求方式（*）
		// toolbar: '#toolbar',                //工具按钮用哪个容器
		striped: true,                      //是否显示行间隔色
		cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true,                   //是否显示分页（*）
		sortable: true,                     //是否启用排序
		sortOrder: "asc",                   //排序方式
		queryParams: function (params) {
			var temp = {                    //如果是在服务器端实现分页，limit、offset这两个参数是必须的
				limit: params.limit,       // 每页显示数量
				offset: params.offset,     // SQL语句起始索引
				page: (params.offset / params.limit) + 1, //当前页码
			};
			return temp;
		},                                  //传递参数（*）
		sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1,                      //初始化加载第一页，默认第一页
		pageSize: 10,                       //每页的记录行数（*）
		pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
		search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		// strictSearch: true,
		// showColumns: true,                  //是否显示所有的列 // 开启自定义列显示功能
		//
		// showRefresh: true,                  //是否显示刷新按钮
		// minimumCountColumns: 2,             //最少允许的列数
		// clickToSelect: true,                //是否启用点击选中行
		uniqueId: "id",                     //每一行的唯一标识，一般为主键列
		// showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
		// cardView: false,                    //是否显示详细视图
		// detailView: false,                   //是否显示父子表
		// fixedColumns: true,//是否固定列
		// fixedNumber: 4,//固定多少列，总左边开始数
		//
		//
		// selectItemName: 'parentItem',

		columns: [{
			align: "center",
			halign: "center",
			title: '序号',
			field: 'id',
			switchable: false,
			formatter: function (value, row, index) {
				var html = "<div style='height:20px'>" + (index + 1) + "</div>";
				return html;
			}
		}, {
			align: "center",
			halign: "center",
			field: 'productType',
			switchable: false,
			title: '产品类型'
		}, {
			align: "center",
			halign: "center",
			field: 'platformName',
			switchable: false,
			title: '平台名称'
		}, {
			align: "center",
			halign: "center",
			field: 'groupName',
			switchable: false,
			title: '集团'
		},{
			align: "center",
			halign: "center",
			field: 'principal',
			switchable: false,
			title: '负责人'
		},{
			align: "center",
			halign: "center",
			field: 'taskPrincipal',
			switchable: false,
			title: '任务责任人'
		},{
			align: "center",
			halign: "center",
			field: 'taskStatus',
			switchable: false,
			title: '任务状态',
			formatter: function (value, row, index) {
				if(value=='0'){
					return '待进行';
				}
				if(value=='1'){
					return '进行中';
				}
				if(value=='2'){
					return '已完成';
				}
			}
		}, {
			align: "center",
			halign: "center",
			field: 'taskName',
			switchable: false,
			title: '任务名称',
			formatter: function (value, row, index) {
				if(value=='1'){
					return '商机推进阶段';
				}
				if(value=='2'){
					return '采购阶段';
				}
				if(value=='3'){
					return '产品阶段';
				}if(value=='4'){
					return '研发阶段';
				}
				if(value=='5'){
					return '运营阶段';
				}
				if(value=='6'){
					return '运维阶段';
				}
			}
		},{
			align: "center",
			halign: "center",
			field: 'taskSubName',
			switchable: false,
			title: '任务子名称',
			formatter: function (value, row, index) {
				var taskSubName = getTaskSubName(value);
				return taskSubName;
			}

		},{
			align: "center",
			halign: "center",
			field: 'startTime',
			switchable: false,
			title: '开始时间'
		},{
			align: "center",
			halign: "center",
			field: 'endTime',
			switchable: false,
			title: '完成时间'
		},{
			align: "center",
			halign: "center",
			field: 'estimatedTime',
			switchable: false,
			title: '整体预计完成时间'
		},{
			align: "center",
			halign: "center",
			field: 'taskInfo',
			title: '任务内容'
		}],

	});
}

function getTaskSubName(value) {
	var taskSubName = "";
	switch (value) {
		case "100": taskSubName = "商机线索开启";
			break;
		case "101": taskSubName = "1、商机线索0%";
			break;
		case "102": taskSubName = "2、商机发现10%";
			break;
		case "103": taskSubName = "3、商机确立25%";
			break;
		case "104": taskSubName = "4、商机确立50%";
			break;
		case "105": taskSubName = "5、商机确认75%";
			break;
		case "106": taskSubName = "6、商机赢取100%";
			break;
		case "107": taskSubName = "7、客户维护/回款阶段";
			break;
		case "108": taskSubName = "商机关闭";
			break;
		case "201": taskSubName = "1、初步意向方案";
			break;
		case "202": taskSubName = "2、写立项方案";
			break;
		case "203": taskSubName = "3、工时评估";
			break;
		case "204": taskSubName = "4、商务谈判";
			break;
		case "205": taskSubName = "5、请示拟写";
			break;
		case "206": taskSubName = "6、上会";
			break;
		case "207": taskSubName = "7、招投标";
			break;
		case "208": taskSubName = "8、请示OA审批";
			break;
		case "209": taskSubName = "9、合同拟写";
			break;
		case "210": taskSubName = "10、律师审核";
			break;
		case "211": taskSubName = "11、合同OA审批";
			break;
		case "212": taskSubName = "12、用章";
			break;
		case "213": taskSubName = "13、对方盖章";
			break;
		case "214": taskSubName = "14、扫描";
			break;
		case "215": taskSubName = "15、综合部归档";
			break;
		case "216": taskSubName = "16、首付款";
			break;
		case "217": taskSubName = "17、进度款";
			break;
		case "218": taskSubName = "18、尾款";
			break;
		case "301": taskSubName = "1、设计概要";
			break;
		case "302": taskSubName = "2、详细设计";
			break;
		case "303": taskSubName = "3、UI设计";
			break;
		case "304": taskSubName = "4、需求设计";
			break;
		case "305": taskSubName = "5、需求评审";
			break;
		case "306": taskSubName = "6、需求单确认";
			break;
		case "307": taskSubName = "7、验收";
			break;
		case "401": taskSubName = "1、技术选型";
			break;
		case "402": taskSubName = "2、环境部署";
			break;
		case "403": taskSubName = "3、框架设计";
			break;
		case "404": taskSubName = "4、开发进度10%";
			break;
		case "405": taskSubName = "5、开发进度25%";
			break;
		case "406": taskSubName = "6、开发进度50%";
			break;
		case "407": taskSubName = "7、开发进度75%";
			break;
		case "408": taskSubName = "8、开发进度100%";
			break;
		case "409": taskSubName = "9、内部测试优化";
			break;
		case "410": taskSubName = "10、客户测试优化";
			break;
		case "411": taskSubName = "11、实施交付";
			break;
		case "412": taskSubName = "12、验收";
			break;

	}
	return taskSubName;
}

function updateUserTask(id) {
    var row = $("#tb_backlog").bootstrapTable('getRowByUniqueId', id);
    if(row.taskInfo==null || row.taskInfo==''){
		msgInfoModal('提示', "任务内容为空，请填写");
		return
	}

    $.ajax({
        type: "POST",
        url: WEB_ROOT + "/TUserTaskController/updateUserTask",
        data: row,
        dataType: 'JSON',
        success: function (result) {
            confirmModal("提示", "保存成功！", function () {
                window.location.reload();
            }, {}, function () {
                window.location.reload();
            });
        },
        error: function () {
            msgInfoModal('提示', "编辑失败");
        }

    });
}














