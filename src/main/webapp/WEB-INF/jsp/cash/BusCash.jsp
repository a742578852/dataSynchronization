<%@include file="../head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
        <span class="c-gray en">&gt;</span>
        提现管理
        <span class="c-gray en">&gt;</span>
        商家提现
    </nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <form action="/Cash/toBusCash" method="post"id="form">
                <input type="hidden" id="currentPage" name="currentPage">

                <div class="text-c">
                    提现发起时间:
                    <input type="date" name="createtime" style="width:250px" value="${createtime}" class="input-text">
                    &nbsp;&nbsp;&nbsp;



                    提现处理状态:
                    <select style="width:260px;height: auto" class="input-text" name="type" id="type">
                        <option value="${type}">${typeName}(默认)</option>
                        <option value="0">待处理</option>
                        <option value="1">提现完成</option>
                        <option value="2">提现失败</option>
                    </select>

                    <button name="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查询</button>
                </div>
            </form>
            <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">


                      <script type="text/javascript">

        /*用户-编辑*/
        function csshenhe(title,url,id,w,h){
            layer_show(title,url,w,h);
        }
        </script>
				</span>
                <span class="r">共有数据：<strong>${count}</strong> 条</span>
            </div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">

                        <th width="60">编号</th>
                        <th width="50">提现人用户名</th>
                        <th width="50">持卡人姓名</th>
                        <th width="50">开户手机号</th>
                        <th width="50">提现银行卡号</th>
                        <th width="50">提现银行</th>
                        <th width="50">提现金额</th>
                        <th width="50">创建时间</th>
                        <th width="40">操作</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${withList.lists}" var="with">
                        <tr class="text-c">

                            <td>${with.id}</td>
                            <td>${with.userName}</td>
                            <td>${with.name}</td>
                            <td>${with.phone}</td>
                            <td>${with.bankCard}</td>
                            <td>${with.bankName}</td>
                            <td>${with.price}元</td>
                            <td>${with.createTime}</td>


                            <!--<td class="td-status"><span class="label label-success radius">已发布</span></td>-->
                            <td <c:if test="${with.type != 0}">hidden</c:if> class="f-14 td-manage">

                                <a style="text-decoration:none" class="ml-5" onclick="xiu('${with.id}')"    title="提现成功"><i class="Hui-iconfont">&#xe6df;</i></a>
                                <a style="text-decoration:none" class="ml-5" onclick="del('${with.id}')" href="javascript:;" title="提现失败"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
                            <script type="text/javascript">
                                function xiu(id) {

                                   $.ajax({
                                       url:"${pageContext.request.contextPath}/Cash/updateWith",
                                       data:{"id":id,"sign":1,"message":"提现成功"},
                                       type:"POST",
                                       dataType:"JSON",
                                       success:function (data) {
                                           if (data.result>0){

                                               location.href="${pageContext.request.contextPath}/Cash/toBusCash";
                                           } else {
                                               alert("操作失败")
                                           }
                                       }
                                   })
                                }
                                function del(id) {
                                    var code = prompt("请填写提现失败原因");

                                        $.ajax({
                                            url:"${pageContext.request.contextPath}/Cash/updateWith",
                                            data:{"id":id,"sign":2,"message":code},
                                            type:"POST",
                                            dataType:"JSON",
                                            success:function (data) {
                                                if (data.result>0){

                                                    location.href="${pageContext.request.contextPath}/Cash/toBusCash";
                                                } else {
                                                    alert("操作失败")
                                                }
                                            }
                                        })

                                }
                            </script>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5">
                            <a href="javascript:jump('1')">首页</a>
                            <a href="javascript:jump(${withList.currentPage-1})">上一页</a>
                            <a href="javascript:jump(${withList.currentPage+1})">下一页</a>
                            <a href="javascript:jump(${withList.totalPage})">末页</a>
                            跳转至:<input type="text" id="page"><input type="button" id="btn" value="跳转">
                            当前${withList.currentPage}/${withList.totalPage}页
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