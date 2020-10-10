$(function () {

	//表格的初始化
	$('#tb_user').bootstrapTable({
		url: WEB_ROOT + "/sugarManage/getSugarProjectList",
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
				productType: $("#productType").val(),
				platformName: $("#platformName").val(),
				groupName: $("#groupName").val(),
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
		fixedNumber: 5,//固定多少列，总左边开始数


		selectItemName: 'parentItem',

		columns: [[
			{
				"title": "项目信息",
				"halign": "center",
				"align": "center",
				"colspan": 5
			},
			{
				"title": "商机推进阶段",
				"halign": "center",
				"align": "center",
				"colspan": 9,
				visible: false,
				id: 'business',
				class: "th_red",
			},
			{
				"title": "采购阶段",
				"halign": "center",
				"align": "center",
				"colspan": 18,
				class: "th_orange"
			},
			{
				"title": "产品阶段",
				"halign": "center",
				"align": "center",
				"colspan": 7,
				class: "th_yellow"
			},
			{
				"title": "研发阶段",
				"halign": "center",
				"align": "center",
				"colspan": 12,
				class: "th_darkblue"
			},
			{
				field: 'operationPhase',
				title: '运营阶段',
				"colspan": 1,
				rowspan: 1,
				class: "th_purple"
			}, {
				field: 'maintainPhase',
				title: '运维阶段',
				"colspan": 1,
				rowspan: 1,
				class: "th_darkred",
			}, {
				halign: "center",
				title: '操作',
				"colspan": 1,
				rowspan: 2,
				formatter: function (value, row, index) {//这里的三个参数：value表示当前行当前列的值；row表示当前行的数据；index表示当前行的索引（从0开始）。
					var html = '';
					if (!row.rowEdit) {
						return '';
					}
					if (row.appoint) {
						html = '<div style=\'width:150px;\'><button type="button" onclick="editModel(' + row.id + ')" class="btn btn-primary"  style="font-weight:150;font-size:12px;padding:3px 8px"><span class="glyphicon glyphicon-pencil" aria- hidden="true" ></span >编辑</button >&nbsp;&nbsp;' +
							'<button type="button" onclick="deleteModel(' + row.id + ')" class="btn btn-danger"  style="font-weight:150;font-size:12px;padding:3px 8px"><span class="glyphicon glyphicon-remove" aria- hidden="true" ></span >删除</button >&nbsp;&nbsp;' +
							'<button type="button" onclick="appointModel(' + row.id + ')" class="btn btn-primary"  style="font-weight:150;font-size:12px;padding:3px 8px;margin-top: 10px"><span class="glyphicon glyphicon-pencil" aria- hidden="true" ></span >指派</button >;'+
							'<button type="button" onclick="examine(' + row.id + ')" class="btn btn-primary"  style="font-weight:150;font-size:12px;padding:3px 8px;margin-top: 10px"><span class="glyphicon glyphicon-pencil" aria- hidden="true" ></span >审核延期</button >';
						html += "</div>";
					} else {
						html = '<div style=\'width:150px;\'><button type="button" onclick="editModel(' + row.id + ')" class="btn btn-primary"  style="font-weight:150;font-size:12px;padding:3px 8px"><span class="glyphicon glyphicon-pencil" aria- hidden="true" ></span >编辑</button >&nbsp;&nbsp;' +
							'<button type="button" onclick="deleteModel(' + row.id + ')" class="btn btn-danger"  style="font-weight:150;font-size:12px;padding:3px 8px"><span class="glyphicon glyphicon-remove" aria- hidden="true" ></span >删除</button >';
						html += "</div>";
					}

					return html;
				}
			}
		], [{
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
			field: 'platformName',
			switchable: false,
			title: '平台名称'
		}, {
			field: 'groupName',
			switchable: false,
			title: '集团'
		}, {
			field: 'taskPrincipal',
			switchable: false,
			title: '负责人'
		},
			{
				field: 'businessClueOpen',
				title: '商机线索开启',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '商机线索开启',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'businessClue0',
				title: '1、商机线索0%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '1、商机线索0%',
					validate: function (v) {
						if (!v) return '不能为空';

					},
				}

			}, {
				field: 'businessDiscover10',
				title: '2、商机发现10%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '2、商机发现10%',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'businessEstablish25',
				title: '3、商机确立25%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '3、商机确立25%',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'businessEstablish50',
				title: '4、商机确立50%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '4、商机确立50%',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'businessEstablish75',
				title: '5、商机确认75%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '5、商机确认75%',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'businessWin100',
				title: '6、商机赢取100%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '6、商机赢取100%',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'customerMaintainBackMoney',
				title: '7、客户维护/回款阶段',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '7、客户维护/回款阶段',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'businessClose',
				title: '商机关闭',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '商机关闭',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'initialIntentionPlan',
				title: '1、初步意向方案',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '1、初步意向方案',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'writeProjectProposal',
				title: '2、写立项方案',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '2、写立项方案',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'workingHoursAssess',
				title: '3、工时评估',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '3、工时评估',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'businessNegotiation',
				title: '4、商务谈判',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '4、商务谈判',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'requestDraft',
				title: '5、请示拟写',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '5、请示拟写',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'attendMeeting',
				title: '6、上会',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '6、上会',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'bidding',
				title: '7、招投标',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '7、招投标',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'requestOaApproval',
				title: '8、请示OA审批',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '8、请示OA审批',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'contractDraft',
				title: '9、合同拟写',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '9、合同拟写',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'lawyerReview',
				title: '10、律师审核',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '10、律师审核',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'contractOaApproval',
				title: '11、合同OA审批',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '11、合同OA审批',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'usageSeal',
				title: '12、用章',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '12、用章',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'otherSeal',
				title: '13、对方盖章',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '13、对方盖章',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'scan',
				title: '14、扫描',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '14、扫描',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'generalDepartmentFile',
				title: '15、综合部归档',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '15、综合部归档',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'firstPayment',
				title: '16、首付款',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '16、首付款',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'progressPayment',
				title: '17、进度款',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '17、进度款',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'finalPayment',
				title: '18、尾款',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '18、尾款',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'designBrief',
				title: '1、设计概要',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '1、设计概要',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'detailedDesign',
				title: '2、详细设计',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '2、详细设计',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'uiDesign',
				title: '3、UI设计',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '3、UI设计',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'requirementDesign',
				title: '4、需求设计',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '4、需求设计',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'requirementsReview',
				title: '5、需求评审',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '5、需求评审',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'demandOrderConfirm',
				title: '6、需求单确认',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '6、需求单确认',
					validate: function (v) {
						if (!v) return '用户名不能为空';

					}
				}

			}, {
				field: 'proCheckDeliver',
				title: '7、验收',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '7、验收',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}

			}, {
				field: 'technologySelection',
				title: '1、技术选型',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '1、技术选型',
					validate: function (v) {
						if (!v) return '不能为空';
					}
				}
			}, {
				field: 'environmentDeployment',
				title: '2、环境部署',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '2、环境部署',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'frameworkDesign',
				title: '3、框架设计',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '3、框架设计',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'developProgress10',
				title: '4、开发进度10%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '4、开发进度10%',
					validate: function (v) {
						if (!v) {
							return '不能为空';
						}
					}
				}
			}, {
				field: 'developProgress25',
				title: '5、开发进度25%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '5、开发进度25%',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'developProgress50',
				title: '6、开发进度50%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '6、开发进度50%',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'developProgress75',
				title: '7、开发进度75%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '7、开发进度75%',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'developProgress100',
				title: '8、开发进度100%',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '8、开发进度100%',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'insideTest',
				title: '9、内部测试优化',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '9、内部测试优化',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'customerTest',
				title: '10、客户测试优化',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '10、客户测试优化',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'implementDeliver',
				title: '11、实施交付',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '11、实施交付',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'checkDeliver',
				title: '12、验收',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '12、验收',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			},
			{
				field: 'operationPhase',
				title: '运营阶段',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '运营阶段',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}, {
				field: 'maintainPhase',
				title: '运维阶段',
				editable: {
					type: 'textarea',
					rows: "3",
					title: '运维阶段',
					validate: function (v) {
						if (!v) return '不能为空';

					}
				}
			}]],
		onEditableSave: function (field, row, oldValue, $el) {
			// alert("更新保存事件，原始值为" + oldValue);
			debugger
			row.fieldName = field;
			//添加编辑人修改处理
			var userName = row[field];
			if (userName.indexOf(":") == -1) {
				row[field] = $("#getUserName").val() + ":" + "\n" + userName;
			} else {
				var splitValue = userName.substring(userName.indexOf(":") + 1, userName.length);
				row[field] = $("#getUserName").val() + ":" + "\n" + splitValue;
			}
			$.ajax({
				type: "post",
				url: WEB_ROOT + "/sugarManage/Edit",
				data: row,
				dataType: 'JSON',
				success: function (status) {
					confirmModal("提示", "保存成功！", function () {

						window.location.reload();
					}, {}, function () {
						window.location.reload();
					});
				},
				error: function () {
					msgInfoModal('提示', "编辑失败");
				},
				complete: function () {

				}

			});
		},
		onLoadSuccess: function (data) {
			//var data = $('#tb_user').bootstrapTable('getData', true);
			var rows = data.rows;
			for (var k = 0; k < rows.length; k++) {
				var id = rows[k].id;    //项目id
				var productType = rows[k].productType;  //产品类型
				var platformName = rows[k].platformName;    //平台名称
				//======================商机推进阶段======================
				var businessClueOpen = rows[k].businessClueOpen == null ? '' : rows[k].businessClueOpen; //商机线索
				var businessClose = rows[k].businessClose == null ? '' : rows[k].businessClose;  //商机关闭
				var businessClue0 = rows[k].businessClue0 == null ? '' : rows[k].businessClue0;  //1、商机线索0%：我方分析客户存在潜在需求
				var businessDiscover10 = rows[k].businessDiscover10 == null ? '' : rows[k].businessDiscover10; //2、商机发现10%：深入交流明确需求
				var businessEstablish25 = rows[k].businessEstablish25 == null ? '' : rows[k].businessEstablish25;//3、商机确立25%：客户明确购买意愿/立项/预算
				var businessEstablish50 = rows[k].businessEstablish50 == null ? '' : rows[k].businessEstablish50;//4、商机确立50%：客户启动招标/采购流程、我方入围
				var businessEstablish75 = rows[k].businessEstablish75 == null ? '' : rows[k].businessEstablish75;//5、商机确认75%：客户招标/采购，我方交流需求细则
				var businessWin100 = rows[k].businessWin100 == null ? '' : rows[k].businessWin100;          // 6、商机赢取100%：合同签订
				var customerMaintainBackMoney = rows[k].customerMaintainBackMoney == null ? '' : rows[k].customerMaintainBackMoney;// 7、客户维护/回款阶段
				//======================采购阶段======================
				var initialIntentionPlan = rows[k].initialIntentionPlan == null ? '' : rows[k].initialIntentionPlan;     //1、初步意向方案（采购阶段）
				var writeProjectProposal = rows[k].writeProjectProposal == null ? '' : rows[k].writeProjectProposal;     // 2、写立项方案
				var workingHoursAssess = rows[k].workingHoursAssess == null ? '' : rows[k].workingHoursAssess;         // 3、工时评估
				var businessNegotiation = rows[k].businessNegotiation == null ? '' : rows[k].businessNegotiation;       // 4、商务谈判
				var requestDraft = rows[k].requestDraft == null ? '' : rows[k].requestDraft;                     // 5、请示拟写
				var attendMeeting = rows[k].attendMeeting == null ? '' : rows[k].attendMeeting;                   // 6、上会
				var bidding = rows[k].bidding == null ? '' : rows[k].bidding;                               // 7、招投标
				var requestOaApproval = rows[k].requestOaApproval == null ? '' : rows[k].requestOaApproval;           // 8、请示OA审批
				var contractDraft = rows[k].contractDraft == null ? '' : rows[k].contractDraft;                   // 9、合同拟写
				var lawyerReview = rows[k].lawyerReview == null ? '' : rows[k].lawyerReview;                     // 10、律师审核
				var contractOaApproval = rows[k].contractOaApproval == null ? '' : rows[k].contractOaApproval;         // 11、合同OA审批
				var usageSeal = rows[k].usageSeal == null ? '' : rows[k].usageSeal;                           // 12、用章
				var otherSeal = rows[k].otherSeal == null ? '' : rows[k].otherSeal;                           // 13、对方盖章
				var scan = rows[k].scan == null ? '' : rows[k].scan;                                     // 14、扫描
				var generalDepartmentFile = rows[k].generalDepartmentFile == null ? '' : rows[k].generalDepartmentFile;   // 15、综合部归档
				var firstPayment = rows[k].firstPayment == null ? '' : rows[k].firstPayment;                     // 16、首付款
				var progressPayment = rows[k].progressPayment == null ? '' : rows[k].progressPayment;               // 17、进度款
				var finalPayment = rows[k].finalPayment == null ? '' : rows[k].finalPayment;                     // 18、尾款
				//======================产品阶段======================
				var designBrief = rows[k].designBrief == null ? '' : rows[k].designBrief;                       // 1、设计概要
				var detailedDesign = rows[k].detailedDesign == null ? '' : rows[k].detailedDesign;                 // 2、详细设计
				var uiDesign = rows[k].uiDesign == null ? '' : rows[k].uiDesign;                             // 3、UI设计
				var requirementDesign = rows[k].requirementDesign == null ? '' : rows[k].requirementDesign;           // 4、需求设计
				var requirementsReview = rows[k].requirementsReview == null ? '' : rows[k].requirementsReview;         // 5、需求评审
				var demandOrderConfirm = rows[k].demandOrderConfirm == null ? '' : rows[k].demandOrderConfirm;         // 6、需求单确认
				var proCheckDeliver = rows[k].proCheckDeliver == null ? '' : rows[k].proCheckDeliver;               // 7、验收

				//======================研发阶段======================
				var technologySelection = rows[k].technologySelection == null ? '' : rows[k].technologySelection;      //1、技术选型
				var environmentDeployment = rows[k].environmentDeployment == null ? '' : rows[k].environmentDeployment;  //2、环境部署
				var frameworkDesign = rows[k].frameworkDesign == null ? '' : rows[k].frameworkDesign;              //  3、框架设计
				var developProgress10 = rows[k].developProgress10 == null ? '' : rows[k].developProgress10;          //4、开发进度10%
				var developProgress25 = rows[k].developProgress25 == null ? '' : rows[k].developProgress25;          //5、开发进度25%
				var developProgress50 = rows[k].developProgress50 == null ? '' : rows[k].developProgress50;          //6、开发进度50%
				var developProgress75 = rows[k].developProgress75 == null ? '' : rows[k].developProgress75;          //7、开发进度75%
				var developProgress100 = rows[k].developProgress100 == null ? '' : rows[k].developProgress100;        //8、开发进度100%
				var insideTest = rows[k].insideTest == null ? '' : rows[k].insideTest;                        //9、内部测试优化
				var customerTest = rows[k].customerTest == null ? '' : rows[k].customerTest;                    //10、客户测试优化
				var implementDeliver = rows[k].implementDeliver == null ? '' : rows[k].implementDeliver;            //11、实施交付
				var checkDeliver = rows[k].checkDeliver == null ? '' : rows[k].checkDeliver;                    //12、验收

				//======================运营阶段======================
				var operationPhase = rows[k].operationPhase == null ? '' : rows[k].operationPhase;

				//======================运营阶段======================
				var maintainPhase = rows[k].maintainPhase == null ? '' : rows[k].maintainPhase;
				if (!rows[k].rowEdit) {
					var productTypeObj = $('#tb_user tr[data-index=' + k + '] a[data-name="productType"]').parent();
					$(productTypeObj).empty();
					$(productTypeObj).text(productType);

					var platformNameObj = $('#tb_user tr[data-index=' + k + '] a[data-name="platformName"]').parent();
					$(platformNameObj).empty();
					$(platformNameObj).text(platformName);

					//==================商机推进阶段==================
					var obj1 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessClueOpen"]').parent();
					$(obj1).empty();
					$(obj1).text(businessClueOpen);

					var obj2 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessClose"]').parent();
					$(obj2).empty();
					$(obj2).text(businessClose);

					var obj3 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessClue0"]').parent();
					$(obj3).empty();
					$(obj3).text(businessClue0);

					var obj4 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessDiscover10"]').parent();
					$(obj4).empty();
					$(obj4).text(businessDiscover10);

					var obj5 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessEstablish25"]').parent();
					$(obj5).empty();
					$(obj5).text(businessEstablish25);

					var obj6 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessEstablish50"]').parent();
					$(obj6).empty();
					$(obj6).text(businessEstablish50);

					var obj7 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessEstablish75"]').parent();
					$(obj7).empty();
					$(obj7).text(businessEstablish75);

					var obj8 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessWin100"]').parent();
					$(obj8).empty();
					$(obj8).text(businessWin100);

					var obj9 = $('#tb_user tr[data-index=' + k + '] a[data-name="customerMaintainBackMoney"]').parent();
					$(obj9).empty();
					$(obj9).text(customerMaintainBackMoney);

					//==================采购阶段==================
					var obj10 = $('#tb_user tr[data-index=' + k + '] a[data-name="initialIntentionPlan"]').parent();
					$(obj10).empty();
					$(obj10).text(initialIntentionPlan);

					var obj11 = $('#tb_user tr[data-index=' + k + '] a[data-name="writeProjectProposal"]').parent();
					$(obj11).empty();
					$(obj11).text(writeProjectProposal);

					var obj12 = $('#tb_user tr[data-index=' + k + '] a[data-name="workingHoursAssess"]').parent();
					$(obj12).empty();
					$(obj12).text(workingHoursAssess);

					var obj13 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessNegotiation"]').parent();
					$(obj13).empty();
					$(obj13).text(businessNegotiation);

					var obj14 = $('#tb_user tr[data-index=' + k + '] a[data-name="requestDraft"]').parent();
					$(obj14).empty();
					$(obj14).text(requestDraft);

					var obj15 = $('#tb_user tr[data-index=' + k + '] a[data-name="attendMeeting"]').parent();
					$(obj15).empty();
					$(obj15).text(attendMeeting);

					var obj16 = $('#tb_user tr[data-index=' + k + '] a[data-name="bidding"]').parent();
					$(obj16).empty();
					$(obj16).text(bidding);

					var obj17 = $('#tb_user tr[data-index=' + k + '] a[data-name="requestOaApproval"]').parent();
					$(obj17).empty();
					$(obj17).text(requestOaApproval);

					var obj18 = $('#tb_user tr[data-index=' + k + '] a[data-name="contractDraft"]').parent();
					$(obj18).empty();
					$(obj18).text(contractDraft);

					var obj19 = $('#tb_user tr[data-index=' + k + '] a[data-name="lawyerReview"]').parent();
					$(obj19).empty();
					$(obj19).text(lawyerReview);

					var obj20 = $('#tb_user tr[data-index=' + k + '] a[data-name="contractOaApproval"]').parent();
					$(obj20).empty();
					$(obj20).text(contractOaApproval);

					var obj21 = $('#tb_user tr[data-index=' + k + '] a[data-name="usageSeal"]').parent();
					$(obj21).empty();
					$(obj21).text(usageSeal);

					var obj22 = $('#tb_user tr[data-index=' + k + '] a[data-name="otherSeal"]').parent();
					$(obj22).empty();
					$(obj22).text(otherSeal);

					var obj23 = $('#tb_user tr[data-index=' + k + '] a[data-name="scan"]').parent();
					$(obj23).empty();
					$(obj23).text(scan);

					var obj24 = $('#tb_user tr[data-index=' + k + '] a[data-name="generalDepartmentFile"]').parent();
					$(obj24).empty();
					$(obj24).text(generalDepartmentFile);

					var obj25 = $('#tb_user tr[data-index=' + k + '] a[data-name="firstPayment"]').parent();
					$(obj25).empty();
					$(obj25).text(firstPayment);

					var obj26 = $('#tb_user tr[data-index=' + k + '] a[data-name="progressPayment"]').parent();
					$(obj26).empty();
					$(obj26).text(progressPayment);

					var obj27 = $('#tb_user tr[data-index=' + k + '] a[data-name="finalPayment"]').parent();
					$(obj27).empty();
					$(obj27).text(finalPayment);

					//==================产品阶段==================
					var obj28 = $('#tb_user tr[data-index=' + k + '] a[data-name="designBrief"]').parent();
					$(obj28).empty();
					$(obj28).text(designBrief);

					var obj29 = $('#tb_user tr[data-index=' + k + '] a[data-name="detailedDesign"]').parent();
					$(obj29).empty();
					$(obj29).text(detailedDesign);

					var obj30 = $('#tb_user tr[data-index=' + k + '] a[data-name="uiDesign"]').parent();
					$(obj30).empty();
					$(obj30).text(uiDesign);

					var obj31 = $('#tb_user tr[data-index=' + k + '] a[data-name="requirementDesign"]').parent();
					$(obj31).empty();
					$(obj31).text(requirementDesign);

					var obj32 = $('#tb_user tr[data-index=' + k + '] a[data-name="requirementsReview"]').parent();
					$(obj32).empty();
					$(obj32).text(requirementsReview);

					var obj33 = $('#tb_user tr[data-index=' + k + '] a[data-name="demandOrderConfirm"]').parent();
					$(obj33).empty();
					$(obj33).text(demandOrderConfirm);

					var obj34 = $('#tb_user tr[data-index=' + k + '] a[data-name="proCheckDeliver"]').parent();
					$(obj34).empty();
					$(obj34).text(proCheckDeliver);

					//==================研发阶段==================
					var obj35 = $('#tb_user tr[data-index=' + k + '] a[data-name="technologySelection"]').parent();
					$(obj35).empty();
					$(obj35).text(technologySelection);

					var obj36 = $('#tb_user tr[data-index=' + k + '] a[data-name="environmentDeployment"]').parent();
					$(obj36).empty();
					$(obj36).text(environmentDeployment);

					var obj37 = $('#tb_user tr[data-index=' + k + '] a[data-name="frameworkDesign"]').parent();
					$(obj37).empty();
					$(obj37).text(frameworkDesign);

					var obj38 = $('#tb_user tr[data-index=' + k + '] a[data-name="developProgress10"]').parent();
					$(obj38).empty();
					$(obj38).text(developProgress10);

					var obj39 = $('#tb_user tr[data-index=' + k + '] a[data-name="developProgress25"]').parent();
					$(obj39).empty();
					$(obj39).text(developProgress25);

					var obj40 = $('#tb_user tr[data-index=' + k + '] a[data-name="developProgress50"]').parent();
					$(obj40).empty();
					$(obj40).text(developProgress50);

					var obj41 = $('#tb_user tr[data-index=' + k + '] a[data-name="developProgress75"]').parent();
					$(obj41).empty();
					$(obj41).text(developProgress75);

					var obj42 = $('#tb_user tr[data-index=' + k + '] a[data-name="developProgress100"]').parent();
					$(obj42).empty();
					$(obj42).text(developProgress100);

					var obj43 = $('#tb_user tr[data-index=' + k + '] a[data-name="insideTest"]').parent();
					$(obj43).empty();
					$(obj43).text(insideTest);

					var obj44 = $('#tb_user tr[data-index=' + k + '] a[data-name="customerTest"]').parent();
					$(obj44).empty();
					$(obj44).text(customerTest);

					var obj45 = $('#tb_user tr[data-index=' + k + '] a[data-name="implementDeliver"]').parent();
					$(obj45).empty();
					$(obj45).text(implementDeliver);

					var obj46 = $('#tb_user tr[data-index=' + k + '] a[data-name="checkDeliver"]').parent();
					$(obj46).empty();
					$(obj46).text(checkDeliver);

					//==================运营阶段==================
					var obj47 = $('#tb_user tr[data-index=' + k + '] a[data-name="operationPhase"]').parent();
					$(obj47).empty();
					$(obj47).text(operationPhase);
					//==================运维阶段==================
					var obj48 = $('#tb_user tr[data-index=' + k + '] a[data-name="maintainPhase"]').parent();
					$(obj48).empty();
					$(obj48).text(maintainPhase);

				} else {
					if (!rows[k].depMiddLelevel) { //项目名称
						var obj1 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessClueOpen"]').parent();
						$(obj1).empty();
						$(obj1).text(businessClueOpen);

						var obj2 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessClose"]').parent();
						$(obj2).empty();
						$(obj2).text(businessClose);
					}
					if (!rows[k].businessManager) {
						var obj1 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessClue0"]').parent();
						$(obj1).empty();
						$(obj1).text(businessClue0);

						var obj2 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessDiscover10"]').parent();
						$(obj2).empty();
						$(obj2).text(businessDiscover10);

						var obj3 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessEstablish25"]').parent();
						$(obj3).empty();
						$(obj3).text(businessEstablish25);

						var obj4 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessEstablish50"]').parent();
						$(obj4).empty();
						$(obj4).text(businessEstablish50);

						var obj5 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessEstablish75"]').parent();
						$(obj5).empty();
						$(obj5).text(businessEstablish75);

						var obj6 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessWin100"]').parent();
						$(obj6).empty();
						$(obj6).text(businessWin100);

						var obj7 = $('#tb_user tr[data-index=' + k + '] a[data-name="customerMaintainBackMoney"]').parent();
						$(obj7).empty();
						$(obj7).text(customerMaintainBackMoney);
					}
					if (!rows[k].projectManagement) {
						var obj1 = $('#tb_user tr[data-index=' + k + '] a[data-name="initialIntentionPlan"]').parent();
						$(obj1).empty();
						$(obj1).text(initialIntentionPlan);

						var obj2 = $('#tb_user tr[data-index=' + k + '] a[data-name="writeProjectProposal"]').parent();
						$(obj2).empty();
						$(obj2).text(writeProjectProposal);

						var obj3 = $('#tb_user tr[data-index=' + k + '] a[data-name="workingHoursAssess"]').parent();
						$(obj3).empty();
						$(obj3).text(workingHoursAssess);

						var obj4 = $('#tb_user tr[data-index=' + k + '] a[data-name="businessNegotiation"]').parent();
						$(obj4).empty();
						$(obj4).text(businessNegotiation);

						var obj5 = $('#tb_user tr[data-index=' + k + '] a[data-name="requestDraft"]').parent();
						$(obj5).empty();
						$(obj5).text(requestDraft);

						var obj6 = $('#tb_user tr[data-index=' + k + '] a[data-name="attendMeeting"]').parent();
						$(obj6).empty();
						$(obj6).text(attendMeeting);

						var obj7 = $('#tb_user tr[data-index=' + k + '] a[data-name="bidding"]').parent();
						$(obj7).empty();
						$(obj7).text(bidding);

						var obj8 = $('#tb_user tr[data-index=' + k + '] a[data-name="requestOaApproval"]').parent();
						$(obj8).empty();
						$(obj8).text(requestOaApproval);

						var obj9 = $('#tb_user tr[data-index=' + k + '] a[data-name="contractDraft"]').parent();
						$(obj9).empty();
						$(obj9).text(contractDraft);

						var obj10 = $('#tb_user tr[data-index=' + k + '] a[data-name="lawyerReview"]').parent();
						$(obj10).empty();
						$(obj10).text(lawyerReview);

						var obj11 = $('#tb_user tr[data-index=' + k + '] a[data-name="contractOaApproval"]').parent();
						$(obj11).empty();
						$(obj11).text(contractOaApproval);

						var obj12 = $('#tb_user tr[data-index=' + k + '] a[data-name="usageSeal"]').parent();
						$(obj12).empty();
						$(obj12).text(usageSeal);

						var obj13 = $('#tb_user tr[data-index=' + k + '] a[data-name="otherSeal"]').parent();
						$(obj13).empty();
						$(obj13).text(otherSeal);

						var obj14 = $('#tb_user tr[data-index=' + k + '] a[data-name="scan"]').parent();
						$(obj14).empty();
						$(obj14).text(scan);

						var obj15 = $('#tb_user tr[data-index=' + k + '] a[data-name="generalDepartmentFile"]').parent();
						$(obj15).empty();
						$(obj15).text(generalDepartmentFile);

						var obj16 = $('#tb_user tr[data-index=' + k + '] a[data-name="firstPayment"]').parent();
						$(obj16).empty();
						$(obj16).text(firstPayment);

						var obj17 = $('#tb_user tr[data-index=' + k + '] a[data-name="progressPayment"]').parent();
						$(obj17).empty();
						$(obj17).text(progressPayment);

						var obj18 = $('#tb_user tr[data-index=' + k + '] a[data-name="finalPayment"]').parent();
						$(obj18).empty();
						$(obj18).text(finalPayment);

					}
					if (!rows[k].productManager) {
						var obj1 = $('#tb_user tr[data-index=' + k + '] a[data-name="designBrief"]').parent();
						$(obj1).empty();
						$(obj1).text(designBrief);

						var obj2 = $('#tb_user tr[data-index=' + k + '] a[data-name="detailedDesign"]').parent();
						$(obj2).empty();
						$(obj2).text(detailedDesign);

						var obj3 = $('#tb_user tr[data-index=' + k + '] a[data-name="uiDesign"]').parent();
						$(obj3).empty();
						$(obj3).text(uiDesign);

						var obj4 = $('#tb_user tr[data-index=' + k + '] a[data-name="requirementDesign"]').parent();
						$(obj4).empty();
						$(obj4).text(requirementDesign);

						var obj5 = $('#tb_user tr[data-index=' + k + '] a[data-name="requirementsReview"]').parent();
						$(obj5).empty();
						$(obj5).text(requirementsReview);

						var obj6 = $('#tb_user tr[data-index=' + k + '] a[data-name="demandOrderConfirm"]').parent();
						$(obj6).empty();
						$(obj6).text(demandOrderConfirm);

						var obj7 = $('#tb_user tr[data-index=' + k + '] a[data-name="proCheckDeliver"]').parent();
						$(obj7).empty();
						$(obj7).text(proCheckDeliver);
					}

					if (!rows[k].developManager) {
						var obj1 = $('#tb_user tr[data-index=' + k + '] a[data-name="technologySelection"]').parent();
						$(obj1).empty();
						$(obj1).text(technologySelection);

						var obj2 = $('#tb_user tr[data-index=' + k + '] a[data-name="environmentDeployment"]').parent();
						$(obj12).empty();
						$(obj2).text(environmentDeployment);

						var obj3 = $('#tb_user tr[data-index=' + k + '] a[data-name="frameworkDesign"]').parent();
						$(obj3).empty();
						$(obj3).text(frameworkDesign);

						var obj4 = $('#tb_user tr[data-index=' + k + '] a[data-name="developProgress10"]').parent();
						$(obj4).empty();
						$(obj4).text(developProgress10);

						var obj5 = $('#tb_user tr[data-index=' + k + '] a[data-name="developProgress25"]').parent();
						$(obj5).empty();
						$(obj5).text(developProgress25);

						var obj6 = $('#tb_user tr[data-index=' + k + '] a[data-name="developProgress50"]').parent();
						$(obj6).empty();
						$(obj6).text(developProgress50);

						var obj7 = $('#tb_user tr[data-index=' + k + '] a[data-name="developProgress75"]').parent();
						$(obj7).empty();
						$(obj7).text(developProgress75);

						var obj8 = $('#tb_user tr[data-index=' + k + '] a[data-name="developProgress100"]').parent();
						$(obj8).empty();
						$(obj8).text(developProgress100);

						var obj9 = $('#tb_user tr[data-index=' + k + '] a[data-name="insideTest"]').parent();
						$(obj9).empty();
						$(obj9).text(insideTest);

						var obj10 = $('#tb_user tr[data-index=' + k + '] a[data-name="customerTest"]').parent();
						$(obj10).empty();
						$(obj10).text(customerTest);

						var obj11 = $('#tb_user tr[data-index=' + k + '] a[data-name="implementDeliver"]').parent();
						$(obj11).empty();
						$(obj11).text(implementDeliver);

						var obj12 = $('#tb_user tr[data-index=' + k + '] a[data-name="checkDeliver"]').parent();
						$(obj12).empty();
						$(obj12).text(checkDeliver);

					}
					if (!rows[k].operateManager) {
						var obj = $('#tb_user tr[data-index=' + k + '] a[data-name="operationPhase"]').parent();
						$(obj).empty();
						$(obj).text(operationPhase);
					}

					if (!rows[k].maintainManager) {
						var obj = $('#tb_user tr[data-index=' + k + '] a[data-name="maintainPhase"]').parent();
						$(obj).empty();
						$(obj).text(maintainPhase);
					}

				}
				backlog();
				// finished();
			}
		}
	});

	$("#searchAll").on('click', function () {
		$('#tb_user').bootstrapTable('refresh');
	});
	$("#restAll").on('click', function () {
		$("#productType").val("全部");
		$("#platformName").val("全部");
		$("#groupName").val("全部");
		$('#tb_user').bootstrapTable('refresh');
	});

	//新增事件
	$("#btn_add").on('click', function () {
		$('#tb_user').bootstrapTable("resetView");
		//弹出模态框
		$("#myModal").modal();
		//给弹出框里面的各个文本框赋值
		$("#myModal input").val("");
		$("#myModal textarea").val("");
	});

});


//编辑事件
var editModel = function (id) {
	debugger
	//根据当前行的id获取当前的行数据
	var row = $("#tb_user").bootstrapTable('getRowByUniqueId', id);
	//弹出模态框
	$("#editMyModal").modal();
	//给弹出框里面的各个文本框赋值
	$("#editMyModal input[name='id']").val(id);
	$("#editMyModal input[name='productType']").val(row.productType);
	$("#editMyModal input[name='platformName']").val(row.platformName);
	$("#editMyModal input[name='groupName']").val(row.groupName);
}

//指派事件
var appointModel = function (id) {
	debugger
	//根据当前行的id获取当前的行数据
	var row = $("#tb_user").bootstrapTable('getRowByUniqueId', id);
	//弹出模态框
	$("#appointMyModal").modal();
	//给弹出框里面的各个文本框赋值
	$("#appointMyModal input[name='projectId']").val(id);
	$("#appointMyModal input[name='taskPrincipal']").val(row.taskPrincipal);
	$("#appointMyModal input[name='startTime']").val(row.startTime);
	$.ajax({
		type: "post",
		url: WEB_ROOT + "/TUserTaskController/getRollBackInfo",
		data: {"projectId": id},
		dataType: 'JSON',
		success: function (result) {
			debugger
			if (result != null && result.data != null) {
				var stage = result.data.taskName;
				$("#appointMyModal input[name='taskName']").val(stage);
				if (result.data.taskType == "01") {
					var head = result.data.taskPrincipal;
					var apponitTime = result.data.startTime;
					$("#appointMyModal input[name='taskPrincipal']").val(head);
					$("#appointMyModal input[name='startTime']").val(apponitTime);
				}
			}
		},
		error: function (result) {
			msgInfoModal('提示', result.msg);
		}
	});
}
//审核事件
var examine = function (id) {
	debugger
	//根据当前行的id获取当前的行数据
	var row = $("#tb_user").bootstrapTable('getRowByUniqueId', id);
	$("#ww").val(id);
	//弹出模态框
	$("#examineModel").modal();

}
//删除事件
var deleteModel = function (id) {
	confirmModal("提示", "是否确定要删除该项目信息？", function () {
		$.ajax({
			type: "post",
			url: WEB_ROOT + "/sugarManage/delete",
			data: "id=" + id,
			dataType: 'JSON',
			success: function (status) {
				confirmModal("提示", "删除成功！", function () {
					window.location.reload();
				}, {}, function () {
					window.location.reload();
				});
			},
			error: function () {
				msgInfoModal('提示', "删除失败");
			}
		});
	}, {}, function () {
		//window.location.reload();
	});
};

function exportSugar() {
	var url = WEB_ROOT + "/sugarManage/exportSugarExcle";
	window.open(url);
}

//指派保存
function saveAppointInfo() {
	debugger
	$.ajax({
		type: "post",
		url: WEB_ROOT + "/TUserTaskController/addEntrustInfo",
		data: $("#appointForm").serialize(),
		dataType: 'JSON',
		success: function (result) {
			debugger
			confirmModal("提示", result.msg, function () {
				window.location.reload();
			}, {}, function () {
				window.location.reload();
			});
		},
		error: function () {
			msgInfoModal('提示', "指派失败");
		}
	});
}
//审核
function examineAj(e) {
	debugger
//根据当前行的id获取当前的行数据
	var projectId=document.getElementById("ww").value;
	$.ajax({
		type: "post",
		url: WEB_ROOT + "/TUserTaskController/examine",
		data: {"projectId":projectId,"staus":e},
		success: function (result) {
			debugger
			confirmModal("提示", "审核成功通过！", function () {
				window.location.reload();
			})
		},
		error: function () {
			msgInfoModal('提示', "不通过");
		}
	});
}
function saveProjectInfo() {
	$.ajax({
		type: "post",
		url: WEB_ROOT + "/sugarManage/Edit",
		data: $("#editForm").serialize(),
		dataType: 'JSON',
		success: function (data) {
			//location.reload();
			confirmModal("提示", "更新成功！", function () {
				window.location.reload();
			}, {}, function () {
				window.location.reload();
			});
		},
		error: function () {
			msgInfoModal('提示', "更新失败");
		}
	});
}

function addProject() {
	$.ajax({
		type: "post",
		url: WEB_ROOT + "/sugarManage/newlyAdded",
		data: $("#addForm").serialize(),
		dataType: 'JSON',
		success: function (result) {
			confirmModal("提示", result.msg, function () {
				window.location.reload();
			}, {}, function () {
				window.location.reload();
			});
		},
		error: function () {
			msgInfoModal('提示', "新增失败");
		}
	});
}


function selectHideRow(_this) {
	showWaiting();
	var selectValue = $(_this).val();
	if (selectValue != null) {
		//var selectList = "1,2,3".split(",");
		for (var i = 0; i < selectValue.length; i++) {
			var value = selectValue[i];
			switch (value) {
				case '1':
					$('#tb_user').bootstrapTable('hideColumn', 'businessClueOpen');
					$('#tb_user').bootstrapTable('hideColumn', 'businessClue0');
					$('#tb_user').bootstrapTable('hideColumn', 'businessDiscover10');
					$('#tb_user').bootstrapTable('hideColumn', 'businessEstablish25');
					$('#tb_user').bootstrapTable('hideColumn', 'businessEstablish50');
					$('#tb_user').bootstrapTable('hideColumn', 'businessEstablish75');
					$('#tb_user').bootstrapTable('hideColumn', 'businessWin100');
					$('#tb_user').bootstrapTable('hideColumn', 'customerMaintainBackMoney');
					$('#tb_user').bootstrapTable('hideColumn', 'businessClose');
					break;
				case '2':
					$('#tb_user').bootstrapTable('hideColumn', 'initialIntentionPlan');
					$('#tb_user').bootstrapTable('hideColumn', 'writeProjectProposal');
					$('#tb_user').bootstrapTable('hideColumn', 'workingHoursAssess');
					$('#tb_user').bootstrapTable('hideColumn', 'businessNegotiation');
					$('#tb_user').bootstrapTable('hideColumn', 'requestDraft');
					$('#tb_user').bootstrapTable('hideColumn', 'attendMeeting');
					$('#tb_user').bootstrapTable('hideColumn', 'bidding');
					$('#tb_user').bootstrapTable('hideColumn', 'requestOaApproval');
					$('#tb_user').bootstrapTable('hideColumn', 'contractDraft');
					$('#tb_user').bootstrapTable('hideColumn', 'lawyerReview');
					$('#tb_user').bootstrapTable('hideColumn', 'contractOaApproval');
					$('#tb_user').bootstrapTable('hideColumn', 'usageSeal');
					$('#tb_user').bootstrapTable('hideColumn', 'otherSeal');
					$('#tb_user').bootstrapTable('hideColumn', 'scan');
					$('#tb_user').bootstrapTable('hideColumn', 'generalDepartmentFile');
					$('#tb_user').bootstrapTable('hideColumn', 'firstPayment');
					$('#tb_user').bootstrapTable('hideColumn', 'progressPayment');
					$('#tb_user').bootstrapTable('hideColumn', 'finalPayment');
					break;
				case '3':
					$('#tb_user').bootstrapTable('hideColumn', 'designBrief');
					$('#tb_user').bootstrapTable('hideColumn', 'detailedDesign');
					$('#tb_user').bootstrapTable('hideColumn', 'uiDesign');
					$('#tb_user').bootstrapTable('hideColumn', 'requirementDesign');
					$('#tb_user').bootstrapTable('hideColumn', 'requirementsReview');
					$('#tb_user').bootstrapTable('hideColumn', 'demandOrderConfirm');
					$('#tb_user').bootstrapTable('hideColumn', 'proCheckDeliver');
					break;
				case '4':
					$('#tb_user').bootstrapTable('hideColumn', 'technologySelection');
					$('#tb_user').bootstrapTable('hideColumn', 'environmentDeployment');
					$('#tb_user').bootstrapTable('hideColumn', 'frameworkDesign');
					$('#tb_user').bootstrapTable('hideColumn', 'developProgress10');
					$('#tb_user').bootstrapTable('hideColumn', 'developProgress25');
					$('#tb_user').bootstrapTable('hideColumn', 'developProgress50');
					$('#tb_user').bootstrapTable('hideColumn', 'developProgress75');
					$('#tb_user').bootstrapTable('hideColumn', 'developProgress100');
					$('#tb_user').bootstrapTable('hideColumn', 'insideTest');
					$('#tb_user').bootstrapTable('hideColumn', 'customerTest');
					$('#tb_user').bootstrapTable('hideColumn', 'implementDeliver');
					$('#tb_user').bootstrapTable('hideColumn', 'checkDeliver');
					break;
				case '5':
					$('#tb_user').bootstrapTable('hideColumn', 'operationPhase');
					break;
				case '6':
					$('#tb_user').bootstrapTable('hideColumn', 'maintainPhase');
					break;
			}
		}
		roolBack(selectValue);
		for (var i = 0; i < selectValue.length; i++) {
			var value = selectValue[i];

			switch (value) {
				case '1':
					$(".th_red").hide();
					break;
				case '2':
					$(".th_orange").hide();
					break;
				case '3':
					$(".th_yellow").hide();
					break;
				case '4':
					$(".th_darkblue").hide();
					break;
				case '5':
					$(".th_purple").hide();
					break;
				case '6':
					$(".th_darkred").hide();
					break;
			}
		}

	} else {
		$('#tb_user').bootstrapTable('showColumn', 'businessClueOpen');
		$('#tb_user').bootstrapTable('showColumn', 'businessClue0');
		$('#tb_user').bootstrapTable('showColumn', 'businessDiscover10');
		$('#tb_user').bootstrapTable('showColumn', 'businessEstablish25');
		$('#tb_user').bootstrapTable('showColumn', 'businessEstablish50');
		$('#tb_user').bootstrapTable('showColumn', 'businessEstablish75');
		$('#tb_user').bootstrapTable('showColumn', 'businessWin100');
		$('#tb_user').bootstrapTable('showColumn', 'customerMaintainBackMoney');
		$('#tb_user').bootstrapTable('showColumn', 'businessClose');
		$('#tb_user').bootstrapTable('showColumn', 'initialIntentionPlan');
		$('#tb_user').bootstrapTable('showColumn', 'writeProjectProposal');
		$('#tb_user').bootstrapTable('showColumn', 'workingHoursAssess');
		$('#tb_user').bootstrapTable('showColumn', 'businessNegotiation');
		$('#tb_user').bootstrapTable('showColumn', 'requestDraft');
		$('#tb_user').bootstrapTable('showColumn', 'attendMeeting');
		$('#tb_user').bootstrapTable('showColumn', 'bidding');
		$('#tb_user').bootstrapTable('showColumn', 'requestOaApproval');
		$('#tb_user').bootstrapTable('showColumn', 'contractDraft');
		$('#tb_user').bootstrapTable('showColumn', 'lawyerReview');
		$('#tb_user').bootstrapTable('showColumn', 'contractOaApproval');
		$('#tb_user').bootstrapTable('showColumn', 'usageSeal');
		$('#tb_user').bootstrapTable('showColumn', 'otherSeal');
		$('#tb_user').bootstrapTable('showColumn', 'scan');
		$('#tb_user').bootstrapTable('showColumn', 'generalDepartmentFile');
		$('#tb_user').bootstrapTable('showColumn', 'firstPayment');
		$('#tb_user').bootstrapTable('showColumn', 'progressPayment');
		$('#tb_user').bootstrapTable('showColumn', 'finalPayment');
		$('#tb_user').bootstrapTable('showColumn', 'designBrief');
		$('#tb_user').bootstrapTable('showColumn', 'detailedDesign');
		$('#tb_user').bootstrapTable('showColumn', 'uiDesign');
		$('#tb_user').bootstrapTable('showColumn', 'requirementDesign');
		$('#tb_user').bootstrapTable('showColumn', 'requirementsReview');
		$('#tb_user').bootstrapTable('showColumn', 'demandOrderConfirm');
		$('#tb_user').bootstrapTable('showColumn', 'proCheckDeliver');
		$('#tb_user').bootstrapTable('showColumn', 'technologySelection');
		$('#tb_user').bootstrapTable('showColumn', 'environmentDeployment');
		$('#tb_user').bootstrapTable('showColumn', 'frameworkDesign');
		$('#tb_user').bootstrapTable('showColumn', 'developProgress10');
		$('#tb_user').bootstrapTable('showColumn', 'developProgress25');
		$('#tb_user').bootstrapTable('showColumn', 'developProgress50');
		$('#tb_user').bootstrapTable('showColumn', 'developProgress75');
		$('#tb_user').bootstrapTable('showColumn', 'developProgress100');
		$('#tb_user').bootstrapTable('showColumn', 'insideTest');
		$('#tb_user').bootstrapTable('showColumn', 'customerTest');
		$('#tb_user').bootstrapTable('showColumn', 'implementDeliver');
		$('#tb_user').bootstrapTable('showColumn', 'checkDeliver');
		$('#tb_user').bootstrapTable('showColumn', 'operationPhase');
		$('#tb_user').bootstrapTable('showColumn', 'maintainPhase');
	}

	hideWaiting();
}

function roolBack(selectValue) {

	if (selectValue.indexOf('1') == -1) {

		$('#tb_user').bootstrapTable('showColumn', 'businessClueOpen');
		$('#tb_user').bootstrapTable('showColumn', 'businessClue0');
		$('#tb_user').bootstrapTable('showColumn', 'businessDiscover10');
		$('#tb_user').bootstrapTable('showColumn', 'businessEstablish25');
		$('#tb_user').bootstrapTable('showColumn', 'businessEstablish50');
		$('#tb_user').bootstrapTable('showColumn', 'businessEstablish75');
		$('#tb_user').bootstrapTable('showColumn', 'businessWin100');
		$('#tb_user').bootstrapTable('showColumn', 'customerMaintainBackMoney');
		$('#tb_user').bootstrapTable('showColumn', 'businessClose');
	}
	if (selectValue.indexOf('2') == -1) {

		$('#tb_user').bootstrapTable('showColumn', 'initialIntentionPlan');
		$('#tb_user').bootstrapTable('showColumn', 'writeProjectProposal');
		$('#tb_user').bootstrapTable('showColumn', 'workingHoursAssess');
		$('#tb_user').bootstrapTable('showColumn', 'businessNegotiation');
		$('#tb_user').bootstrapTable('showColumn', 'requestDraft');
		$('#tb_user').bootstrapTable('showColumn', 'attendMeeting');
		$('#tb_user').bootstrapTable('showColumn', 'bidding');
		$('#tb_user').bootstrapTable('showColumn', 'requestOaApproval');
		$('#tb_user').bootstrapTable('showColumn', 'contractDraft');
		$('#tb_user').bootstrapTable('showColumn', 'lawyerReview');
		$('#tb_user').bootstrapTable('showColumn', 'contractOaApproval');
		$('#tb_user').bootstrapTable('showColumn', 'usageSeal');
		$('#tb_user').bootstrapTable('showColumn', 'otherSeal');
		$('#tb_user').bootstrapTable('showColumn', 'scan');
		$('#tb_user').bootstrapTable('showColumn', 'generalDepartmentFile');
		$('#tb_user').bootstrapTable('showColumn', 'firstPayment');
		$('#tb_user').bootstrapTable('showColumn', 'progressPayment');
		$('#tb_user').bootstrapTable('showColumn', 'finalPayment');
	}
	if (selectValue.indexOf('3') == -1) {

		$('#tb_user').bootstrapTable('showColumn', 'designBrief');
		$('#tb_user').bootstrapTable('showColumn', 'detailedDesign');
		$('#tb_user').bootstrapTable('showColumn', 'uiDesign');
		$('#tb_user').bootstrapTable('showColumn', 'requirementDesign');
		$('#tb_user').bootstrapTable('showColumn', 'requirementsReview');
		$('#tb_user').bootstrapTable('showColumn', 'demandOrderConfirm');
		$('#tb_user').bootstrapTable('showColumn', 'proCheckDeliver');
	}
	if (selectValue.indexOf('4') == -1) {

		$('#tb_user').bootstrapTable('showColumn', 'technologySelection');
		$('#tb_user').bootstrapTable('showColumn', 'environmentDeployment');
		$('#tb_user').bootstrapTable('showColumn', 'frameworkDesign');
		$('#tb_user').bootstrapTable('showColumn', 'developProgress10');
		$('#tb_user').bootstrapTable('showColumn', 'developProgress25');
		$('#tb_user').bootstrapTable('showColumn', 'developProgress50');
		$('#tb_user').bootstrapTable('showColumn', 'developProgress75');
		$('#tb_user').bootstrapTable('showColumn', 'developProgress100');
		$('#tb_user').bootstrapTable('showColumn', 'insideTest');
		$('#tb_user').bootstrapTable('showColumn', 'customerTest');
		$('#tb_user').bootstrapTable('showColumn', 'implementDeliver');
		$('#tb_user').bootstrapTable('showColumn', 'checkDeliver');
	}
	if (selectValue.indexOf('5') == -1) {

		$('#tb_user').bootstrapTable('showColumn', 'operationPhase');
	}
	if (selectValue.indexOf('6') == -1) {

		$('#tb_user').bootstrapTable('showColumn', 'maintainPhase');
	}

}