
ko.bindingHandlers.MySelect = {
    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
        var oParam = valueAccessor();
        $(element).multiselect(oParam);
    },

    update: function (element, valueAccessor, allBindingsAccessor, viewModel) {

    }
};

$(function () {
    //ko.MySelect = {
    //    MyViewModel: function (params) {

    //    }
    //};

    var MultiSelect = {
        enableClickableOptGroups: true,//收起分组
        onChange: function (option, checked) {
            alert("选择改变");
        }
    };
    ko.applyBindings(MultiSelect);
});

//var myViewModel = {};

//ko.applyBindings(myViewModel);

