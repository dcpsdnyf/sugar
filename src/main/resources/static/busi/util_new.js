
/**
 * 重写确认框 fun:函数对象 params:参数列表， 可以是数组, content 确认框展示的内容
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
 <div class="modal-dialog" role="document">
 <div class="modal-content">
 <div class="modal-header">
 <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
 <h4 class="modal-title" th:id="modelTitle">标题名称</h4>
 </div>
 <div class="modal-body" th:id="modelContent">
 文字内容
 </div>
 <div class="modal-footer">
 <button type="button" class="btn btn-primary" th:id="modelBtn">确定</button>
 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
 </div>
 </div>
 </div>
 </div>
 */

function msgInfoModal(title,content,okFunction) {
    if ($("#myConfirm").length > 0) {
        $("#myConfirm").remove();
    }

    let _html = "<div class=\"modal fade\" id=\"myConfirm\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\n" +
         " <div class=\"modal-dialog\" role=\"document\">\n" +
         " <div class=\"modal-content\">\n" +
         " <div class=\"modal-header\">\n" +
         " <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
         " <h4 class=\"modal-title\" th:id=\"modelTitle\">"+title+"</h4>\n" +
         " </div>\n" +
         " <div class=\"modal-body\" th:id=\"modelContent\">\n" +content +
         " </div>\n" +
         " <div class=\"modal-footer\">\n" +
         " <button type=\"button\" class=\"btn btn-primary\" id=\"confirmOk\">确定</button>\n" +
         " </div>\n" +
         " </div>\n" +
         " </div>\n" +
         " </div>";

     $("body").append(_html);

     $("#myConfirm").modal("show");

     $("#confirmOk").on("click", function() {
         $("#myConfirm").modal("hide");
         if(typeof okFunction === "function"){
             okFunction();
         }
     });
}
/**
* 重写确认框 fun:函数对象 params:参数列表， 可以是数组, content 确认框展示的内容
*/
function confirmModal(title,content,fun, params,cancelFun ) {
     if ($("#myConfirm").length > 0) {
         $("#myConfirm").remove();
     }
    let _html = "<div class=\"modal fade\" id=\"myConfirm\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\"> \n" +
        " <div class=\"modal-dialog\" role=\"document\">\n" +
        " <div class=\"modal-content\">\n" +
        " <div class=\"modal-header\">\n" +
        " <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
        " <h4 class=\"modal-title\" th:id=\"modelTitle\">"+title+"</h4>\n" +
        " </div>\n" +
        " <div class=\"modal-body\" th:id=\"modelContent\">\n" +content +
        " </div>\n" +
        " <div class=\"modal-footer\">\n" +
        " <button type=\"button\" class=\"btn btn-primary\" id=\"confirmOk\">确定</button>\n" +
        " <button type=\"button\" class=\"btn btn-default\" id=\"cancelOk\">取消</button>" +
        " </div>\n" +
        " </div>\n" +
        " </div>\n" +
        " </div>";
    $("body").append(_html);

//    $("#myConfirm").modal({backdrop:false,keyboard:false});  data-dismiss="modal"
    $("#myConfirm").modal({backdrop:'static',keyboard:false});
    $("#myConfirm").modal("show");

    //若有取消函数，则当模态框关闭后，执行该函数
   /* if(typeof cancelFun === "function"){
        $("#myConfirm").on('hide.bs.modal', function () {
            cancelFun();
        })
    }*/

    $("#cancelOk").on("click", function() {
        $("#myConfirm").modal("hide");
        $('.modal-backdrop').remove();
        //fun(params); // 执行函数;
        setTimeout(function(){
            if(typeof cancelFun === "function"){
                cancelFun(params); // 执行函数;
            }
        },100);
    });

    //确定按钮绑定单击函数
    $("#confirmOk").on("click", function() {
        $("#myConfirm").modal("hide");
        $('.modal-backdrop').remove();
        //fun(params); // 执行函数;
        setTimeout(function(){
            if(typeof fun === "function"){
                fun(params); // 执行函数;
            }
        },100);
    });
}

/**
 * 重写确认框 fun:函数对象 params:参数列表， 可以是数组, content 确认框展示的内容
 */
function confirmModalBtn(title,content,fun, params,cancelFun,okBtnTitle,cancleBtnTitle ) {
    if ($("#myConfirm").length > 0) {
        $("#myConfirm").remove();
    }
    let _html = "<div class=\"modal fade\" id=\"myConfirm\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\"> \n" +
        " <div class=\"modal-dialog\" role=\"document\">\n" +
        " <div class=\"modal-content\">\n" +
        " <div class=\"modal-header\">\n" +
        " <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
        " <h4 class=\"modal-title\" th:id=\"modelTitle\">"+title+"</h4>\n" +
        " </div>\n" +
        " <div class=\"modal-body\" th:id=\"modelContent\">\n" +content +
        " </div>\n" +
        " <div class=\"modal-footer\">\n" +
        " <button type=\"button\" class=\"btn btn-primary\" id=\"confirmOk\">"+okBtnTitle+"</button>\n" +
        " <button type=\"button\" class=\"btn btn-default\" id=\"cancelOk\">"+cancleBtnTitle+"</button>" +
        " </div>\n" +
        " </div>\n" +
        " </div>\n" +
        " </div>";
    $("body").append(_html);

//    $("#myConfirm").modal({backdrop:false,keyboard:false});  data-dismiss="modal"
    $("#myConfirm").modal({backdrop:'static',keyboard:false});
    $("#myConfirm").modal("show");

    //若有取消函数，则当模态框关闭后，执行该函数
    /* if(typeof cancelFun === "function"){
         $("#myConfirm").on('hide.bs.modal', function () {
             cancelFun();
         })
     }*/

    $("#cancelOk").on("click", function() {
        $("#myConfirm").modal("hide");
        $('.modal-backdrop').remove();
        //fun(params); // 执行函数;
        setTimeout(function(){
            if(typeof cancelFun === "function"){
                cancelFun(params); // 执行函数;
            }
        },100);
    });

    //确定按钮绑定单击函数
    $("#confirmOk").on("click", function() {
        $("#myConfirm").modal("hide");
        $('.modal-backdrop').remove();
        //fun(params); // 执行函数;
        setTimeout(function(){
            if(typeof fun === "function"){
                fun(params); // 执行函数;
            }
        },100);
    });
}

/***
 * 判断输入的字符是否是数字
 * @param nubmer
 * @returns {boolean}
 */
function checkNumber(nubmer) {
    var re = /^[0-9]+.?[0-9]*$/;   //判断字符串是否为数字     //判断正整数 /^[1-9]+[0-9]*]*$/
    if (!re.test(nubmer)) {
        return false;
    }
    return true;
}

/**
 * 判断是否为价格
 * @param obj
 * @returns {boolean}
 */
function isPrice(obj) {
    if(obj == null || obj == ""){
        return false;
    }
    obj = obj.replace(/(^\s*)|(\s*$)/g, "");;
    var p =/^[1-9](\d+(\.\d{1,2})?)?$/;
    var p1=/^[0-9](\.\d{1,2})?$/;
    return p.test(obj) || p1.test(obj);
}

/**
 * 获取两位小数的价格
 * @param price
 */
function getToFixed(priceTotal) {
    if(!isNaN(parseFloat(priceTotal))) {
        priceTotal = priceTotal.toFixed(2);
    }
    return priceTotal;
}

/**
 * 判断是否是空字符串
 * @param str
 * @returns {boolean}
 */
function isStrNull(str) {
    if(str != null && str != undefined && str != ""){
        return false;
    } else {
        return true;
    }
}

/**
 * 是否是正确的手机号码
 * @param needle
 * @returns {boolean}
 */
function cellphone(needle) {
    return /^1[^012]\d{9}$/.test(needle);
}

/**
 * 是否是正确的身份证号
 * @param needle
 * @returns {boolean}
 */
function chineseId(needle) {
    return /^\d{15}(\d{2}[0-9X])?$/.test(needle);
}

/**
 * 是否是邮政编码
 * @param postCode
 * @returns {boolean}
 */
function checkPostCode(postCode) {
    return /^[1-9][0-9]{5}$/.test(postCode);
}

//加法函数，用来得到精确的加法结果
//javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
function accAdd(arg1,arg2){

    var r1,r2,m;

    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}

    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}

    m=Math.pow(10,Math.max(r1,r2));

    return (accMul(arg1,m)+accMul(arg2,m))/m;

}

//javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。
function accMul(arg1,arg2){

    var m=0,s1=arg1.toString(),s2=arg2.toString();

    try{m+=s1.split(".")[1].length}catch(e){}

    try{m+=s2.split(".")[1].length}catch(e){}

    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)

}


function pcLoading(content){
    if ($("#loadingModal").length > 0) {
        $("#loadingModal").remove();
    }
    var loadingHtml = "<div class=\"modal fade\" id=\"loadingModal\" backdrop=\"static\" keyboard=\"false\">\n" +
        "    <div style=\"width: 400px;height:100px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:-10px\">\n" +
        "        <div class=\"progress progress-striped active\"\n" +
        "             style=\"margin-bottom: 0;height:50px; text-align:center;line-height: 50px;font-size:18px;\">\n" +
        content +
        "        </div>\n" +
        "    </div>\n" +
        "</div>\n";
    $("body").append(loadingHtml);
    $("#loadingModal").modal({backdrop:'static',keyboard:false});
    $("#loadingModal").modal("show");
}

function unPcLoading(){
    $("#loadingModal").modal("hide");
}


