
(function ($) {
    ko.bindingEditViewModel = function (data) {

        var that = {};

        that.editModel = ko.mapping.fromJS(data.editModel);

        that.default = {
            message: '验证不通过',
            fields: { },
            submitHandler: function (validator, form, submitButton) {
                //var data = form.getValue();
                var arrselectedData = ko.toJS(that.editModel);
                $.ajax({
                    url: data.urls.submit,
                    type: "post",
                    contentType: 'application/json',
                    data: JSON.stringify(arrselectedData),
                    success: function (data, status) {
                        alert(status);
                    }
                });
                $("#myModal").modal("hide");
            }
        };
        that.params = $.extend({}, that.default, data.validator || {});

        $('#' + data.formId).bootstrapValidator(that.params);

        ko.applyBindings(that, document.getElementById(data.formId));
    };


})(jQuery);