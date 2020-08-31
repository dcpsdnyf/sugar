﻿

(function ($) {
    //向ko里面新增一个bootstrapTableViewModel方法
    ko.bootstrapTableViewModel = function (options) {
        var that = this;

        this.default = {
            toolbar: '#toolbar',                //工具按钮用哪个容器
            queryParams: function (param) {
                return { limit: param.limit, offset: param.offset };
            },//传递参数（*）
            pagination: true,                   //是否显示分页（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                      //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            method: 'get',
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            cache:false,
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            showToggle: true,
        };
        this.params = $.extend({}, this.default, options || {});

        //得到选中的记录
        this.getSelections = function () {
            var arrRes = that.bootstrapTable("getSelections")
            return arrRes;
        };

        //刷新
        this.refresh = function () {
            that.bootstrapTable("refresh");
            //debugger;
            //var data = that.bootstrapTable("getData");
            //var searchData = [];
            //$.each(data, function (key, item) {
            //    if (item.Name.indexOf($('#txt_search_departmentname').val()) >= 0) {
            //        searchData.push(item);
            //    }
            //});
            //that.bootstrapTable("refresh");
        };
        

    };

    //添加ko自定义绑定
    ko.bindingHandlers.bootstrapTable = {
        init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
            //这里的oParam就是绑定的viewmodel
            var oViewModel = valueAccessor();
            var $ele = $(element).bootstrapTable(oViewModel.params);
            //给viewmodel添加bootstrapTable方法
            oViewModel.bootstrapTable = function () {
                return $ele.bootstrapTable.apply($ele, arguments);
            }
        },

        update: function (element, valueAccessor, allBindingsAccessor, viewModel) {

        }
    };
})(jQuery);

