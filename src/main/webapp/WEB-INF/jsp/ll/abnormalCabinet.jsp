<%@include file="../head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
        <span class="c-gray en">&gt;</span>
        柜体信息
        <span class="c-gray en">&gt;</span>
        柜格信息
    </nav>
    <div class="Hui-article">
        <article class="cl pd-20">

            <form action="/web/goCabCell" method="post"id="form">
                <input type="hidden" id="currentPage" name="currentPage" >


            </form>

            <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">


                      <script type="text/javascript">

                          function dingshi() {

                              window.location.reload();

                          }
                          setInterval(dingshi,30000);

        /*用户-编辑*/
        function csshenhe(title,url,id,w,h){
            layer_show(title,url,w,h);
        }
        </script>
				</span>

                <span style="color: red" class="r">异常柜子：<strong>${count}</strong> 个</span>
                <br/>

            </div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">

                        <th width="60">柜子编号</th>
                        <th width="50">柜格编号</th>
                        <th width="50">响应时间</th>
                        <th width="50">上次请求时间</th>
                        <th width="50">温度</th>
                        <th width="50">订单号</th>
                        <th width="50">柜格状态</th>
                        <th width="50">取件码</th>
                        <th width="50">更新时间</th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${abnormalCabcells.lists}" var="cabinetst">
                        <tr class="text-c">

                            <td>${cabinetst.cabinetid}</td>
                            <td>${cabinetst.cellid}</td>
                            <td>${cabinetst.overtime}</td>
                            <td>${cabinetst.logtime}</td>
                            <td>${cabinetst.temperature}</td>
                            <td>${cabinetst.order_sn}</td>
                            <td>${cabinetst.cellstatus}</td>
                            <td>${cabinetst.deliverycode}</td>
                            <td>${cabinetst.TemperatureTime}</td>


                            <script type="text/javascript">


                            </script>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5">
                            <a href="javascript:jump('1')">首页</a>
                            <a href="javascript:jump(${abnormalCabcells.currentPage-1})">上一页</a>
                            <a href="javascript:jump(${abnormalCabcells.currentPage+1})">下一页</a>
                            <a href="javascript:jump(${abnormalCabcells.totalPage})">末页</a>
                            跳转至:<input type="text" id="page"><input type="button" id="btn" value="跳转">
                            当前${abnormalCabcells.currentPage}/${abnormalCabcells.totalPage}页
                        </td>
                        <script type="text/javascript">
                            function jump(page){
                                $("#currentPage").val(page);
                                $("#form").submit();
                            }
                            $("#btn").click(function () {
                                var p = $("#page").val();
                                $("#currentPage").val(p);
                                $("#form").submit();
                            })
                        </script>
                    </tr>
                    </tbody>
                </table>
            </div>
        </article>
    </div>
    <script type="text/javascript">
        /*用户-编辑*/
        function caidingming(title,url,id,w,h){
            layer_show(title,url,w,h);
        }
        function caishen(title,url,id,w,h){
            layer_show(title,url,w,h);
        }
    </script>
</section>
<%@include file="../footer.jsp"%>