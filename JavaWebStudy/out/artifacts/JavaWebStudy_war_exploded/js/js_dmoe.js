/**
 * Created by FANGYI on 2016/12/4.
 */
// alert("hello js!");

function changeCode() {
    var img = document.getElementById("a_btn")[0];
    // img.setAttribute("src","/httpServletResponseDemo2");//XML Dom语法
    img.src = "/httpServletResponseDemo2?time="+new Date().getTime();
}