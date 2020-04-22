function changeNum(id,inputObj) {
    var num=$(inputObj).val();
    if (num==null|| num==""){
        alert("数量不能为空");
        $(this).val(num);
        return;
    }
    window.location="cart.action?id="+id+"&num="+num+"&param=1";
}
function jian(id,inputObj) {
    var num=$(inputObj).parent().find("input[id*=amount]").val();
    if (num<=1){
        alert("数量不能小于1");
    }else {
        $(inputObj).parent().find("input[id*=amount]").val(--num);
    }
    window.location="cart.action?id="+id+"&num="+num+"&param=1";
}
function jia(id,inputObj) {
    var num=$(inputObj).parent().find("input[id*=amount]").val();
    $(inputObj).parent().find("input[id*=amount]").val(++num);
    window.location="cart.action?id="+id+"&num="+num+"&param=1";
}
function del(id) {
    var flag=confirm("确定要删除码？");
    if (flag==true){
        window.location="cart.action?id="+id+"&param=2"
    }
}
