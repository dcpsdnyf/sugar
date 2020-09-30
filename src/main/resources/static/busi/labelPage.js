$(function () {

	//待办
	$('#tb_backlog').bootstrapTable({
		url: WEB_ROOT + "/TUserTaskController/getUndoTask",
		//data: data,                         //直接从本地数据初始化表格
		method: 'get',                      //请求方式（*）
		toolbar: '#toolbar',                //工具按钮用哪个容器
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
		sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1,                      //初始化加载第一页，默认第一页
		pageSize: 10,                       //每页的记录行数（*）
		pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
		search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		strictSearch: true,
		showColumns: true,                  //是否显示所有的列 // 开启自定义列显示功能

		showRefresh: true,                  //是否显示刷新按钮
		minimumCountColumns: 2,             //最少允许的列数
		clickToSelect: true,                //是否启用点击选中行
		uniqueId: "id",                     //每一行的唯一标识，一般为主键列
		showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
		cardView: false,                    //是否显示详细视图
		detailView: false,                   //是否显示父子表
		fixedColumns: true,//是否固定列
		fixedNumber: 4,//固定多少列，总左边开始数


		selectItemName: 'parentItem',

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
		}, {
			align: "center",
			halign: "center",
			field: 'taskType',
			switchable: false,
			title: '任务类型'
		},{
			align: "center",
			halign: "center",
			field: 'taskStatus',
			switchable: false,
			title: '任务状态'
		}, {
			align: "center",
			halign: "center",
			field: 'taskName',
			switchable: false,
			title: '任务名称'
		},{
			align: "center",
			halign: "center",
			field: 'taskSubName',
			switchable: false,
			title: '任务子名称'
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
		}],

	});

	//已办
	$('#tb_finished').bootstrapTable({
		url: WEB_ROOT + "/TUserTaskController/getDoneTask",
		//data: data,                         //直接从本地数据初始化表格
		method: 'get',                      //请求方式（*）
		toolbar: '#toolbar',                //工具按钮用哪个容器
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
		sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1,                      //初始化加载第一页，默认第一页
		pageSize: 10,                       //每页的记录行数（*）
		pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
		search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		strictSearch: true,
		showColumns: true,                  //是否显示所有的列 // 开启自定义列显示功能

		showRefresh: true,                  //是否显示刷新按钮
		minimumCountColumns: 2,             //最少允许的列数
		clickToSelect: true,                //是否启用点击选中行
		uniqueId: "id",                     //每一行的唯一标识，一般为主键列
		showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
		cardView: false,                    //是否显示详细视图
		detailView: false,                   //是否显示父子表
		fixedColumns: true,//是否固定列
		fixedNumber: 4,//固定多少列，总左边开始数


		selectItemName: 'parentItem',

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
		}, {
			align: "center",
			halign: "center",
			field: 'taskType',
			switchable: false,
			title: '任务类型'
		},{
			align: "center",
			halign: "center",
			field: 'taskStatus',
			switchable: false,
			title: '任务状态'
		}, {
			align: "center",
			halign: "center",
			field: 'taskName',
			switchable: false,
			title: '任务名称'
		},{
			align: "center",
			halign: "center",
			field: 'taskSubName',
			switchable: false,
			title: '任务子名称'
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
		}],

	});
});


















